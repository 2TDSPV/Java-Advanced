# Java-Advanced

### PROF. DR. MARCEL STEFAN WAGNER

### 1° Semestre

- Apresentação do Professor e do Conteúdo Programático da disciplina.
- Revisão de POO (abstração e herança).
- Revisão de POO (encapsulamento e polimorfismo).
- Exercícios com os 4 pilares de POO.
- Visão geral da arquitetura Java EE. Introdução aos frameworks de ORM. Anotações Java.
- Introdução ao mapeamento Objeto-Relacional (ORM).
- Conceitos de Mapeamento de APIs de persistências e Entidades.
- Protocolos de Comunicação. Estrutura Cliente e Servidor.
- Comunicação TCP em Java. Exercícios.
- JPA Entity Manager. Contexto de persistência. Estados das entidades. Métodos da JPA API.
- Exercício Client-Server em Java.
- JPA e Design Patterns - Singleton DAO Genérico.
- Comunicação UDP em Java. Exercícios.
- Comunicação via Sockets. Serialização e Streams
- Spring e Spring Boot. Testes básicos CRUD com Postman.
- Mapeamento Objeto-Relacional (ORM). Spring Boot com Maven. Exercícios.
- JPA Relacionamentos (OneToOne, ManyToOne, OneToMany e ManyToMany).
- Projeto Spring Boot. Spring Initializr. Annotations em JPA Relacionamentos.
- Serialização de objetos Sockets. JPA Relacionamentos.
- Mapeamento Avançado. Chaves compostas. Múltiplas tabelas. Herança.
- Exercícios de Relacionamentos.
- Spring Initializr, configurações e dependências.
- Projeto Spring Boot com Relacionamentos e BD Oracle SQL Developer.
- HATEOAS, Lombok e mensagens HTTP.
- Exercício com Relacionamentos, HATEOAS e aplicação de Lombok.
- Spring AI, Spring Boot, OpenAI e ChatGPT.
- API Restful com Documentação via Swagger.
- Conceitos de Deploy

### 2° Semestre

- Spring MVC overview.
- Spring MVC com Controllers.
- Spring Views com Thymeleaf.
- Spring MVC com Spring Data JPA.
- Internacionalização Spring MVC.
- API Restful com Spring Security (JWT).
- Spring MVC com Spring Security - (OAuth2 e Security Profiles).
- Microservices com Messaging e Observability.
- Suporte Challenge.

## **Aula 02 - Revisão**

### **Introdução**

#### _1. Programação Orientada a Objeto (POO)_

Tem como pilar teórico o conceito de **objeto**, ou seja, um sistema orientado a objeto é um conjunto de objetos que representam os seres e coisas, interagindo computacionalmente com as mesmas características e comportamentos.

A estrutura computacional que define o modelo de um objeto, damos o nome de **classe**, e a partir dela cópias são construídas para serem utilizadas para cada objeto que tenha no sistema

O principal benefício da utilização da programação por meio de classes é a reutilização do código, pois a cada objeto criado, você não precisa criar sua estrutura novamente.

#### _2. Abstração_

Abstração é a habilidade de concentrar nos aspectos essenciais de um contexto qualquer e mostrar apenas o necessário. Isso permite que tralhemos com objetos de forma mais genérica, focando no que eles representam e não em como funcionam.

#### _3. Classes_

Classes são estruturas que definem as características e comportamentos dos seres ou coisas do mundo real.

Quando implementados em java nas classes, essas características passam a se chamar de atributos, e os comportamentos se transformam em métodos.

Classes possuem basicamente:

1. Atributos.
   - Definem as características que cada objeto de uma classes deve ter.
2. Comportamentos.
   - Definem as ações que cada objeto de uma classe pode executar.

• Definição de classe private / public:

- encapsulamento;
- define para quais classes o atributo é visível;
- public: visível para todas as classes;
- private: visível apenas para a própria classe.

• Atributos get / set:

- utilizados para acessar as variáveis private;
- set muda o valor da variável;
- get acessa o valor da variável.

## Estudo prévio

### **Revisão de POO em Java**

#### **2. Herança**

A **herança** permite que uma classe derive de outra, herdando seus atributos e comportamentos. Isso promove reutilização de código e facilita a manutenção.

**Exemplo:**

```java
class Animal {
    void emitirSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Au Au!");
    }
}
```

🔹 A classe `Cachorro` herda de `Animal` e sobrescreve o método `emitirSom()`.

---

#### **3. Encapsulamento**

O **encapsulamento** protege os dados de um objeto, controlando seu acesso. Isso é feito usando modificadores de acesso (`private`, `protected`, `public`).

**Exemplo:**

```java
class ContaBancaria {
    private double saldo;

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

🔹 O atributo `saldo` é `private`, impedindo acesso direto.  
🔹 Métodos `public` permitem manipular o saldo com segurança.

---

#### **4. Polimorfismo**

O **polimorfismo** permite que um mesmo método tenha diferentes comportamentos dependendo da classe que o implementa. Pode ser de dois tipos:

**🔸 Polimorfismo de sobrescrita (Override)**  
Quando um método de uma classe pai é redefinido em uma classe filha.

```java
class Forma {
    void desenhar() {
        System.out.println("Desenhando uma forma genérica");
    }
}

class Circulo extends Forma {
    @Override
    void desenhar() {
        System.out.println("Desenhando um círculo");
    }
}
```

**🔸 Polimorfismo de sobrecarga (Overload)**  
Quando métodos têm o mesmo nome, mas assinaturas diferentes (parâmetros distintos).

```java
class Calculadora {
    int soma(int a, int b) {
        return a + b;
    }

    double soma(double a, double b) {
        return a + b;
    }
}
```

🔹 O método `soma()` tem duas versões, uma para `int` e outra para `double`. 