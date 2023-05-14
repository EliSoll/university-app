[![LinkedIn][linkedin-shield]][linkedin-url]

<div align="center"><h1><img src="https://cdn-icons-png.flaticon.com/512/1183/1183669.png" alt="Logo" width="140" height="90">University Console Application</h1></div>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a></li>
 <li><a href="#technologies">Technologies</a></li>
    <li><a href="#models-and-relations">Models and relations</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li><a href="#structure">Structure</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>

## About The Project

This is a simple Spring Boot application that provides a console interface for managing a university's departments and lecturers. It allows you to perform various commands to retrieve information about departments, head of departments, statistics, average salary, employee count, and perform a global search.

Video presentation of this application: [video](https://www.loom.com/share/09c5a6df10d44925ad2d6bedcb644f01)
### 🔨Technologies

- Java  ```v.17.0.5 ```
- Maven ```v.3.8.0```
- Spring Boot ```v.3.0.6```
- MySQL Connector/J ```v.8.0.22```
- Checkstyle ```v.9.1```
- Spring Boot Starter Data JPA
- Spring Boot Starter Test
- Lombok

## Models and relations
<div align="center"><a href="https://i2.paste.pics/NY71Y.png"><img src="https://i2.paste.pics/NY71Y.png" alt="demo-app-screen-readme-git" border="0"></a></div>

## Getting Started
To run the application locally, follow these steps:

1. Clone the GitHub repository: [repository-link](https://github.com/EliSoll/university-app)
2. Ensure that you have Java 17 and Maven installed on your system.
3. Configure the MySQL database connection properties in the `application.properties` file.
4. Build the project using the command: `mvn clean install`
5. Run the application using the command: `mvn spring-boot:run`
6. The application will start and display the console interface.

## Structure

The project follows a standard Maven project structure with the main code located in the `src/main/java` directory. The important files and directories are as follows:

- `src/main/java/com/university/app`:
    - `commands`: Contains command implementations for handling user inputs.
    - `config`: Contains configuration classes for the application.
    - `console`: Contains classes related to the console interface.
    - `dto`: Contains Data Transfer Object (DTO) classes.
    - `model`: Contains the entity classes representing the university's departments and lecturers.
    - `repository`: Contains the repository interfaces for database operations.
    - `services`: Contains the service classes for business logic.

- `src/main/resources`:
    - `application.properties`: Contains the configuration properties for the application, including the database connection settings.

- `src/main/resources/data.sql`: Contains SQL statements for initializing the database with sample data.

- `src/test/java`: Contains the test classes for unit testing the application.

## Features
1. **Who is head of department {department_name}**

   Description: Retrieves the head of a specific department.

   Example:
   ```
   User Input: Who is head of department Mathematics
   Answer: Head of Mathematics department is John Smith
   ```

2. **Show {department_name} statistics**

   Description: Retrieves statistics for a specific department, including the count of assistants, associate professors, and professors.

   Example:
   ```
   User Input: Show Mathematics statistics
   Answer: Assistants - 5, Associate Professors - 3, Professors - 2
   ```

3. **Show the average salary for the department {department_name}**

   Description: Retrieves the average salary for a specific department.

   Example:
   ```
   User Input: Show the average salary for the department Computer Science
   Answer: The average salary of Computer Science is $5000
   ```

4. **Show count of employees for {department_name}**

   Description: Retrieves the count of employees (lecturers) for a specific department.

   Example:
   ```
   User Input: Show count of employees for Mathematics
   Answer: 10 employees
   ```

5. **Global search by {template}**

   Description: Performs a global search for lecturers based on a name template (case insensitive).

   Example:
   ```
   User Input: Global search by "ivan"
   Answer: Petro Ivanov, Ivan Petrov
   ```
## Additional Notes

- The application uses a relational database (MySQL) for data storage. Please ensure that you have a running MySQL instance and update the database connection properties accordingly in the `application.properties`

## Contact

Elvira Solnyshkina - elvira.solnyshkina@gmail.com

LinkedIn: [linkedin.com/in/elvira-solnyshkina](https://www.linkedin.com/in/elvira-solnyshkina-232958117/)
<div align="right"><img src="https://i.ibb.co/cJyzyTZ/629b7b077c5cd817694c3233.png" alt="Logo" width="180" height="60">

Project Link: [EliSoll/university-app](https://github.com/EliSoll/university-app)</div>

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/elvira-solnyshkina-232958117/
