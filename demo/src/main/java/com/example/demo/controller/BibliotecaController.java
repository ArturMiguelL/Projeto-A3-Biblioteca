package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // libera o React acessar
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping("/itens")
    public Collection<Item> listarItens() {
        return service.getTodosItens();
    }

    @PostMapping("/livros")
    public void adicionarLivro(@RequestBody Livro livro) {
        service.adicionarItem(livro);
    }

    @PostMapping("/usuarios")
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        service.adicionarUsuario(usuario);
    }

    @PostMapping("/emprestimo")
    public void realizarEmprestimo(@RequestParam int codigoItem, @RequestParam int cpfUsuario) {
        service.realizarEmprestimo(codigoItem, cpfUsuario);
    }

    @PostMapping("/devolucao")
    public void realizarDevolucao(@RequestParam int codigoItem, @RequestParam int cpfUsuario) {
        service.realizarDevolucao(codigoItem, cpfUsuario);
    }
}