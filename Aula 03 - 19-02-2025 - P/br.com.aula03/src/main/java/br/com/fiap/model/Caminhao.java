package br.com.fiap.model;

public class Caminhao extends Veiculo {
    private int eixos;

    public Caminhao(String placa, String marca, String modelo, String combutivel, String cambio, int ano, int eixos) {
        super(placa, marca, modelo, combutivel, cambio, ano);
        this.eixos = eixos;
    }

    public Caminhao(String placa, String marca, String modelo, String cambio, int ano, int eixos) {
        super(placa, marca, modelo, cambio, ano);
        this.eixos = eixos;
    }

    public Caminhao(String placa, String marca, String modelo, String cambio, int ano) {
        super(placa, marca, modelo, cambio, ano);
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "eixos=" + eixos +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combutivel='" + combutivel + '\'' +
                ", cambio='" + cambio + '\'' +
                ", ano=" + ano +
                '}';
    }
}
