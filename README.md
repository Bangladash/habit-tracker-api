his project is a RESTful API developed using Java and Spring Boot, designed to manage daily habits and track user progress over time. The application allows users to create habits, register their daily completion, and maintain a history that can be used to analyze consistency and behavior.

The system was built following common backend development practices, with a clear separation of responsibilities across layers such as controller, service, repository, and DTO. It also includes validation mechanisms and a global exception handling strategy to ensure consistent and meaningful responses.

The API provides core functionalities such as user management, habit creation, and daily tracking. Each user can have multiple habits, and each habit can be marked as completed once per day. The application enforces business rules such as preventing duplicate records for the same habit on the same date and ensuring that user emails are unique.

Technically, the project uses Spring Web for building REST endpoints, Spring Data JPA for database interaction, and PostgreSQL as the relational database. Lombok is used to reduce boilerplate code, and Bean Validation is applied to ensure data integrity at the API level.

This project was developed with the goal of practicing backend development and demonstrating knowledge of building structured and maintainable APIs using Java and Spring Boot. It reflects a focus on clean code, organization, and real-world application logic.
