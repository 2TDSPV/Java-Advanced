package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
public class Junior extends Funcionario {

    @Transient
    int horasExtra;

    @Transient
    int qtdCafe;

    public Junior() {
    }

    public Junior(String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario, int horasExtra, int qtdCafe) {
        super(nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
        this.horasExtra = horasExtra;
        this.qtdCafe = qtdCafe;
    }

    public Junior(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario, int horasExtra, int qtdCafe) {
        super(idFuncionario, nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
        this.horasExtra = horasExtra;
        this.qtdCafe = qtdCafe;
    }

    @Override
    public double calcularSalario() {
        return salarioFuncionario * 1 + (horasExtra * qtdCafe / 15) / 100;
    }

    @Override
    public String imprimirInformacoes() {
        return "Funcionario:" +
                "id = " + idFuncionario + '\n' +
                "nome = " + nomeFuncionario + '\n' +
                "cpf = " + cpfFuncionario + '\n' +
                "cnpj = " + cnpjFuncionario + '\n' +
                "idade = " + idadeFuncionario + '\n' +
                "cargo = " + cargoFuncionario + '\n' +
                "salario = " + salarioFuncionario + '\n' +
                "Quantidade de café = " + qtdCafe + '\n' +
                "Horas Extra = " + horasExtra + '\n' +
                '}';
    }

}
