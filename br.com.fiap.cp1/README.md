# Checkpoint 1 - Programação em Java, JPA e Annotations

- Francesco M Di Benedetto
- RM 557313

Este projeto consiste em um sistema de cadastro e gerenciamento de funcionários, utilizando Java, JPA com Hibernate e Oracle como banco de dados.

## 📌 _Objetivos do Projeto_

✔️ Criar uma aplicação em Java com:

- Modelagem de classes usando herança (`Funcionario` e suas subclasses)
- Uso de anotações JPA (`@Entity`, `@Table`, `@Column`, etc.)
- Persistência de dados com Hibernate e Oracle
- Implementação de DAO com padrão de projeto
- Uso de enum para cargos
- Criação de uma API de reflexão
- Criação de Exceptions personalizadas para log de erros

## _Estrutura de Classes_

### **Funcionario (classe abstrata)**

Representa o modelo base de um funcionário. Contém os atributos principais como nome, idade, CPF, salário, cargo, etc.

### **Subclasses de Funcionario**

- `Senior`: recebe bônus por hora extra
- `Pleno`: cálculo de salário com base em bônus e café
- `Junior`: cálculo simplificado com lógica própria
- `Estagiario`: representa um estagiário

Cada subclasse sobrescreve os métodos:

- `calcularSalario()`
- `imprimirInformacoes()`

### **interface FuncionarioDao**

Define quais métodos a classe FuncionarioDaoImpl deve ter.

> Usado como boas práticas na escrita do código.

### **Classe FuncionarioDaoImpl**

Implementa a interface FuncionarioDao, com os métodos de persistência do Hibernate usando o `EntityManager`.

Métodos:

- _persist()_
- _merge()_
- _remove()_
- _find()_

## _Tecnologias Utilizadas_

- Java 21
- Hibernate ORM 5.4
- JPA
- Oracle Database
- Maven
- IntelliJ IDEA
- Anotações customizadas com Java Reflection

## _Funcionalidades_

- Cadastro, busca, atualização e remoção de funcionários no banco de dados (DAO)
- Diferenciação de comportamento entre os cargos com polimorfismo
- Uso de enum para definir o tipo de cargo (`CargoFuncionario`)
- Geração de código SQL com reflexão, a partir da anotação `@Tabela`

## _Banco de Dados_

- Tabela: `TAB_FUNCIONARIO`
- Utiliza `SINGLE_TABLE` como estratégia de herança (`DTYPE` para identificar a subclasse)
- Geração automática de ID com `@SequenceGenerator` e sequence Oracle
- Enum `CargoFuncionario` salvo como `VARCHAR`

## _Observações_

Foi criada uma única classe DAO visando salvar em banco de dados _apenas_ as informações referentes ao _Funcionario_, as subclasses se diferenciam apenas nas sobrescritas de métodos.

- Criar tabelas diferentes para cada cargo seria redundância.

Por mais que seja uma única classe DAO, usando o conceito de herança podemos usar como parâmetro ou retorno a classe **Funcionario**.

O Hibernate possui a função de identificar a classe na hora de enviar para o banco de dados `persist()`, neste caso de tabela única para diferentes objetos ele gera a coluna DTYPE e armazena a _classe_ do objeto. Também possui a função de instanciar o objeto na classe correta ao retornar a consulta `find()`.

#### _Nota_

Ideal usar essa função do Hibernate em classes _estáticas_, não para cargos onde, por exemplo, um junior pode ser promovido para pleno.
