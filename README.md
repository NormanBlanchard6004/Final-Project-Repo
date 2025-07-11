RecipeShare (Backend API)
RecipeShare is a backend REST API for creating, viewing, updating, and deleting recipes. Each recipe is associated with a user and may have multiple tags (e.g., "Vegan", "Dessert"). The app is built using Java, Spring Boot, and MySQL, and supports full CRUD operations across entities.

Features
- Full CRUD operations for Users and Recipes
- Each Recipe belongs to a User (one-to-many)
- Recipes can be associated with multiple Tags (many-to-many)
- Many-to-many relationship implemented via a join table (recipe_tag)
- Add and remove tags from recipes (CRUD on the join table)
- RESTful API tested via Postman
- MySQL integration using Spring Data JPA

Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Postman (for API testing)

Running the Project
- Step 1: Set up the MySQL database
CREATE DATABASE recipeshare;
- Step 2: Configure application.properties
In src/main/resources/application.properties, set:
spring.datasource.url=jdbc:mysql://localhost:3306/recipeshare
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081

- Step 3: Run the application
You can run it from your terminal or IDE:
Using Maven: ./mvnw spring-boot:run

API Endpoints
Base URL: http://localhost:8081/api

USERS:
| Method | Endpoint      | Description           |
| ------ | ------------- | --------------------- |
| GET    |  /users       | Get all recipes       |
| GET    |  /users/{id}  | Get a recipe by ID    |
| POST   |  /users       | Create a new recipe   |
| PUT    |  /users/{id}  | Update a recipe by ID |
| DELETE |  /users/{id}  | Delete a recipe by ID |

RECIPES:
| Method | Endpoint             | Description               |
| ------ | -------------------- | ------------------------- |
| GET    |  /recipes            | Get all recipes           |
| GET    |  /recipes/{id}       | Get recipe by ID          |
| POST   |  /recipes            | Create new recipe         |
| PUT    |  /recipes/{id}       | Update recipe by ID       |
| DELETE |  /recipes/{id}       | Delete recipe by ID       |
| PUT    |  /recipes/{id}/tags  | Add tags to a recipe      |
| DELETE |  /recipes/{id}/tags  | Remove tags from a recipe |

TAGS:
| Method | Endpoint | Description      |
| ------ | -------- | ---------------- |
| GET    |  /tags   | Get all tags     |
| POST   |  /tags   | Create a new tag |



