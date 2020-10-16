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



Heroku deployment configuration

BACKEND DEPLOYMENT 

In order to deploy the application  to Heroku, the user should follow the following steps.

1. Register to Heroku - https://signup.heroku.com/

2. Download Heroku CLI from the following link https://devcenter.heroku.com/articles/heroku-cli#download-and-install.

3. Open command prompt in the application folder. Enter the backend folder and type 'heroku login' .

After succesful login, please type 'heroku create'.

4.After the creation of the application, the application will have some default name. If you wish to change the name to something that makes sense, please type 

heroku app:rename ENTERNEWNAME. 

5. Open the backend application in the IDE, and in the root of the application add a new file called 'Procfile'. In the Procfile, please specify the following line 

 web java -Dserver.port=$PORT $JAVA_OPTS -jar target/auction-0.0.1-SNAPSHOT.jar

After that, create a new file in the root directory called 'system.properties'. Inside of this file, please add the following line

java.runtime.version=8

6. Back to the CMD, leave the backend folder and go to the main auction-app folder that contains both backend and frontend folder.

7. After that, please set the git remote to the application. Do that as following - heroku git:remote -a Your-app-name .

8. Now, enter the following git command  - git subtree push --prefix backend heroku master

9. If the push does not build the app, please double check if You specified the Procfile and system.properties correctly.

Please, visit this link to see how the folder structure in the IDE should look. - https://ibb.co/RhLywG5

10. After a successful build, please visit your application dashboard on the browser. Go to heroku web page, log in, and check out your applications. Your new application should be there.

In the overview of the application You should have 'Installed plugins section'. If everything went ok, there should be a Postgres addon there. Click on it and then go to the Settings overview of the database and then click on 'View credentials'.

Open your IDE of the backend application and add new properties to the Procfile.

Please add the following :

-Dspring.datasource.url=jdbc:postgresql:// YOUR URI HERE

-Dspring.datasource.username= YOUR USERNAME HERE

-Dspring.datasource.password= YOUR PASSWORD here

The Uri, username and password You can find on the dashboard of the database settings View Credentials .

(Please do not forge to include the dash '-' in front of the DSpring declaration in the Procfile.)

11. After You completed these steps, please save it all. Then, open the CMD again in the auction-app folder and add and commit the changes. After the commit, repea push command 

->git subtree push --prefix backend heroku master  

12. Now, Your database should be connected to the heroku web page as well, with DataSeeder filling the database.

With this, the backend deployment of the application should be finished.



FRONTEND HEROKU DEPLOYMENT



