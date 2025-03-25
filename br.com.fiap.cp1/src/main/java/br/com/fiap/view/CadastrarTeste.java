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

        System.out.println("Adicionar o senior ao banco de dados");
        Senior senior = new Senior("Francesco Tranquilo", "12312312301", "", 24, SENIOR, 15000, 30, 1.2);
        System.out.println(senior.imprimirInformacoes());
        System.out.println(senior.calcularSalario());
        funcionarioDao.cadastrar(senior);

        System.out.println("Adicionar o pleno ao banco de dados");
        Pleno pleno = new Pleno("Francesco melhor", "12312312302", "", 24, PLENO, 7000, 30, 0.5);
        System.out.println(pleno.imprimirInformacoes());
        System.out.println(pleno.calcularSalario());
        funcionarioDao.cadastrar(pleno);

        System.out.println("Adicionar o junior ao banco de dados");
        Junior junior = new Junior("Francesco", "12312312303", "", 24, JUNIOR, 3000, 30, 30);
        System.out.println(junior.imprimirInformacoes());
        System.out.println(junior.calcularSalario());
        funcionarioDao.cadastrar(junior);

        System.out.println("Adicionar o estagiario ao banco de dados");
        Estagiario estagiario = new Estagiario("Francesco não tranquilo", "12312312304", "", 24, ESTAGIARIO, 1500);
        System.out.println(estagiario.imprimirInformacoes());
        System.out.println(estagiario.calcularSalario());
        funcionarioDao.cadastrar(estagiario);

        funcionarioDao.commit();

        System.out.println("Tranquilo");


    }
}