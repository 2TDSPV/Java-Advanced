package br.com.fiap.model;

public class Carro extends Veiculo {
    private int portas;

    public Carro(String placa, String marca, String modelo, String combutivel, String cambio, int ano, int portas) {
        super(placa, marca, modelo, combutivel, cambio, ano);
        this.portas = portas;
    }

    public Carro(String placa, String marca, String modelo, String cambio, int ano, int portas) {
        super(placa, marca, modelo, cambio, ano);
        this.portas = portas;
    }

    public Carro(String placa, String marca, String modelo, String cambio, int ano) {
        super(placa, marca, modelo, cambio, ano);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "portas=" + portas +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combutivel='" + combutivel + '\'' +
                ", cambio='" + cambio + '\'' +
                ", ano=" + ano +
                '}';
    }
}
