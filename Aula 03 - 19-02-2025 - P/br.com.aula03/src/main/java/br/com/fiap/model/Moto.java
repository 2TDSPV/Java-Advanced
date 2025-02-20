package br.com.fiap.model;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, String combutivel, String cambio, int ano, int cilindradas) {
        super(placa, marca, modelo, combutivel, cambio, ano);
        this.cilindradas = cilindradas;
    }

    public Moto(String placa, String marca, String modelo, String cambio, int ano, int cilindradas) {
        super(placa, marca, modelo, cambio, ano);
        this.cilindradas = cilindradas;
    }

    public Moto(String placa, String marca, String modelo, String cambio, int ano) {
        super(placa, marca, modelo, cambio, ano);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combutivel='" + combutivel + '\'' +
                ", cambio='" + cambio + '\'' +
                ", ano=" + ano +
                '}';
    }
}
