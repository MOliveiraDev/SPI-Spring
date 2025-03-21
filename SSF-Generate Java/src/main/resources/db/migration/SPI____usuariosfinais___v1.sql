CREATE TABLE usuariosfinais (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

ALTER SEQUENCE usuariosfinais_id_seq RESTART WITH 1;