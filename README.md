# Helmes Backend Application Assignment

## Description
The Helmes backend application handles communication between the frontend and the database. It is built using Java Spring Boot and PostgreSQL for the database. The schemas are created using scripts located in the `resources/migration` directory.

## Project Structure
The project structure is organized as follows:
- **src/main/java**: Java source code directory.
    - **homework.sector**: Package containing sector-related classes.
        - **controller**: Controller classes for handling sector-related requests.
        - **entity**: Entity classes representing sectors.
        - **repository**: Repository interfaces for interacting with sector data.
        - **service**: Service classes for sector-related business logic.
    - **homework.user**: Package containing user-related classes.
        - **controller**: Controller classes for handling user-related requests.
        - **entity**: Entity classes representing users.
        - **repository**: Repository interfaces for interacting with user data.
        - **service**: Service classes for user-related business logic.
    - **HelmesApplication**: Main application class.
- **src/main/resources**: Resources directory.
    - **migration**: Directory containing SQL migration scripts.
- **src/test**: Directory containing test files.
- **application.properties**: Application properties file containing configuration settings.

## Technologies Used
- **Java Spring Boot**: A popular Java framework for building web applications.
- **PostgreSQL**: An open-source relational database management system.
- **Flyway**: A database migration tool for managing database changes.
- **Lombok**: A Java library that helps reduce boilerplate code.

## Setup
Before running the application, ensure the following requirements are met:
- **Java**: Java Development Kit (JDK) installed.
- **Gradle**: Gradle build tool installed.
- **Port Availability**: Ensure that port 8080 is free to use.

## Running the Project
To run the project, follow these steps:
1. Ensure that the database configurations in `application.properties` are correct.
2. Navigate to the `HelmesApplication` class located in `src/main/java/com/helmes/homework/HelmesApplication.java` and run it.
3. Alternatively, you can build and run the application, using this following command in terminal: **./gradlew bootRun**
