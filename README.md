# Employee Management System

## Overview
This Employee Management System is built using Java, Servlet, and JSP technologies, following the MVC (Model-View-Controller) architectural pattern. It provides a simple yet effective platform for managing employee records within an organization. The front-end interface is developed using JSP, while PostgreSQL is used as the backend database management system.

## Database Setup
To integrate the project with your database, follow these steps carefully:

1. **Install PostgreSQL:** Ensure PostgreSQL is installed on your system.

2. **Create Database:**
   - Create a database with the name: "Company".

3. **Create Table:**
   - Within the "Company" database, create a table named "employee".

4. **Define Columns:**
   - The "employee" table should have the following columns:
     1. id (Data Type: Serial)
     2. name (Data Type: Text)
     3. salary (Data Type: Numeric)
     4. number (Data Type: Text)
     5. password (Data Type: Text)
     6. roll (Data Type: Text)

   Ensure that the column names are exactly as specified above, as any deviation may lead to malfunctioning.

## Instructions
- Clone the repository to your local machine.
- Set up PostgreSQL and create the required database and table as per the provided instructions.
- Configure the database connection settings in the project configuration files.
- Deploy the project on your preferred Java application server (e.g., Apache Tomcat).
- Access the application through the provided URL and start managing employee records efficiently.

## Contributors
- [Your Name]

## License
This project is licensed under the [MIT License](LICENSE).
