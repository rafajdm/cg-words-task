## About

This is a simple code that connects to RapidAPI (wordsAPI) to obtain a list of synonyms from a given word. Code was written in Java Spring Boot with WebFlux (webclient) to consume to WordsAPI and Spring MVC to expose a REST API where the service can be consumed.

Endpoint Data:
- GET http://{server-ip:port}/api/v1/synonyms/{word}
- Response String JsonObject array[]

Notes:
- RapidAPI credentials must be provided in application.properties

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/cl/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle 8.2.1](https://gradle.org/install/)

## Running the application locally

To run the application locally you can use a local gradle installation or the gradle wrapper. Open a command line and go to the project folder and execute the command

- gradlew clean bootRun
