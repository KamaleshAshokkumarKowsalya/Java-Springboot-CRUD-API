# Java Spring Boot CRUD API

A simple Todo management REST API built with Spring Boot, featuring full CRUD operations for managing todo items.

## 🚀 Features

- **Create** new todo items
- **Read** todo items (single and all)
- **Update** existing todo items
- **Delete** todo items
- In-memory H2 database for development
- RESTful API endpoints
- Lombok for reducing boilerplate code

## 🛠️ Tech Stack

- **Java 25**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Lombok**
- **Maven** (build tool)

## 📋 Prerequisites

- Java 25 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/dev/codeIO/HelloWorld/
│   │   ├── HelloWorldApplication.java    # Main Spring Boot application
│   │   ├── HelloWorldController.java     # REST controller for API endpoints
│   │   ├── TodoService.java              # Business logic layer
│   │   ├── TodoRepository.java           # Data access layer
│   │   └── models/
│   │       └── Todo.java                 # Todo entity model
│   └── resources/
│       └── application.properties        # Application configuration
└── test/
    └── java/dev/codeIO/HelloWorld/
        └── HelloWorldApplicationTests.java
```

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd Java-Springboot-CRUD-API-master
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The application will start on **port 8081**.

### 4. Access H2 Database Console
- URL: `http://localhost:8081/h2-console`
- JDBC URL: `jdbc:h2:mem:tododb`
- Username: `admin`
- Password: `1234`

## 📡 API Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `POST` | `/todo/create` | Create a new todo | `{"title": "string", "description": "string", "isCompleted": boolean}` |
| `GET` | `/todo/{id}` | Get todo by ID | - |
| `GET` | `/todo` | Get all todos | - |
| `PUT` | `/todo` | Update a todo | `{"id": long, "title": "string", "description": "string", "isCompleted": boolean}` |
| `DELETE` | `/todo/{id}` | Delete todo by ID | - |

## 📝 Todo Model

```java
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String description;
    Boolean isCompleted;
}
```

## 🔧 Configuration

The application is configured in `application.properties`:

```properties
spring.application.name=HelloWorld
server.port=8081

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:tododb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=1234

# H2 Console
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.hibernate.ddl-auto=update
```

## 📚 Example Usage

### Create a Todo
```bash
curl -X POST http://localhost:8081/todo/create \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Learn Spring Boot",
    "description": "Complete Spring Boot tutorial",
    "isCompleted": false
  }'
```

### Get All Todos
```bash
curl -X GET http://localhost:8081/todo
```

### Get Todo by ID
```bash
curl -X GET http://localhost:8081/todo/1
```

### Update a Todo
```bash
curl -X PUT http://localhost:8081/todo \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "title": "Learn Spring Boot - Updated",
    "description": "Complete Spring Boot tutorial - Done!",
    "isCompleted": true
  }'
```

### Delete a Todo
```bash
curl -X DELETE http://localhost:8081/todo/1
```

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

## 📦 Dependencies

- **spring-boot-starter-web**: Web framework
- **spring-boot-starter-data-jpa**: JPA and Hibernate
- **h2**: In-memory database
- **lombok**: Reduces boilerplate code
- **spring-boot-starter-test**: Testing framework

## 🔍 Key Components

### HelloWorldController
REST controller handling HTTP requests and responses for todo operations.

### TodoService
Business logic layer containing methods for CRUD operations.

### TodoRepository
Data access layer extending JpaRepository for database operations.

### Todo Entity
JPA entity representing the todo model with Lombok annotations.

## 🚀 Development

### Adding New Features
1. Create new endpoints in `HelloWorldController`
2. Add business logic in `TodoService`
3. Extend `TodoRepository` if needed
4. Update the `Todo` entity for new fields

### Database Schema
The application uses H2 in-memory database with auto-update schema. Tables are created automatically based on JPA entities.

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📞 Support

For questions or support, please open an issue in the repository.

---

**Happy Coding! 🎉**
