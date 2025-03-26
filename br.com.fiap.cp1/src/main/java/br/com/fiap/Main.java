package br.com.fiap;

import br.com.fiap.dao.FuncionarioDaoImpl;
import br.com.fiap.entity.CargoFuncionario;
import br.com.fiap.entity.GeradorSql;
import br.com.fiap.entity.Junior;
import br.com.fiap.entity.Senior;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static br.com.fiap.entity.CargoFuncionario.JUNIOR;

public class Main {

    // Define a URI base
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    // Método para iniciar o servidor Grizzly
    public static HttpServer startServer() {
        // Cria uma configuração de recurso que escaneia o pacote "br.com.farol"
        final ResourceConfig rc = new ResourceConfig().packages("br.com.farol");

        // Cria e inicia o servidor HTTP Grizzly, expondo a aplicação Jersey
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        System.out.println("Teste de persistence!");
        // Inicia o servidor
        final HttpServer server = startServer();
        System.out.printf("Aplicação Jersey iniciada com WADL disponível em %sapplication.wadl%n", BASE_URI);
        System.out.println("Pressione Enter para parar o servidor...");
        System.in.read();
        server.shutdownNow();

    }
}