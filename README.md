# Spring CRUD Example

Este repositório contém um exemplo de aplicação CRUD (Create, Read, Update, Delete) utilizando Java, Spring Boot, JDBC e MySQL. O projeto demonstra como realizar operações básicas de CRUD em uma aplicação Spring Boot, interagindo com um banco de dados MySQL.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Boot**: Framework para criar aplicações Java baseadas em Spring.
- **JDBC**: API Java para conectar e executar operações em um banco de dados.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **Gradle**: Gerenciador de dependências e sistema de construção.

## Funcionalidades

A aplicação oferece as seguintes operações CRUD:

- **Listar Dados**: Obtém todos os registros de pessoas no banco de dados.
- **Inserir Dados**: Adiciona um novo registro de pessoa ao banco de dados.
- **Excluir Dados**: Remove um registro de pessoa baseado no ID.
- **Atualizar Dados**: Atualiza as informações de um registro de pessoa baseado no ID.

## Endpoints

Os seguintes endpoints estão disponíveis para interagir com a aplicação:

- **GET /**: Lista todos os registros de pessoas.
- **POST /cadastrar**: Adiciona uma nova pessoa. Exemplo de corpo da requisição:
- **DELETE /{id}**: Remove a pessoa com o ID especificado.
- **PUT /editar**: Atualiza a pessoa existente com o ID especificado. Exemplo de corpo da requisição:

