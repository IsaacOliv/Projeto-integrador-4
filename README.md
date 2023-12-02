# Projeto-integrador-4
Projeto de faculdade (obrigatoriamente em java)



tabelas -------


CREATE TABLE carros (
	id int primary key auto_increment,
    marca varchar(100),
    modelo varchar(100),
    anoFabricacao int,
    anoModelo int,
    valor double,
    descricao text,
    fotoCarro text
    
);

CREATE TABLE interessesClientes (
	id int primary key auto_increment,
    nomeCliente varchar(100),
    telefoneCliente int,
    id_carro int,
    FOREIGN KEY (id_carro) REFERENCES carros(id)
);

CREATE TABLE usuarios (
    id SERIAL, 
    nome CHARACTER VARYING (255),
    dataNascimento DATE,
    ativo BOOLEAN DEFAULT TRUE,
    login CHARACTER VARYING (255),
    senha CHARACTER VARYING (255),
    created_at DATETIME,
    updated_at DATETIME
);
