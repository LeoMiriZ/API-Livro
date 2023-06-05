package com.livro.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")

public class Livro{

    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    @Column(name = "id")
    private String id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "editora")
    private String editora;

    @Column(name = "ano")
    private int ano;

    @Column(name = "preco")
    private float preco;


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public float getPreco() {
        return preco ;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Livro() {

    }

    public Livro(LivroTO to) {
        this.id = to.id();
        this.titulo = to.titulo();
        this.autor = to.autor();
        this.editora = to.editora();
        this.ano = to.ano();
        this.preco = to.preco();
    }
  
    


}