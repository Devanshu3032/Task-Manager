# Smart Task Manager REST API

A backend REST API built using Java and Spring Boot for managing tasks.

The application provides CRUD operations, validation, exception handling,
filtering, sorting, and pagination.

## 🚀 Technologies Used

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- Postman
- Git & GitHub

## 🏗️ Project Architecture

Postman / Client
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
MySQL Database

## ✨ Features

- Create a task
- Get all tasks
- Get task by ID
- Update a task
- Delete a task
- Filter tasks by status
- Sort tasks
- Pagination
- Request validation
- Global exception handling
- Status validation
- Priority validation

## 📁 Project Structure

src/main/java/com/devanshu/taskmanager

├── controller
│   └── TaskController.java
│
├── service
│   └── TaskService.java
│
├── repository
│   └── TaskRepository.java
│
├── entity
│   └── Task.java
│
├── dto
│   └── TaskRequest.java
│
└── exception
    ├── TaskNotFoundException.java
    └── GlobalExceptionHandler.java

## ⚙️ Setup & Installation

### 1. Clone the repository

git clone <YOUR_GITHUB_REPOSITORY_URL>

### 2. Open the project

Open the project in IntelliJ IDEA or VS Code.

### 3. Configure MySQL

Create the database:

CREATE DATABASE taskmanager_db;

### 4. Configure environment variable

The application uses the DB_PASSWORD environment variable
for the MySQL password.

Set:

DB_PASSWORD=your_mysql_password

Do not put the actual database password directly into GitHub.

### 5. Run the application

Windows:

.\mvnw.cmd spring-boot:run

The application will start on:

http://localhost:8080

## 🔗 API Endpoints

### Create Task

POST /api/tasks

Example request:

{
  "title": "Learn Spring Boot",
  "description": "Understand REST APIs and JPA",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2026-09-12"
}

### Get All Tasks

GET /api/tasks

### Get Task By ID

GET /api/tasks/{id}

Example:

GET /api/tasks/1

### Update Task

PUT /api/tasks/{id}

### Delete Task

DELETE /api/tasks/{id}

### Filter By Status

GET /api/tasks?status=PENDING

Supported statuses:

- PENDING
- IN_PROGRESS
- COMPLETED

### Sorting

GET /api/tasks?sortBy=dueDate&direction=asc

Supported direction values:

- asc
- desc

### Pagination

GET /api/tasks?page=0&size=5

Example:

page=0 → first page

size=5 → maximum 5 tasks per page

### Pagination + Sorting

GET /api/tasks?page=0&size=3&sortBy=dueDate&direction=asc

### Filtering + Pagination + Sorting

GET /api/tasks?status=PENDING&page=0&size=2&sortBy=dueDate&direction=asc

## ✅ Validation

The following fields are required:

- title
- status
- priority

Priority must be one of:

- LOW
- MEDIUM
- HIGH

Status must be one of:

- PENDING
- IN_PROGRESS
- COMPLETED

Invalid requests return:

400 Bad Request

Example validation response:

{
  "message": "Validation failed",
  "errors": {
    "title": "Title is required"
  },
  "status": 400
}

## ❌ Exception Handling

If a task does not exist:

GET /api/tasks/99

The API returns:

404 Not Found

Example:

Task not found with id: 99

## 🧪 Testing

The API can be tested using Postman.

Tested functionality includes:

- Create task
- Get all tasks
- Get task by ID
- Update task
- Delete task
- Status filtering
- Sorting
- Pagination
- Validation
- Exception handling

## 🔐 Security Note

Database credentials are stored using environment variables
and should not be committed to GitHub.

## 👨‍💻 Author

Devanshu Kumar

CSE Student