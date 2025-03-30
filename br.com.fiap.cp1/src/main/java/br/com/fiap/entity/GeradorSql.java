package br.com.fiap.entity;

import br.com.fiap.annotation.Tabela;
import org.hibernate.sql.ordering.antlr.ColumnMapper;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.ArrayList;

import br.com.fiap.exception.IdNaoEncontradoException;

public class GeradorSql {

    public static String gerarSelect(Object obj) {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Classe não possui a anotação @Tabela");
        } else {
            Tabela tabela = clazz.getAnnotation(Tabela.class);
            String nomeTabela = tabela.nome();
            return "SELECT * FROM " + nomeTabela + ";";
        }

    }

    public static String gerarDelete(Object obj) throws IllegalAccessException, IdNaoEncontradoException {
        Class<?> clazz = obj.getClass();
        String nomeTabela = "";
        String idFuncionario = "";

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Classe não possui a anotação @Tabela");
        } else {
            for (Field item : clazz.getSuperclass().getDeclaredFields()) {
                item.setAccessible(true);
                Tabela tabela = clazz.getAnnotation(Tabela.class);
                nomeTabela = tabela.nome();
                if (item.isAnnotationPresent(Column.class)) {
                    Column nomeColuna = item.getAnnotation(Column.class);
                    if (nomeColuna.name().equals("id_funcionario")) {
                        idFuncionario = item.get(obj).toString();
                    }
                }

            }
        }
        if (idFuncionario.isEmpty()) {
            throw new IdNaoEncontradoException();
        }
        return "DELETE * FROM " + nomeTabela + " WHERE ID_FUNCIONARIO = " + idFuncionario + ";";
    }

    public static String gerarInsert(Object obj) throws IllegalAccessException {
        String codigoSql;
        Class<?> clazz = obj.getClass();
        ArrayList<String> listaNomesColunas = new ArrayList<>();
        ArrayList<String> listaValores = new ArrayList<>();
        System.out.println(clazz);

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Classe não possui a anotação @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String nomeTabela = tabela.nome();

        for (Field item : clazz.getSuperclass().getDeclaredFields()) {
            item.setAccessible(true);
            if (item.isAnnotationPresent(Column.class)) {
                Column nomeColuna = item.getAnnotation(Column.class);
                if (!nomeColuna.name().equals("id_funcionario")) {
                    listaNomesColunas.add(nomeColuna.name());
                    listaValores.add(String.valueOf(item.get(obj)));

                }

            }
        }

        String colunas = String.join(",", listaNomesColunas);
        String valores = String.join(",", listaValores);

        codigoSql = "INSERT INTO " + nomeTabela + " (" +
                colunas +
                " VALUES ( " +
                valores +
                ");";

        return codigoSql;
    }

    public static String gerarUpdate(Object obj) throws IllegalAccessException, IdNaoEncontradoException {
        String codigoSql;
        Class<?> clazz = obj.getClass();
        ArrayList<String> listaValores = new ArrayList<>();
        String idFuncionario = "";
        System.out.println(clazz);

        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Classe não possui a anotação @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String nomeTabela = tabela.nome();

        for (Field item : clazz.getSuperclass().getDeclaredFields()) {
            item.setAccessible(true);
            if (item.isAnnotationPresent(Column.class)) {
                Column nomeColuna = item.getAnnotation(Column.class);
                if (nomeColuna.name().equals("id_funcionario")) {
                    idFuncionario = item.get(obj).toString();
                } else {
                    listaValores.add(String.valueOf(nomeColuna.name() + "=" + item.get(obj)));
                }

            }
        }

        String valores = String.join(",", listaValores);

        if (!idFuncionario.isEmpty()) {

            codigoSql = "UPDATE " + nomeTabela + " SET " +
                    valores +
                    " WHERE ID_FUNCIONARIO = " + idFuncionario;
        } else {
            throw new IdNaoEncontradoException();
        }

        return codigoSql;
    }

}
