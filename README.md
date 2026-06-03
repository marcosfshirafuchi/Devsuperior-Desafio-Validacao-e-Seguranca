# <a href="https://imgbb.com/"><img src="https://i.ibb.co/S42fsBL4/Devsuperior-logo.png" alt="Devsuperior logo" border="0" width="300"></a> Java Spring Expert - Desafio Validação e Segurança

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-green)
![Spring Security](https://img.shields.io/badge/Spring_Security-6.x-brightgreen)
![OAuth2](https://img.shields.io/badge/OAuth2-Authorization-red)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue)
![H2 Database](https://img.shields.io/badge/H2-Database-lightgrey)

## 👨‍💻 Desenvolvido por

**Marcos Shirafuchi**

* GitHub: https://github.com/marcosfshirafuchi
* Desenvolvedor Backend Java
* Formação Java Spring Expert - DevSuperior

---

# 📚 Sobre o Projeto

Este projeto foi desenvolvido como parte do curso **Java Spring Expert**, ministrado pelo professor **Nélio Alves**, na plataforma DevSuperior.

O objetivo do desafio é implementar autenticação, autorização e validações utilizando Spring Security, OAuth2 Authorization Server, JWT e Bean Validation.

---

# 🎯 Objetivos do Desafio

* Implementar autenticação OAuth2
* Gerar e validar tokens JWT
* Aplicar controle de acesso baseado em perfis
* Aplicar validações com Bean Validation
* Garantir que todos os testes automatizados passem
* Implementar proteção de endpoints REST

---

# 🏗️ Modelo Conceitual

O sistema consiste em um gerenciamento de eventos e cidades, com autenticação e autorização baseada em perfis de usuário.

<p align="center">
    <img src="https://i.ibb.co/1YkFr9vS/Chat-GPT-Image-1-de-jun-de-2026-23-55-23.png"
         alt="Modelo Conceitual - Desafio Validação e Segurança"
         width="900">
</p>

### Relacionamentos

#### User ↔ Role

Um usuário pode possuir um ou mais perfis:

* ROLE_CLIENT
* ROLE_ADMIN

#### City ↔ Event

* Uma cidade pode possuir vários eventos
* Um evento pertence a uma única cidade

---

# ✨ Funcionalidades

* Cadastro de cidades
* Cadastro de eventos
* Consulta de cidades
* Consulta de eventos
* Autenticação OAuth2
* Autorização baseada em perfis
* Geração e validação de JWT
* Tratamento global de exceções
* Validação de dados

---

# 🔐 Regras de Controle de Acesso

### Público

* GET /cities
* GET /events

### CLIENT

Pode:

* Inserir eventos

### ADMIN

Pode:

* Inserir eventos
* Inserir cidades
* Demais operações protegidas

---

# ✅ Regras de Validação

## City

```java
@NotBlank(message = "Campo requerido")
private String name;
```

Validação:

* Nome não pode ser vazio

## Event

```java
@NotBlank(message = "Campo requerido")
private String name;

@NotNull(message = "Campo requerido")
@FutureOrPresent(message = "A data do evento não pode ser passada")
private LocalDate date;

@NotNull(message = "Campo requerido")
private Long cityId;
```

Validações:

* Nome não pode ser vazio
* Data não pode ser passada
* Cidade não pode ser nula

---

# 🔑 Perfis de Usuário

| Usuário                               | Perfil                  |
| ------------------------------------- | ----------------------- |
| [ana@gmail.com](mailto:ana@gmail.com) | ROLE_CLIENT             |
| [bob@gmail.com](mailto:bob@gmail.com) | ROLE_CLIENT, ROLE_ADMIN |

---

# 🚀 Tecnologias Utilizadas

## Backend

* Java 25
* Spring Boot 4.0.6
* Spring Web
* Spring Data JPA
* Spring Security
* OAuth2 Authorization Server
* OAuth2 Resource Server
* JWT
* Bean Validation

## Banco de Dados

* H2 Database

## Testes

* JUnit 5
* MockMvc

## Ferramentas

* Maven
* IntelliJ IDEA
* Postman

---

# 🔗 Endpoints Principais

## Cities

| Método | Endpoint |
| ------ | -------- |
| GET    | /cities  |
| POST   | /cities  |

## Events

| Método | Endpoint |
| ------ | -------- |
| GET    | /events  |
| POST   | /events  |

## OAuth2

| Método | Endpoint      |
| ------ | ------------- |
| POST   | /oauth2/token |

---

# ✅ Critérios de Correção

**Mínimo para aprovação: 10 de 12 testes passando**

## Events

| Endpoint     | Cenário                        | Resultado Esperado       |
| ------------ | ------------------------------ | ------------------------ |
| POST /events | Usuário não logado             | 401 Unauthorized         |
| POST /events | CLIENT logado e dados válidos  | 201 Created              |
| POST /events | ADMIN logado e dados válidos   | 201 Created              |
| POST /events | ADMIN logado e nome em branco  | 422 Unprocessable Entity |
| POST /events | ADMIN logado e data no passado | 422 Unprocessable Entity |
| POST /events | ADMIN logado e cidade nula     | 422 Unprocessable Entity |
| GET /events  | Página de recursos             | 200 OK                   |

## Cities

| Endpoint     | Cenário                       | Resultado Esperado       |
| ------------ | ----------------------------- | ------------------------ |
| POST /cities | Usuário não logado            | 401 Unauthorized         |
| POST /cities | CLIENT logado                 | 403 Forbidden            |
| POST /cities | ADMIN logado e dados válidos  | 201 Created              |
| POST /cities | ADMIN logado e nome em branco | 422 Unprocessable Entity |
| GET /cities  | Recursos ordenados por nome   | 200 OK                   |

---

# 📂 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   ├── config
│   │   ├── controllers
│   │   ├── dto
│   │   ├── entities
│   │   ├── repositories
│   │   ├── services
│   │   └── exceptions
│   └── resources
└── test
    └── java
```

---

# ▶️ Como Executar

```bash
git clone https://github.com/marcosfshirafuchi/SEU-REPOSITORIO.git
cd SEU-REPOSITORIO
mvn spring-boot:run
```

---

# 🧪 Executar os Testes

```bash
mvn test
```

---

# 📖 Aprendizados

Durante este desafio foram praticados:

* Spring Security
* OAuth2 Authorization Server
* OAuth2 Resource Server
* JWT
* Controle de acesso baseado em perfis (RBAC)
* Bean Validation
* Tratamento global de exceções
* APIs REST seguras
* Testes automatizados com MockMvc

---

# 🎓 Curso

Java Spring Expert

Professor: Nélio Alves

Plataforma DevSuperior

https://devsuperior.com.br

---

# ⭐ Agradecimentos

Agradecimento ao professor Nélio Alves e à DevSuperior pelos ensinamentos sobre autenticação, autorização e segurança em aplicações Java Spring.
