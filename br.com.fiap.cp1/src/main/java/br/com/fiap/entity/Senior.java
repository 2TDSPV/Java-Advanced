package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Tabela(nome = "TAB_FUNCIONARIO")
@Entity
public class Senior extends Funcionario {

    @Transient
    private int horasExtra = 0;

    @Transient
    private double bonus = 1;

    public Senior() {
    }

    public Senior(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario,
            int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario, int horasExtra,
            double bonus) {
        super(idFuncionario, nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario,
                salarioFuncionario);
        this.horasExtra = horasExtra;
        this.bonus = bonus;
    }

    public Senior(String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario,
            CargoFuncionario cargoFuncionario, double salarioFuncionario, int horasExtra, double bonus) {
        super(nomeFuncionario, cpfFuncionario, cnpjFuncionario, idadeFuncionario, cargoFuncionario, salarioFuncionario);
        this.horasExtra = horasExtra;
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return salarioFuncionario * (1 + bonus * (horasExtra / 15) / 100);
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
                "horas extra = " + horasExtra + '\n' +
                "bonus = " + bonus + '\n' +
                '}';
    }
}
