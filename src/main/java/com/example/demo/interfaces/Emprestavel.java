package com.example.demo.interfaces;

import com.example.demo.model.Usuario;

public interface Emprestavel {
    void emprestar(Usuario usuario);
    void devolver();
    boolean estaDisponivel();
}
