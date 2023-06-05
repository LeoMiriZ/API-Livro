package com.livro.livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class LivroResource {

    @Autowired
    public LivroService livroService;

    @GetMapping("/livros")
    public List<LivroTO> getLivros(@RequestParam(name = "titulo", defaultValue = "") String titulo) {
        return (titulo.length() > 0)
            ? livroService.list().stream().filter(livro -> livro.titulo().toLowerCase().contains(titulo.toLowerCase())).toList()
            : livroService.list();
    }

    @GetMapping("/livros/{id}")
    public LivroTO getLivro(@PathVariable("id") String id) {
        return livroService.find(id);
    }

    @PostMapping("/livros")
    public void postLivro(@RequestBody LivroTO in) {
        livroService.create(in);
    }

    @DeleteMapping("/livros/{id}")
    public void deleteLivro(@PathVariable("id") String id) {
        livroService.delete(id);
    }
    
    @PutMapping("/livros/{id}")
    public void putLivro(@PathVariable("id") String id, @RequestBody LivroTO in) {
        livroService.update(id, in);
    }
}