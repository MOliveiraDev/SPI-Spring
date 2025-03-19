CREATE TABLE CPF_dos_Usuarios (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255),
    estado VARCHAR(255),
    cpf VARCHAR(255)
);
**resetar o numero do id**

RESET SEQUENCE CPF_dos_Usuarios_id_seq RESTART WITH 1;