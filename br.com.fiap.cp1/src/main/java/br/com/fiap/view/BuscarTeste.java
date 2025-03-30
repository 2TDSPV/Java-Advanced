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
        System.out.println("READ");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();

        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {
            Funcionario funcionaio = funcionarioDao.buscarPorId(23);
            System.out.println(GeradorSql.gerarSelect(funcionaio));
            System.out.println(funcionaio.getClass());
            System.out.println(funcionaio.imprimirInformacoes());
            System.out.println(funcionaio.calcularSalario());

        } catch (IdNaoEncontradoException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}