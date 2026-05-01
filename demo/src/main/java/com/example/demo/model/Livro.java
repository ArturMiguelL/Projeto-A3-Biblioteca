package com.example.demo.model;

import com.example.demo.interfaces.Emprestavel;

public class Livro extends Item implements Emprestavel {
    private int numeroDePaginas;
    private boolean disponivel = true;
    private com.example.demo.model.Usuario usuarioAtual;

    public Livro(String nome, int codigo, String genero, int numeroDePaginas) {
        super(nome, codigo, genero);
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public void emprestar(com.example.demo.model.Usuario usuario) {
        if (!disponivel) {
            System.out.println("Livro já está emprestado.");
            return;
        }
        this.usuarioAtual = usuario;
        this.disponivel = false;
    }

    @Override
    public void devolver() {
        this.usuarioAtual = null;
        this.disponivel = true;
    }

    @Override
    public boolean estaDisponivel() {
        return disponivel;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Páginas: " + numeroDePaginas);
    }

    public int getNumeroDePaginas() {
    return numeroDePaginas;
 }
}