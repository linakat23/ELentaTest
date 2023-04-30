# ELentaTest

elenta.lt is an open platform that allows users to create accounts (optional) and post ads for free.

ELentaTest is a test automation project for the elenta.lt web application, built with Java and Selenium WebDriver.

# Installation
To use this project, you need to have the following software installed:

- Java JDK
- Maven
- Chrome browser

To set up the project, clone this repository and open it in Java IDE. Then, import the project as a Maven project and let the IDE download the dependencies.

# Usage
This project provides several test classes that cover different aspects of the ELenta application:

- RegisterUserTest: tests the user registration process by filling out a form with valid nad invalid input and submitting it.
- LoginUserTest: tests the user login process by entering valid and invalid credentials.
- AdCreationTest: tests the creation of a new ad by filling out a form with valid and invalid input and submitting it.

Each test class uses the Selenium WebDriver to interact with the ELenta application and verify its behavior. The tests are implemented using the TestNG framework, which provides a convenient way to define and run tests.

To run the tests, use the Maven command mvn test from the command line, or run the test classes directly from IDE.

# Configuration
The pom.xml file in the project root defines the dependencies and configuration for the project. In particular, it specifies the versions of the Selenium WebDriver and TestNG frameworks that are used, as well as the ChromeDriver binary that is used to control the Chrome browser.

# Contributing
This project is open to contributions and feedback. If you find a bug or have an idea for a new feature, feel free to open an issue or submit a pull request.

# License
This project is licensed under the MIT License. 
