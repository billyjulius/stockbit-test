# Stockbit Test
___

This is repository contained answer for Stocbit test. <br>
There is 5 question, for question no 1 - 3 is web automation. 
And question no 4 - 5 is api automation.

There is 2 maven module here, `web-test` is for web automation
and `api-test` for API automation

## Required
- Java 8 ([download](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html))
- Maven ([download](https://maven.apache.org/download.cgi))
- Chromedriver ([download](https://chromedriver.chromium.org/downloads)) <br>
Make sure `chromedriver` location included in `PATH` environment variable

## Setup
- Clone this repository
- Open with Java IDE (I'm using [Intellj IDEA](https://www.jetbrains.com/idea/))
- Let maven import all required dependency
- Run the command

### 1. Web automation
- Automation using [Serenity BDD](https://serenity-bdd.github.io/) combined with Cucumber
- Command to run
    ```
    mvn clean verify -pl web-test
    ```
- If want to run specified scenario
    ```
    mvn clean verify -pl web-test -Dcucumber.options="--tags @search"
    ```
- Available tags:
  - `@select` for question no 1
  - `@search` for question no 2
  - `@detail` for question no 3

### 2. API Automation
- Automation using framework [TestNG](https://testng.org/doc/) with [Rest Assured](https://rest-assured.io/)
- Command to run
  ```
    mvn clean test -pl api-test
  ```