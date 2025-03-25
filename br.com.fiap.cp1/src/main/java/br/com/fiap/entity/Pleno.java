package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
public class Pleno extends Funcionario {

    @Transient
    int qtdCafe;

    @Transient
    double bonus;

    public Pleno() {
    }

    public Pleno(String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario, int qtdCafe, double bonus) {
        super(nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
        this.qtdCafe = qtdCafe;
        this.bonus = bonus;
    }

    public Pleno(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario, int qtdCafe, double bonus) {
        super(idFuncionario, nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
        this.qtdCafe = qtdCafe;
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return salarioFuncionario * (1 + bonus * (qtdCafe / 15) / 100);
    }

    @Override
    public String imprimirInformacoes() {
        return "Funcionario:" +
                "id =" + idFuncionario + '\n' +
                "nome = " + nomeFuncionario + '\n' +
                "cpf = " + cpfFuncionario + '\n' +
                "cnpj = " + cnpjFuncionario + '\n' +
                "idade =" + idadeFuncionario + '\n' +
                "cargo = " + cargoFuncionario + '\n' +
                "salario = " + salarioFuncionario + '\n' +
                "Quantidade de café = " + qtdCafe + '\n' +
                "bonus = " + bonus + '\n' +
                '}';
    }

}

