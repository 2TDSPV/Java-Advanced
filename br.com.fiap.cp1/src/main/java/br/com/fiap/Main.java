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

        Senior senior = new Senior("Francesco", "36799420870", "", 24, CargoFuncionario.SENIOR, 15000, 30, 1.2);
        Junior junior = new Junior("Francesco", "12312312303", "", 24, JUNIOR, 3000, 30, 30);


        System.out.println(senior.imprimirInformacoes());
        System.out.println(senior.calcularSalario());

        String querySenior = GeradorSql.gerarSelect(senior);

        System.out.println("Codigo SQL: " + querySenior);

        String queryJunior = GeradorSql.gerarSelect(junior);

        System.out.println("Codigo SQL: " + queryJunior);

    }
}