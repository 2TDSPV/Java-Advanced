package br.com.fiap.model;

public class Veiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String combutivel;
    protected String cambio;
    protected int ano;

    public Veiculo(String placa, String marca, String modelo, String combutivel, String cambio, int ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.combutivel = combutivel;
        this.cambio = cambio;
        this.ano = ano;
    }

    public Veiculo(String placa, String marca, String modelo, String cambio, int ano) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cambio = cambio;
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombutivel() {
        return combutivel;
    }

    public void setCombutivel(String combutivel) {
        this.combutivel = combutivel;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
