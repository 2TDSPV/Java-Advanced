package br.com.fiap;

import br.com.fiap.model.Produto;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Produto produto01 = new Produto("Energético", "Monster", 10.0, 473);
        System.out.println(produto01.getMarca());
        System.out.println(produto01.getNome());
        System.out.println(produto01.getPreco());

    }
}