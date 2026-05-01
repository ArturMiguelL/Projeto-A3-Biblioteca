package com.example.demo.model;

public abstract class Item {
    private String nome;
    private String genero;
    private int codigo;

    public Item(String nome, int codigo, String genero) {
        this.nome = nome;
        this.codigo = codigo;
        this.genero = genero;
    }

    public abstract void exibirDetalhes();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
     
    
    
}