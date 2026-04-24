# Fullstack Notes Manager 📝

Sistema de gerenciamento de notas com suporte a **Markdown**. O usuário escreve em Markdown no front-end, o back-end processa para HTML e persiste os dados.

## 🏗️ Arquitetura
O projeto é dividido em duas partes principais:
1. **API (Back-end)**: Spring Boot + PostgreSQL.
2. **Web (Front-end)**: Angular + HttpClient.



## 🚀 Tecnologias
### Back-end
* Java 21 / Spring Boot 3
* Spring Data JPA / PostgreSQL 🐘
* Commonmark (Conversão Markdown -> HTML)

### Front-end
* Angular 🅰️
* TypeScript
* CSS/SCSS

## 🛠️ Funcionalidades
* [x] **CRUD de Notas**: Criar, listar, visualizar e deletar.
* [x] **Markdown Engine**: Renderização automática no servidor.
* [x] **CORS Configurado**: Comunicação liberada entre porta 8080 e 4200.

## 📡 API Endpoints (Exemplos)
| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/notes` | Lista todas as notas |
| POST | `/api/notes` | Cria uma nova nota |
| DELETE | `/api/notes/{id}` | Remove uma nota |

## 💻 Como Rodar
1. Configure o PostgreSQL no `application.properties`.
2. Execute o Spring Boot (`mvn spring-boot:run`).
3. No diretório do front-end, execute `npm install` e `ng serve`.
