API-REST-CRUD com Validação de Token de Login

Este repositório contém a base para iniciar um projeto utilizando Spring, com uma tela de login e validações do token de autenticação. O projeto está pronto para ser utilizado como ponto de partida para desenvolver um sistema completo.
Funcionalidades

    Autenticação de Usuário: Implementação de login com validação de token JWT.
    CRUD: Operações de Create, Read, Update e Delete para gerenciar entidades.
    Validações: Regras de negócio aplicadas na validação dos dados.
    Segurança: Configuração de segurança para proteger as rotas e endpoints.

Como Funciona
Estrutura do Projeto

O projeto é estruturado utilizando o Spring Boot, facilitando a criação de APIs RESTful robustas e escaláveis. A seguir, um resumo das principais camadas do projeto:

    Controller: Define os endpoints e manipula as requisições HTTP.
    Service: Contém a lógica de negócio e interage com o repositório.
    Repository: Responsável pela comunicação com o banco de dados.
    Security: Gerencia a autenticação e autorização dos usuários.

Validação de Token

O projeto inclui a configuração para geração e validação de tokens JWT, que são utilizados para garantir que apenas usuários autenticados possam acessar as rotas protegidas.

Tecnologias Utilizadas

    Spring Boot
    Spring Security
    JWT (JSON Web Token)
    Hibernate/JPA
    MySQL
