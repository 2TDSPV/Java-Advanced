package br.com.fiap;

public class Main {
    public static void main(String[] args) {

        int resultado = 10 / 4;
        System.out.println(resultado);

        System.out.println(0.1 + 0.2 == 0.3);

        boolean a = true;
        boolean b = false;
        boolean c = a || b && !a;
        System.out.println(c);

        int x = 5;
        int y = x++;
        System.out.println(x);
        System.out.println(y);

    }
}