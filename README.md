# ToWatchlistVersion_2.0
#Movie-List-Web-Application
Overview
This project is a web application developed using Spring Boot, MySQL, and Vue 3, designed to help you manage and list your movie collection. It provides basic CRUD (Create, Read, Update, Delete) operations for your movies, including details such as the movie title, release date, genre, and where to watch it. The frontend is built using Vue 3 and styled with Bootstrap, while the backend is powered by Spring Boot. The project also includes unit tests using JUnit and Mockito for the backend and end-to-end tests using Vue Test Utils (Vuetify) for the frontend.


Prerequisites
Before running this project, make sure you have the following prerequisites installed on your development environment:

Java Development Kit (JDK): Ensure you have Java 8 or later installed.

Maven: You will need Maven as your build tool. Download it from Maven's official website.

Node.js: Ensure you have Node.js and npm (Node Package Manager) installed. Download Node.js from the official website.

Vue CLI: Install Vue CLI globally by running the following command:

Cloning and Installation:
npm install -g @vue/cli
MySQL Database: You should have MySQL installed and running. Create a database for this project and update the database configuration in src/main/resources/application.properties.

Getting Started
Backend (Spring Boot)
Clone the repository:


git clone [repository_url]
Navigate to the backend directory:

cd movie-list/backend
Build and run the Spring Boot application:


mvn spring-boot:run
The backend server should be accessible at http://localhost:8080.

Frontend (Vue 3)
Navigate to the frontend directory:


cd /frontend
Install frontend dependencies:

npm install
Run the Vue development server:

npm run dev


Database Configuration
Update the database configuration in src/main/resources/application.properties to match your MySQL database setup.

properties

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
Backend Testing (JUnit & Mockito)
The backend includes unit tests using JUnit and Mockito. Run these tests with the following command:


cd /backend
mvn test
Frontend Testing (Vue Test Utils & Vuetify)
The frontend includes end-to-end tests using Vue Test Utils with Vuetify. Run these tests with the following command:


cd /frontend
npm run test:unit


Acknowledgments
Thanks to the Spring Boot, Vue, and Bootstrap communities for their excellent documentation and open-source contributions.
Feel free to customize this README to better suit your project's specific details and requirements. Enjoy managing your movie collection with this application!


