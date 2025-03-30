package br.com.fiap;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.CargoFuncionario;
import br.com.fiap.entity.GeradorSql;
import br.com.fiap.entity.Junior;
import br.com.fiap.entity.Senior;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.JUNIOR;

public class Main {

    public static void main(String[] args) {
        System.out.println("Teste de persistence!");
    }
}