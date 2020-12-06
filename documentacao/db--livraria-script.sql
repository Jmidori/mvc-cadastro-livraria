CREATE DATABASE livraria;
USE livraria;

CREATE TABLE `livro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `autor` bigint DEFAULT NULL,
  `bestSeller` bit(1) DEFAULT NULL,
  `categoria` bigint DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `dataLancamento` date DEFAULT NULL,
  `editora` bigint DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `autor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `nacionalidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

INSERT INTO autor (nome, nacionalidade) VALUES ("Miguel de Cervantes", "espanhola");
INSERT INTO autor (nome, nacionalidade) VALUES ("Charles Dickens", "britanica");
INSERT INTO autor (nome, nacionalidade) VALUES ("Paulo Coelho", "brasileira");
INSERT INTO autor (nome, nacionalidade) VALUES ("J R R Tolkien", "britanica");
INSERT INTO autor (nome, nacionalidade) VALUES ("Antoine de Saint Exupery", "francesa");
INSERT INTO autor (nome, nacionalidade) VALUES ("J K Rowling", "britanica");
INSERT INTO autor (nome, nacionalidade) VALUES ("Agatha Christie", "britanica");
INSERT INTO autor (nome, nacionalidade) VALUES ("Cao Xueqin", "chinesa");
INSERT INTO autor (nome, nacionalidade) VALUES ("H Rider Haggard", "britanica");

CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO livraria.categoria (descricao) VALUES ("ficcao");
INSERT INTO livraria.categoria (descricao) VALUES ("terror");
INSERT INTO livraria.categoria (descricao) VALUES ("romance");
INSERT INTO livraria.categoria (descricao) VALUES ("tecnico");
INSERT INTO livraria.categoria (descricao) VALUES ("biografia");
INSERT INTO livraria.categoria (descricao) VALUES ("poesia");
INSERT INTO livraria.categoria (descricao) VALUES ("auto ajuda");


CREATE TABLE `editora` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `nacionalidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Sextante", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Intrinseca", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Companhia das Letras", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Alta Books", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Editorial Record", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Gente", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Rocco", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Planeta", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Buzz", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Ciranda Cultural", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Ediouro", "brasileira");
INSERT INTO livraria.editora (nome, nacionalidade) VALUES ("Globo", "brasileira");




