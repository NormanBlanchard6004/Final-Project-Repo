RecipeShare (Backend API)
RecipeShare is a simple backend REST API for creating, viewing, updating, and deleting recipes. It’s built with Java, Spring Boot, and MySQL, with full CRUD support for recipes linked to user accounts.

Features
- Create, read, update, and delete recipes
- Each recipe is associated with a user (via foreign key)
- RESTful API tested using Postman
- MySQL database integration using Spring Data JPA

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
Base URL: http://localhost:8081/api/recipes
| Method | Endpoint | Description           |
| ------ | -------- | --------------------- |
| GET    |  /       | Get all recipes       |
| GET    |  /{id}   | Get a recipe by ID    |
| POST   |  /       | Create a new recipe   |
| PUT    |  /{id}   | Update a recipe by ID |
| DELETE |  /{id}   | Delete a recipe by ID |

To create a recipe, a user must already exist in the database. Include the user ID in the JSON body like this:
{
  "title": "Spaghetti",
  "description": "Classic Italian dish",
  "ingredients": "Pasta, Tomato Sauce",
  "instructions": "Boil pasta. Add sauce.",
  "user": {
    "id": 1
  }
}

