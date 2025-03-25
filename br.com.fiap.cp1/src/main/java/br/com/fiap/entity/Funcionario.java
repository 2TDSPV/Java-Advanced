package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

import javax.persistence.*;


@Entity
@Table(name = "TAB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    @SequenceGenerator(name = "funcionario_seq", sequenceName = "seq_funcionario_id", allocationSize = 1)
    @Column(name = "id_funcionario", nullable = false, unique = true, length = 10)
    protected int idFuncionario;

    @Column(name = "nm_funcionario", length = 50, nullable = false)
    protected String nomeFuncionario;

    @Column(name = "des_cpf", nullable = false, length = 11, unique = true)
    protected String cpfFuncionario;

    @Column(name = "des_cnpj", length = 14, unique = true)
    protected String cnpjFuncionario;

    @Column(name = "num_idade", nullable = false, precision = 3)
    protected int idadeFuncionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_cargo", nullable = false, length = 20)
    protected CargoFuncionario cargoFuncionario;

    @Column(name = "val_salario", nullable = false, precision = 12, scale = 2)
    protected double salarioFuncionario;

    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.cnpjFuncionario = cnpjFuncionario;
        this.idadeFuncionario = idadeFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public Funcionario(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String cnpjFuncionario, int idadeFuncionario, CargoFuncionario cargoFuncionario, double salarioFuncionario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.cnpjFuncionario = cnpjFuncionario;
        this.idadeFuncionario = idadeFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public double calcularSalario() {
        return salarioFuncionario;
    }

    public String imprimirInformacoes() {
        return "Funcionario:" +
                "id =" + idFuncionario +
                ", nome ='" + nomeFuncionario + '\'' +
                ", cpf ='" + cpfFuncionario + '\'' +
                ", cnpj ='" + cnpjFuncionario + '\'' +
                ", idade =" + idadeFuncionario +
                ", cargo ='" + cargoFuncionario + '\'' +
                ", salario =" + salarioFuncionario +
                '}';
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCnpjFuncionario() {
        return cnpjFuncionario;
    }

    public void setCnpjFuncionario(String cnpjFuncionario) {
        this.cnpjFuncionario = cnpjFuncionario;
    }

    public int getIdadeFuncionario() {
        return idadeFuncionario;
    }

    public void setIdadeFuncionario(int idadeFuncionario) {
        this.idadeFuncionario = idadeFuncionario;
    }

    public CargoFuncionario getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(CargoFuncionario cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }
}
