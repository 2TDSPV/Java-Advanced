package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;

public class GeradorSql {

    public static String gerarSelect(Object obj) {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Classe não possui a anotação @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String nomeTabela = tabela.nome();

        return "SELECT * FROM " + nomeTabela + ";";
    }
}
