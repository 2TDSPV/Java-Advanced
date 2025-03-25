package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Pleno;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.PLENO;

public class AtualizarTeste {
    public static void main(String[] args) {
        System.out.println("Teste de persistence!");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();

        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {
            System.out.println("Atualiza o pleno no banco de dados");
            Pleno pleno = new Pleno(12, "Francesco melhor", "12312312302", "", 24, PLENO, 7500, 33, 0.5);
            System.out.println(pleno.imprimirInformacoes());
            System.out.println(pleno.calcularSalario());
            funcionarioDao.atualizar(pleno);
            funcionarioDao.commit();

        } catch (IdNaoEncontradoException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}