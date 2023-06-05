CREATE DATABASE IF NOT EXISTS livro;
USE livro;


CREATE TABLE IF NOT EXISTS livro
(
    id varchar(36),
    titulo varchar(200) NOT NULL,
    autor varchar(200) NOT NULL,
    editora varchar(200) NOT NULL,
    ano INT NOT NULL,
    preco FLOAT NOT NULL,
    CONSTRAINT id_pkey PRIMARY KEY (id)
);