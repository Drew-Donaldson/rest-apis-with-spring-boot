# Spring Boot Cricket API

## Project Overview
This repository contains a Spring Boot 3 application developed as part of the Udemy course *"Spring Boot 3 and Spring Framework 6"* by Shabbir Dawoodi, covering **Section 7: Building REST APIs with Spring Boot** and **Section 9: Spring Boot Advanced**. The project implements a RESTful API for managing cricket-related data, such as matches, players, and scores, with basic CRUD operations from Section 7 and advanced Spring Boot features from Section 9, including dependency injection, validation, exception handling, and advanced configurations.

### Key Features
- **Section 7: Building REST APIs with Spring Boot**:
    - Developed a RESTful API with CRUD operations for cricket entities (e.g., matches, players).
    - Implemented controllers, services, and repositories using Spring Boot best practices.
    - Configured data persistence with an in-memory database (H2) for testing.
    - Added request and response validation using Spring Validation.
    - Implemented basic error handling for API responses.
- **Section 9: Spring Boot Advanced**:
    - Enhanced the API with advanced Spring Boot features like custom configuration properties.
    - Used dependency injection with `@Autowired` and `@Qualifier` for flexible component wiring.
    - Implemented global exception handling with `@ControllerAdvice`.
    - Added logging with SLF4J or Logback for debugging and monitoring.
    - Configured Spring Boot Actuator for application health checks and metrics.
    - Applied advanced data querying with Spring Data JPA (e.g., custom JPQL queries).

## Technologies Used
- **Java**: 17
- **Spring Boot**: 3.x
- **Spring Data JPA**: For data persistence
- **H2 Database**: In-memory database for testing
- **Maven**: Dependency management
- **Postman**: For testing REST endpoints
- **Lombok**: To reduce boilerplate code
- **Spring Boot Actuator**: For application monitoring
- **SLF4J/Logback**: For logging

## Learning Outcomes
Through this project, I gained hands-on experience with:
- Building and structuring RESTful APIs using Spring Boot controllers, services, and repositories.
- Implementing CRUD operations with Spring Data JPA and an in-memory database.
- Applying validation and error handling for robust API design.
- Configuring advanced Spring Boot features like custom properties and Actuator endpoints.
- Using dependency injection to create loosely coupled components.
- Implementing global exception handling and logging for production-ready applications.