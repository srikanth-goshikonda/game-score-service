# Spring Boot v2.7.9  - Game-Service


## Requirements

For building and running the application you need:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.sdc.GameHighScoresApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Information about game-service.


### Create a Game Resource

```
POST /games
Accept: application/json
Content-Type: application/json

{
    "name":"Minecraft",
    "description":"Erb deems this “the ultimate collaboration” and notes that the popular online game saw a resurgence last year and continues to grow with every new generation of gamer "
}

RESPONSE: HTTP 201 (Created)
```

### Get High Score of Particular Game

```
GET /highscores?gameid=XXXX
Accept: application/json
Content-Type: application/json


RESPONSE: HTTP 200 (OK)
```

### Get Personal High Scores

```
GET /highscores?gameid=XXXX&userName=XXX
Accept: application/json
Content-Type: application/json


RESPONSE: HTTP 200 (OK)
```

### Add Score

```
POST /scores
Accept: application/json
Content-Type: application/json

{
    "gameId": "1",
    "name": "Srikanth",
    "score": "4"
}

RESPONSE: HTTP 201 (CREATED)
```