CREATE TABLE cpf_dos_usuarios (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    estado VARCHAR(255),
    cpf VARCHAR(255)
);
-- Resetar o número do id
ALTER SEQUENCE cpf_dos_usuarios_id_seq RESTART WITH 1;