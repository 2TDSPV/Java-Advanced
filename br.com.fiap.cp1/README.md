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

## _Run_

Exemplos de uso dos métodos de persistência.

### INSERT

- _persist()_

```java
System.out.println("Adicionar o senior ao banco de dados");
Senior senior = new Senior("Francesco Tranquilo", "32322312281", "", 24, SENIOR, 11000, 30, 1.2);
System.out.println(GeradorSql.gerarInsert(senior));
System.out.println(senior.imprimirInformacoes());
System.out.println(senior.calcularSalario());
funcionarioDao.cadastrar(senior);
```

```terminal
Adicionar o senior ao banco de dados
class br.com.fiap.entity.Senior
INSERT INTO TAB_FUNCIONARIO (nm_funcionario,des_cpf,des_cnpj,num_idade,des_cargo,val_salario VALUES ( Francesco Tranquilo,32322312281,,24,SENIOR,11000.0);
Funcionario:id = 0
nome = Francesco Tranquilo
cpf = 32322312281
cnpj =
idade = 24
cargo = SENIOR
salario = 11000.0
horas extra = 30
bonus = 1.2
}
11264.0
Hibernate:
    select
        seq_funcionario_id.nextval
    from
        dual
```

### UPDATE

- _merge()_

```java
       try {
           System.out.println("Atualiza o funcionario no banco de dados");
            Junior junior = new Junior(47, "Francesco", "22322312323", "", 24, JUNIOR, 3000, 33, 22);
            System.out.println(GeradorSql.gerarUpdate(junior));
            System.out.println(junior.imprimirInformacoes());
            System.out.println(junior.calcularSalario());
            funcionarioDao.atualizar(junior);
            funcionarioDao.commit();

        } catch (IdNaoEncontradoException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

```

```Terminal
Atualiza o funcionario no banco de dados
class br.com.fiap.entity.Junior
UPDATE TAB_FUNCIONARIO SET nm_funcionario=Francesco,des_cpf=22322312323,des_cnpj=,num_idade=24,des_cargo=JUNIOR,val_salario=3000.0 WHERE ID_FUNCIONARIO = 47
Funcionario:id = 47
nome = Francesco
cpf = 22322312323
cnpj =
idade = 24
cargo = JUNIOR
salario = 3000.0
Quantidade de café = 22
Horas Extra = 33
}
3000.0
Hibernate:
    select
        funcionari0_.id_funcionario as id_funcionario2_0_0_,
        funcionari0_.des_cargo as des_cargo3_0_0_,
        funcionari0_.des_cnpj as des_cnpj4_0_0_,
        funcionari0_.des_cpf as des_cpf5_0_0_,
        funcionari0_.num_idade as num_idade6_0_0_,
        funcionari0_.nm_funcionario as nm_funcionario7_0_0_,
        funcionari0_.val_salario as val_salario8_0_0_,
        funcionari0_.DTYPE as dtype1_0_0_
    from
        TAB_FUNCIONARIO funcionari0_
    where
        funcionari0_.id_funcionario=?
Hibernate:
    update
        TAB_FUNCIONARIO
    set
        des_cargo=?,
        des_cnpj=?,
        des_cpf=?,
        num_idade=?,
        nm_funcionario=?,
        val_salario=?
    where
        id_funcionario=?
```

### SELECT

- _find()_

```java
        try {
            Funcionario funcionaio = funcionarioDao.buscarPorId(23);
            System.out.println(GeradorSql.gerarSelect(funcionaio));
            System.out.println(funcionaio.getClass());
            System.out.println(funcionaio.imprimirInformacoes());
            System.out.println(funcionaio.calcularSalario());

        } catch (IdNaoEncontradoException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Tranquilo");

    }

```

```Terminal
Hibernate:
    select
        funcionari0_.id_funcionario as id_funcionario2_0_0_,
        funcionari0_.des_cargo as des_cargo3_0_0_,
        funcionari0_.des_cnpj as des_cnpj4_0_0_,
        funcionari0_.des_cpf as des_cpf5_0_0_,
        funcionari0_.num_idade as num_idade6_0_0_,
        funcionari0_.nm_funcionario as nm_funcionario7_0_0_,
        funcionari0_.val_salario as val_salario8_0_0_,
        funcionari0_.DTYPE as dtype1_0_0_
    from
        TAB_FUNCIONARIO funcionari0_
    where
        funcionari0_.id_funcionario=?
SELECT * FROM TAB_FUNCIONARIO;
class br.com.fiap.entity.Junior
Funcionario:id = 23
nome = Enzo
cpf = 22312312303
cnpj = null
idade = 21
cargo = JUNIOR
salario = 2500.0
Quantidade de café = 0
Horas Extra = 0
}
2500.0
Tranquilo
```

### DELETE

- _remove()_

```java
try {
    System.out.println("Remover funcionario do banco de dados");
    System.out.println(GeradorSql.gerarDelete(funcionarioDao.buscarPorId(idFuncionario)));
    funcionarioDao.remover(idFuncionario);
    funcionarioDao.commit();

} catch (IdNaoEncontradoException | IllegalAccessException e) {
    throw new RuntimeException(e);
}

System.out.println("Tranquilo");
```

```Terminal

Remover funcionario do banco de dados
Hibernate:
    select
        funcionari0_.id_funcionario as id_funcionario2_0_0_,
        funcionari0_.des_cargo as des_cargo3_0_0_,
        funcionari0_.des_cnpj as des_cnpj4_0_0_,
        funcionari0_.des_cpf as des_cpf5_0_0_,
        funcionari0_.num_idade as num_idade6_0_0_,
        funcionari0_.nm_funcionario as nm_funcionario7_0_0_,
        funcionari0_.val_salario as val_salario8_0_0_,
        funcionari0_.DTYPE as dtype1_0_0_
    from
        TAB_FUNCIONARIO funcionari0_
    where
        funcionari0_.id_funcionario=?
DELETE * FROM TAB_FUNCIONARIO WHERE ID_FUNCIONARIO = 22;
Hibernate:
    delete
    from
        TAB_FUNCIONARIO
    where
        id_funcionario=?
Tranquilo

Process finished with exit code 0

```
