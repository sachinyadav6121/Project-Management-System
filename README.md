# Project_Management_System

This is a simple Project Management System implemented using Java 17 and Spring Boot. It provides CRUD operations for managing projects.  
  
## Setup  
  
1. Clone the repository.  
2. Make sure you have Java 17 and Maven installed.   
3. Navigate to the project directory.  
  
   project-management-system/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   └── com/  
│   │   │           └── sit/  
│   │   │              │── advice/  
│   │   │              │  └── ErrorsDetails.java  
│   │   │              │  └── GlobalExceptionHandler.java  
│   │   │              │  └── ProjectException.java  
│   │   │              ├── model/  
│   │   │              │   └── Project.java  
│   │   │              ├── repository/  
│   │   │              │   └── ProjectRepo.java  
│   │   │              ├── service/  
│   │   │              │   └── IProjectService.java  
│   │   │              │   └── ProjectServiceImpl.java  
│   │   │              ├── controller/  
│   │   │              │   └── ProjectOperationsController.java    
│   │   │              └── ProjectManagementSystemApplication.java  
│   │   └── resources/  
│   │       └── application.properties  
└── pom.xml  
 
5. Run `mvn spring-boot:run` to start the application.  
6. Embaded  server port 8081
7. API Documentation http://localhost:8081/swagger-ui.html
   
## API Usage  
  
## Create a Resource to Insert Project Details  
URL: http://localhost:8081/project-api/addProject  
Method: POST  
Request Body:  
  {  
    "name": "Resource Name",  
    "description": "Resource Description",  
    "startDate":"Project Start Date",  
    "endDate":"Project Completion Date"   
  }  
  
Response:  
201 Created on success  
400 Bad Request if request body is invalid  
500 Internal Server Error on server error  
  
## Get Resource  
URL: http://localhost:8081/project-api/getProject{pid}  
Method: GET  
  
Response Status Codes:  
200 OK on success  
500 Internal Server Error on server error  
  
## Get Resources   
URL:  http://localhost:8081/project-api/getAllProject/{pid}  
Method: GET  
  
Response Status Codes:  
200 OK on success  
500 Internal Server Error on server error  
  
## Update a Resource  
URL:  http://localhost:8081/project-api/updateProject  
Method: PUT  
Request Body:  
{  
    "name": "Updated Resource Name",  
    "description": "Updated Resource Description",
    "startDate":"Updated Project Start Date",  
    "endDate":"Updated Project Completion Date"    
}    
Response Status Codes:  
200 OK on success  
400 Bad Request if request body is invalid  
404 Not Found if resource with the specified ID does not exist  
500 Internal Server Error on server error  
  
## Delete a Resource  
URL:  http://localhost:8081/project-api/deleteProject/{pid}  
Method: DELETE  
Response Status Codes:  
200 OK on success    
404 Not Found if resource with the specified ID does not exist  
500 Internal Server Error on server error  
  
