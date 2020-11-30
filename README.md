# mvc-cadastro-livraria
Projeto desenvolvido para a Disciplina de Engenharia de Software 3.

A aplicação realiza o cadastramento de Livros com as operações de CRUD implementdas.

Esse projeto nao contempla o cadastramento das entidades que se relacionam ao cadastro de livro. Esse vinculo é feito atraves da inclusão do id dessas entidades no registro do livro. 

### Componentes do projeto
API desenvolvida em Java 11 com Spring Boot

FrontEnd desenvolvido em JavaScript e Bootstrap

Banco de Dados MySQL

## Ponto de Partida

### Criação do Banco de Dados e Tabelas
1. Pré requisito: possuir o servidor do MySQL instalado

2. importar o banco de dados e suas tabelas em: mvc-cadastro-livraria/dumps/export.sql (tutorial: https://www.hostnet.com.br/info/importacao-do-banco-via-mysql-workbench/)

### Inicialização da aplicação Backend
pela IDE: Abrir o projeto mvc-cadastro-livraria/cadastro-livro na IDE e executar a classe ApplicationMain

pelo Terminal: acessar o diretorio mvc-cadastro-livraria/cadastro-livro/target executar o comando: java -jar target\cadastro-livro-0.0.1-SNAPSHOT.jar (a aplicação subirá na porta 8080)

### Inicialização da aplicação Frontend
