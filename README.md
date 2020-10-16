# auction-app
Auctioning Spring &amp; React Web app


Local application configuration


In order to run the app locally, a user has to have Node, Postgres and Java 11 installed. To download them, please visit the following links:

Node -> https://nodejs.org/en/download/

Postgres -> https://www.postgresql.org/download/

Java JDK 11 -> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html


After installing, the user should clone the repository and then create a database of his own. The name and the credentials of the database should be the same as those in the src/resources/application.properties folder of the backend application. 

After creating the database with the specified credentials and name, the user should start the backend spring boot application and make sure that the database seeder DataSeeder has seeded the database with useful data.

In order to make the frontend usable, in the frontend->application-app folder the user should run -> 'npm install' 

The user should make sure that he has all the node dependencies installed. If there are missing node dependencies, please install those that are required.

In order to run the frontend of the application, the user should enter the frontend->application-app folder and run -> 'npm start' in the terminal. 

If the application starts, the user should create an .env file in the application root folder and add the following parameter REACT_APP_BACKEND_ENDPOINT = https://localhost:8080. 

This way, the user will make sure that the application frontend is connected with the backend. For successful usage of the application, the user should run the backend application and then the frontend application. This way, he will make sure that the backend APIs are live and that the frontend part can use those APIs in order to represent real data from the database. 





