package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.*;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.*;

public class BuscarTeste {
    public static void main(String[] args) {
        System.out.println("Teste de persistence!");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();

        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {
            Funcionario senior = funcionarioDao.buscarPorId(1);
            System.out.println(senior.getClass());
            System.out.println(senior.imprimirInformacoes());
            System.out.println(senior.calcularSalario());

        } catch (IdNaoEncontradoException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}