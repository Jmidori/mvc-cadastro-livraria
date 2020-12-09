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

2. importar o banco de dados e suas tabelas
Executar o script contido no arquivo **db--livraria-script.sql** contido no diretorio: **mvc-cadastro-livraria\db-livraria**

### Inicialização da aplicação
**[Opção 1] via IDE:** 
Abrir o projeto mvc-cadastro-livraria/cadastro-livro na IDE e executar a classe ApplicationMain

**[Opção 2] via Terminal:**  
baixar o jar atraves do link: //
executar o comando:
```sh
java -jar cadastro-livro-0.0.1-SNAPSHOT.jar
```

## Navegação

Acessar a página principal de cadastro de livro: http://localhost:8080/cadastro/livro

Nesta página, é possivel vizualizar todos os livros cadastrados, criar novos registros atraves do botão "NOVO", alterar um registro ou excluí-lo clicando nos links alinhados ao registro em que deseja executar a ação. 
