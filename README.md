# SpringSecurityJWTDemo

## Overview

This project demonstrates how to implement **JWT-based authentication** in a Spring Boot application using **Spring Security**. It includes user registration, login, and role-based access control.

---

## Features

* **User Registration**: Allows new users to register with a username and password.
* **JWT Authentication**: Secure login using JWT tokens.
* **Role-Based Access Control**: Different endpoints are accessible based on user roles.
* **Stateless Security**: No session management; authentication is handled via JWT tokens.

---

## Technologies Used

* **Spring Boot**: Framework for building the application.
* **Spring Security**: Provides authentication and authorization.
* **JWT (JSON Web Token)**: For stateless authentication.
* **BCrypt**: For password hashing.
* **H2 Database**: In-memory database for demo purposes.

---

## Setup

### Prerequisites

* Java 11 or higher
* Maven 3.6+

### Clone the Repository

```bash
git clone https://github.com/SauravMuke54/SpringSecurityJWTDemo.git
cd SpringSecurityJWTDemo
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

---

## Endpoints

### Public Endpoints

* `POST /register`: Register a new user.

  * Request Body:

    ```json
    {
      "username": "user1",
      "password": "password123"
    }
    ```
* `POST /login`: Authenticate and receive a JWT token.

  * Request Body:

    ```json
    {
      "username": "user1",
      "password": "password123"
    }
    ```
  * Response:

    ```json
    {
      "token": "your-jwt-token"
    }
    ```

### Secured Endpoints (JWT Required)

* `GET /user`: Access user information.
* `GET /admin`: Access admin resources (Admin role required).

Include the JWT token in the `Authorization` header as a Bearer token:

```
Authorization: Bearer your-jwt-token
```

---

## Database Configuration

The application uses an H2 in-memory database by default. To configure a different database, modify the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```

---

## Password Encoding

Passwords are stored using BCrypt hashing. To generate a BCrypt hash:

```java
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode("yourpassword");
        System.out.println(hashedPassword);
    }
}
```

---

## License

This project is licensed under the MIT License.
