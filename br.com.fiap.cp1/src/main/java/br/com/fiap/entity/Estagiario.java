package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.Table;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
public class Estagiario extends Funcionario {

    public Estagiario() {
    }

    public Estagiario(String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario) {
        super(nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
    }

    public Estagiario(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario) {
        super(idFuncionario, nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
    }

    @Override
    public double calcularSalario() {
        return salarioFuncionario * 0.9;
    }

    @Override
    public String imprimirInformacoes() {
        return "Funcionario:" +
                "id = " + idFuncionario + '\n' +
                "nome = Estagiario" + '\n' +
                "cpf = " + cpfFuncionario + '\n' +
                "cnpj = " + cnpjFuncionario + '\n' +
                "idade = " + idadeFuncionario + '\n' +
                "cargo = " + cargoFuncionario + '\n' +
                "salario = " + calcularSalario() + '\n' +
                "Quantidade de café = por enquanto nada" +'\n' +
                "Horas Extra = não deveria" + '\n' +
                '}';
    }

    public void primeiraAtividade() {
        System.out.println("DROP TABLE TAB_FUNCIONARIO");
    }

}
