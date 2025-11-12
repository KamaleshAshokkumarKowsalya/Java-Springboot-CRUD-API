<p align="center">
  <img src="https://spring.io/img/projects/spring-boot.svg" alt="Spring Boot" height="80"/>
  <img src="https://www.postgresql.org/media/img/about/press/elephant.png" alt="PostgreSQL" height="80"/>
</p>

# Java Spring Boot CRUD API with JWT Authentication & PostgreSQL

A secure REST API for Todo management, featuring user registration and login with JWT authentication and password encryption. Data is stored persistently in PostgreSQL and follows a clean and scalable project architecture.

---

## 🏗️ Project Structure

```text
HelloWorld/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev.codeIO.HelloWorld/
│   │   │        ├── controller/
│   │   │        │     ├── AuthController
│   │   │        │     └── HelloWorldController
│   │   │        ├── models/
│   │   │        │     ├── Todo
│   │   │        │     └── User
│   │   │        ├── repository/
│   │   │        │     ├── TodoRepository
│   │   │        │     └── UserRepository
│   │   │        ├── service/
│   │   │        │     ├── TodoService
│   │   │        │     └── UserService
│   │   │        └── utils/
│   │   │              ├── HelloWorldApplication
│   │   │              ├── JwtFilter
│   │   │              └── SecurityConfig
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   └── application.properties
│   ├── test/
├── target/
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
```

---

## 🚀 Features

- JWT-based user authentication (register, login)
- Passwords are securely encrypted
- CRUD operations for Todos (Create, Read, Update, Delete)
- Persistent PostgreSQL storage
- Layered architecture for extensibility & maintainability
- RESTful endpoints & DTO usage
- Easy integration and future scalability

---

## 🛠️ Tech Stack

- Java (Spring Boot)
- PostgreSQL
- JWT (JSON Web Token)
- Spring Security
- Lombok
- Maven

---

## 📋 Prerequisites

- Java 17+
- Maven 3.6+
- PostgreSQL instance (with credentials)
- Any IDE (IntelliJ, Eclipse, VS Code, etc.)

---

## 📝 API Endpoints Overview

| Method   | Endpoint             | Description                  |
|----------|----------------------|------------------------------|
| POST     | /auth/register       | Register new user            |
| POST     | /auth/login          | User login & JWT generation  |
| POST     | /todo/create         | Create new todo              |
| GET      | /todo/{id}           | Get todo by ID               |
| GET      | /todo                | Get all todos                |
| PUT      | /todo                | Update todo                  |
| DELETE   | /todo/{id}           | Delete todo by ID            |

*All /todo endpoints require JWT in the Authorization header.*

---

## 🔐 Authentication

- **Register** with `/auth/register`
- **Login** via `/auth/login` to receive your JWT token
- Use JWT for all protected endpoints:  
  `Authorization: Bearer <your-jwt-token>`
- Passwords are securely hashed before being stored—never exposed as plaintext.

---

## 📝 Configuration Example

Adjust your `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
server.port=8081
jwt.secret=YOUR_SECRET_KEY
```

---

## 🧪 Testing

Run all tests:

```bash
mvn test
```

---

## 📦 How Components Work

- **controller:** REST endpoints (AuthController, HelloWorldController)
- **models:** JPA entities (User, Todo)
- **repository:** Data access (UserRepository, TodoRepository)
- **service:** Business logic (UserService, TodoService)
- **utils:** Application entry, JWT filter, security config

---

## 🚀 Getting Started

1. Clone the repository
2. Adjust the config file for PostgreSQL and JWT secret
3. Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

4. Access API at `http://localhost:8081`

---

## 📄 License

MIT License

---

## 🤝 Contributing

- Fork, branch, commit, pull request
- Share tests and clear documentation for new features

---

## 📞 Support

Open a GitHub issue for help or requests.

---

**Happy Coding! 🚀**
