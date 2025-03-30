package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.GeradorSql;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class RemoverTeste {
    public static void main(String[] args) {
        System.out.println("DELETE");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();
        int idFuncionario = 22;

        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {
            System.out.println("Remover funcionario do banco de dados");
            System.out.println(GeradorSql.gerarDelete(funcionarioDao.buscarPorId(idFuncionario)));
            funcionarioDao.remover(idFuncionario);
            funcionarioDao.commit();

        } catch (IdNaoEncontradoException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}