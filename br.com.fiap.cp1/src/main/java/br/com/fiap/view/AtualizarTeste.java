package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.GeradorSql;
import br.com.fiap.entity.Junior;
import br.com.fiap.entity.Pleno;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.JUNIOR;
import static br.com.fiap.entity.CargoFuncionario.PLENO;

public class AtualizarTeste {
    public static void main(String[] args) {
        System.out.println("UPDATE");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();

        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {
            System.out.println("Atualiza o funcionario no banco de dados");
            Junior junior = new Junior(47, "Francesco", "22322312323", "", 24, JUNIOR, 3000, 33, 22);
            System.out.println(GeradorSql.gerarUpdate(junior));
            System.out.println(junior.imprimirInformacoes());
            System.out.println(junior.calcularSalario());
            funcionarioDao.atualizar(junior);
            funcionarioDao.commit();

        } catch (IdNaoEncontradoException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}