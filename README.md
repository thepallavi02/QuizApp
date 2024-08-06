# QuizApp

**Overview:**
QuizApp is a REST API backend application built using the Spring Boot framework. This web application is designed for managing quizzes and questions. It supports operations such as creating, reading, updating, and deleting quiz-related data.

**Features:**
- **Spring Boot Framework:** Provides a robust foundation for building web applications.

**Dependencies:**
- **Lombok:** Simplifies the code by reducing boilerplate code for model classes.
- **MySQL Connector:** Connects the application with MySQL database for data storage.
- **Spring Boot Web:** Enables the development of web applications with RESTful APIs.
- **Spring Data JPA:** Facilitates interaction with the database through JPA repositories.
- **Spring MVC:** Implements the Model-View-Controller pattern for clean separation of concerns.

**Functionality:**
- **Create, Update, Delete Quizzes:** Users can manage quizzes by adding, modifying, or removing them.
- **Manage Questions:** Allows CRUD operations on questions including adding, updating, and deleting.
- **Quiz Service:** Handles quiz-related functionalities such as generating quizzes from a set of questions.
- **Question Service:** Manages questions, including fetching, adding, and updating.

**Usage:**
- **Database:** PostgreSQL is used as the database for storing questions and quizzes.
- **Testing:** Use Postman or any other API testing tool to verify the functionality of the REST APIs.
