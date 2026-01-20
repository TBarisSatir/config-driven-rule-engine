# Config-Driven Rule Engine

> This project is intentionally designed to be stateless and container-ready.
A lightweight Spring Boot microservice that evaluates text inputs against predefined rules and returns whether a rule is matched. It is designed to run independently and is currently integrated with the **spring-boot-task-management-api**, where task descriptions are validated before creation. This separation allows business rules to be updated or extended without modifying the main application.
