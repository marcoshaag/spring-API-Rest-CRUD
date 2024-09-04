<h1>API-REST-CRUD com Validação de Token de Login</h1>

<p>Este repositório contém a base para iniciar um projeto utilizando Spring, com uma tela de login e validações do token de autenticação. O projeto está pronto para ser utilizado como ponto de partida para desenvolver um sistema completo.</p>

<h2>Funcionalidades</h2>
<ul>
    <li><strong>Autenticação de Usuário</strong>: Implementação de login com validação de token JWT.</li>
    <li><strong>CRUD</strong>: Operações de Create, Read, Update e Delete para gerenciar entidades.</li>
    <li><strong>Validações</strong>: Regras de negócio aplicadas na validação dos dados.</li>
    <li><strong>Segurança</strong>: Configuração de segurança para proteger as rotas e endpoints.</li>
</ul>

<h2>Como Funciona</h2>

<h3>Estrutura do Projeto</h3>
<p>O projeto é estruturado utilizando o <strong>Spring Boot</strong>, facilitando a criação de APIs RESTful robustas e escaláveis. A seguir, um resumo das principais camadas do projeto:</p>

<ul>
    <li><strong>Controller</strong>: Define os endpoints e manipula as requisições HTTP.</li>
    <li><strong>Service</strong>: Contém a lógica de negócio e interage com o repositório.</li>
    <li><strong>Repository</strong>: Responsável pela comunicação com o banco de dados.</li>
    <li><strong>Security</strong>: Gerencia a autenticação e autorização dos usuários.</li>
</ul>

<h3>Validação de Token</h3>
<p>O projeto inclui a configuração para geração e validação de tokens JWT, que são utilizados para garantir que apenas usuários autenticados possam acessar as rotas protegidas.</p>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li><strong>Spring Boot</strong></li>
    <li><strong>Spring Security</strong></li>
    <li><strong>JWT (JSON Web Token)</strong></li>
    <li><strong>Hibernate/JPA</strong></li>
    <li><strong>MySQL/PostgreSQL</strong> (ou qualquer outro banco de dados compatível)</li>
</ul>
