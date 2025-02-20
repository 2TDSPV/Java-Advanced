package br.com.fiap;

import br.com.fiap.model.Caminhao;
import br.com.fiap.model.Carro;
import br.com.fiap.model.Moto;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        //protected String placa;
        //protected String marca;
        //protected String modelo;
        //protected String combutivel;
        //protected String cambio;
        //protected int ano;

        Moto moto = new Moto("abc1234", "alguma", "outra", "auto", "flex", 2020, 120);
        Carro carro = new Carro("bcd2345", "Totoya", "corolla", "Auto", 2021, 4);
        Caminhao caminhao = new Caminhao("cde3456", "Mercedes", "Algum", "Diesel", "Manual", 2010, 6);

        System.out.println(moto);
        System.out.println(carro);
        System.out.println(caminhao);

    }
}