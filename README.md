# NABAPI's challenge
This repo contains the source code of api automation test.

## These components run the Framework. They are all required:
- Java (1.8)
- IntelliJ IDE or Eclipse (I'm using IntelliJ IDE)
- JUnit
- Maven (https://maven.apache.org/download.cgi)

## Constructed by:
- Rest Assured: REST services caller (https://rest-assured.io/)
- Maven Cucumber Report: Extract the report after finish the test (https://github.com/damianszczepanik/maven-cucumber-reporting)

## Running Your First Test:
 - Before run, wait until all dependencies downloaded.
 - There are two ways to run test:
   - Run with command line "mvn test verify" to execute all Test Scenarios (See report in html in /reports/cucumber-html-reports) 
   - Run the test in /src/test/java/cucumber/run/TestRunner (See report in html in /reports/cucumber-report) 

(Notes: When using mvn to execute test with parameter @Regression, @Performance, or @APIContract. 
   Ex: (mvn test verify -Dcucumber.options = "--tags @Regression") this command will execute all scenarios which have annotation @Regresion