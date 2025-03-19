# Gerador de CPF com Spring Boot

Este projeto é um exemplo de uma aplicação Spring Boot que gera CPFs válidos com base no estado fornecido. Ele também permite salvar, buscar e deletar CPFs no banco de dados, além de associar CPFs a usuários com informações como nome, e-mail, endereço e estado.

## Funcionalidades

- **Geração de CPF**: Gera CPFs válidos com base no estado fornecido.
- **Salvar CPF**: Salva o CPF gerado no banco de dados.
- **Salvar Usuário com CPF**: Salva um usuário com informações completas (nome, e-mail, endereço, estado e CPF).
- **Buscar CPFs**: Lista todos os CPFs salvos no banco de dados.
- **Buscar CPF por ID**: Busca um CPF específico pelo ID.
- **Deletar CPF por ID**: Remove um CPF do banco de dados pelo ID.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para operações de banco de dados.
- **H2 Database**: Banco de dados em memória (pode ser substituído por outro banco de dados).
- **Maven**: Gerenciador de dependências e build.
