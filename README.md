# Employee Management REST API

A RESTful backend application built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL to manage employee records.

## Features

- Create, retrieve, update, and delete employee records
- Persistent storage with MySQL and Spring Data JPA
- DTOs for request and response handling
- Bean Validation for employee names and salaries
- Centralized exception handling with appropriate HTTP status codes
- Pagination and sorting of employee records
- Case-insensitive employee name search

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Postman

## Setup

1. Clone this repository.
2. Create a MySQL database named `employee_db`.
3. Configure the database URL, username, and password using environment variables.
4. Run the application using IntelliJ IDEA or Maven.

## API Endpoints

This API provides endpoints for managing employee data:

*   **POST** `/employees`: Create a new employee.
*   **GET** `/getall`: Retrieve all employees with pagination and sorting.
*   **GET** `/getbyid/{id}`: Retrieve an employee by ID.
*   **PUT** `/update/{id}`: Update an existing employee.
*   **DELETE** `/delete/{id}`: Delete an employee.
*   **GET** `/employees/search?name=uts`: Search employees by name.

## Example Request

`POST /employees`

```json
{
  "name": "Utsav",
  "salary": 35000
}
```

## Author

Utsav Kumar
