# TaskFlow

A task-management REST API starter built with Java 17, Spring Boot, Spring Data JPA and PostgreSQL.

## Features
- Create, list, view, update and delete tasks
- Filter tasks by status and search by title
- Task priorities and optional due dates
- Input validation and structured error responses
- PostgreSQL persistence

## Run locally
1. Start PostgreSQL and create a database named `taskflow`.
2. Configure `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` if your local settings differ.
3. Run `mvn spring-boot:run`.
4. API base URL: `http://localhost:8080/api/tasks`.

## Example
`POST /api/tasks` with JSON: `{"title":"Prepare interview","description":"Review Spring Boot","priority":"HIGH"}`.

This repository is a learning/portfolio project. Run the app, test the endpoints, and make sure you understand the implementation before presenting it as shipped work.