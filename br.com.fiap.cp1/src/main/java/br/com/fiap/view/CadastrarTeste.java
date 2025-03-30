package br.com.fiap.view;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.*;

public class CadastrarTeste {
    public static void main(String[] args) {
        System.out.println("CREATE");

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        EntityManager entityManager = fabrica.createEntityManager();
        FuncionarioDaoImpl funcionarioDao = new FuncionarioDaoImpl(entityManager);

        try {

            System.out.println("Adicionar o senior ao banco de dados");
            Senior senior = new Senior("Francesco Tranquilo", "32322312281", "", 24, SENIOR, 11000, 30, 1.2);
            System.out.println(GeradorSql.gerarInsert(senior));
            System.out.println(senior.imprimirInformacoes());
            System.out.println(senior.calcularSalario());
            funcionarioDao.cadastrar(senior);

            System.out.println("Adicionar o pleno ao banco de dados");
            Pleno pleno = new Pleno("Francesco melhor", "32322312282", "", 24, PLENO, 5000, 30, 0.5);
            System.out.println(GeradorSql.gerarInsert(pleno));
            System.out.println(pleno.imprimirInformacoes());
            System.out.println(pleno.calcularSalario());
            funcionarioDao.cadastrar(pleno);

            System.out.println("Adicionar o junior ao banco de dados");
            Junior junior = new Junior("Francesco", "32322312283", "", 24, JUNIOR, 2500, 30, 30);
            System.out.println(GeradorSql.gerarInsert(junior));
            System.out.println(junior.imprimirInformacoes());
            System.out.println(junior.calcularSalario());
            funcionarioDao.cadastrar(junior);

            System.out.println("Adicionar o estagiario ao banco de dados");
            Estagiario estagiario = new Estagiario("Francesco não tranquilo", "32322312284", "", 24, ESTAGIARIO, 1500);
            System.out.println(GeradorSql.gerarInsert(estagiario));
            System.out.println(estagiario.imprimirInformacoes());
            System.out.println(estagiario.calcularSalario());
            funcionarioDao.cadastrar(estagiario);

            funcionarioDao.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }
}
