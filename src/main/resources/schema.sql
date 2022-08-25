CREATE TABLE tb_processo (
id INTEGER NOT NULL AUTO_INCREMENT,
numero INTEGER NOT NULL,
ano INTEGER NOT NULL,
dataCadastro date NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE tb_pessoa (
id INTEGER NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
cpf varchar(11) NOT NULL,
dataNascimento date NOT NULL,
dataCadastro date NOT NULL,
id_processo INT,
FOREIGN KEY (id_processo) REFERENCES tb_processo(id),
PRIMARY KEY (id)
);


