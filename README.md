# Book Management System

This a simple project follows the Hexagonal Architecture (also known as Ports and Adapters Architecture) pattern. It is implemented using Java and Spring Boot, with some Kotlin and Gradle for build automation. The project is structured to separate the core business logic from the infrastructure and external dependencies.

## Table of Contents

- [Key Components](#key-components)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Building the Project](#building-the-project)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Key Components

### Domain Layer
- Contains the core business logic and domain models.
- `BookRepository` interface defines the contract for the repository operations.

### Infrastructure Layer
- Contains the implementation details for interacting with external systems like databases.
- `PostgresqlBookRepository` implements the `BookRepository` interface to interact with a PostgreSQL database.
- `BookJpaEntity` is a JPA entity representing the `Book` in the database.

### Adapters
- Inbound adapters handle incoming requests (e.g., HTTP requests).
- Outbound adapters handle outgoing interactions (e.g., database operations).

### Example Files
- `BookController.java`: An inbound adapter for handling HTTP requests related to books.
- `PostgresqlBookRepository.java`: An outbound adapter for interacting with the PostgreSQL database.
- `BookJpaEntity.java`: A JPA entity representing the `Book` in the database.
- `BookRepository.java`: A domain port defining the repository operations.

## Getting Started

### Prerequisites
- Java 21 or higher
- Gradle 7.0 or higher
- PostgreSQL 16 or higher

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/mhmd-baraka/hexagonal-architecture.git
   cd hexagonal-architecture
    ```
2. Create a PostgreSQL database named `book_management_system`.
3. Update the `application.yml` file with the correct database configurations.
4. Run the application:
   ```sh
   ./gradlew bootRun
   ```
5. The application will be accessible at `http://localhost:8080`.
6. You can use tools like Postman or cURL to interact with the API.
7. The API documentation is available at `http://localhost:8080/api-documentation`.
8. You can also run the tests using:
   ```sh
   ./gradlew test
   ```
