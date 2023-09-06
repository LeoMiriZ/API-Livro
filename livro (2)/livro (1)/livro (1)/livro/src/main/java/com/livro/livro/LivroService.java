package com.livro.livro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroTO> list() {
        List<LivroTO> livros = new ArrayList<>();
        livroRepository.findAll().forEach(l -> 
            livros.add(new LivroTO(l.getId(), l.getTitulo(), l.getAutor(), l.getEditora(),l.getAno(),l.getPreco())));
        return livros;
    }

    public LivroTO find(String id) {
        return livroRepository.findById(id)
            .map(l -> new LivroTO(l.getId(), l.getTitulo(),  l.getAutor(), l.getEditora(),l.getAno(),l.getPreco()))
            .orElse(null);
    }

    public void create(LivroTO livro) {
        livroRepository.save(new Livro(livro));
    }

    public void delete(String id) {
        livroRepository.deleteById(id);
    }

    public void update(String id, LivroTO in) {

        livroRepository.findById(id).ifPresent(l -> {
            l.setTitulo(in.titulo());
            l.setAutor(in.autor());
            l.setEditora(in.editora());
            l.setAno(in.ano());
            l.setPreco(in.preco());
            livroRepository.save(l);
        });
    }
    

    
    
}
