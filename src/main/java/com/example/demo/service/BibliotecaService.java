package com.example.demo.service;

import com.example.demo.interfaces.Emprestavel;
import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service // ← Spring gerencia essa classe automaticamente
public class BibliotecaService {
    private Map<Integer, Item> acervo = new HashMap<>();
    private Map<Integer, Usuario> usuarios = new HashMap<>();

    public void adicionarItem(Item item){
      if (acervo.containsKey(item.getCodigo())) {
            System.out.println("Já existe item com esse código.");
            return;
        }
        acervo.put(item.getCodigo(), item);
        System.out.println("Item adicionado com sucesso.");
    }

    public Item buscarItem(int codigo) {
        return acervo.get(codigo);
    }

    public void listarItens() {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        for (Item item : acervo.values()) {
            System.out.println("---------------------");
            item.exibirDetalhes(); 
            System.out.println("---------------------");
        }
    }

    public Collection<Item> getTodosItens() {
    return acervo.values();
    }

    //usuario

    public void adicionarUsuario(Usuario usuario){
        if(usuarios.containsKey(usuario.getCpf())){
            System.out.println("usuario já cadastrado");
            return;
        }

        usuarios.put(usuario.getCpf(), usuario);
        System.out.println("Usuario cadastrado com sucesso");
    }

    public Usuario buscarUsuario(int cpf){
        return usuarios.get(cpf);
    }

    //emprestimo

    public void realizarEmprestimo(int codigoItem, int cpfUsuario){
        Item item = buscarItem(codigoItem);
        Usuario usuario = buscarUsuario(cpfUsuario);

        if (item == null) {
        System.out.println("Item não encontrado.");
        return;
    }
    if (usuario == null) {
        System.out.println("Usuário não encontrado.");
        return;
    }
    if (!(item instanceof Emprestavel)) {
        System.out.println("Este item não pode ser emprestado.");
        return;
    }

    Emprestavel emprestavel = (Emprestavel) item;

    if(!emprestavel.estaDisponivel()){
        System.out.println("Item Indisponivel.");
        return;
    }

    emprestavel.emprestar(usuario);
    usuario.adicionarEmprestimo(item);
    System.out.println("✅ Empréstimo realizado: " + item.getNome() + " → " + usuario.getNome());
    }

    //Devolução

    public void realizarDevolucao(int codigoItem, int cpfUsuario){
        Item item = buscarItem(codigoItem);
        Usuario usuario = buscarUsuario(cpfUsuario);

        if (item == null || usuario == null) {
        System.out.println("Item ou usuário não encontrado.");
        return;
    }
    if (!(item instanceof Emprestavel)) {
        System.out.println("Este item não suporta devolução.");
        return;
    }

     ((Emprestavel) item).devolver();
    usuario.removerEmprestimo(item);
    System.out.println("Devolução registrada: " + item.getNome());
    }

}
