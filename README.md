# Twino-homework

Twino-homework is a demo app for loan management.

## Local setup

To run the app, simply execute the "run" Gradle task from build.gradle (i.e. "gradlew run" in the terminal). The app was tested on JDK 1.8.0_60.

## Usage

The app has 2 REST endpoints:

* List all approved loan requests (basically, lists everything, because disapproved requests don't get persisted)
```
GET http://hostname:4567/list 
```

* Apply for a loan. See below for the URL and input payload format.

```
POST http://hostname:4567/apply
{
  "name": "John",
  "surname": "Doe",
  "personalId": "120689-20567",
  "term": "22.08.2019",
  "loanAmount": "123.45"
}
```
Payload examples can also be found in the test resources.

For testing purposes, the database is being initially populated in the LocalDatabaseConfiguration class. Change the SQL
statements if you want to add something (i.e. blacklist a personal ID), and then restart the app.

## Building blocks


The system is based on multiple lightweight frameworks and technologies:

* Spark - provides a clean and simple way to setup a REST API.
* JOOQ - basic ORM provider and JDBC wrapper. Handles the persistence.
* Spock - a Groovy alternative to JUnit with many interesting features.

* Feign - a REST client with minimalistic configuration requirements.
* H2 - an embedded RDBMS.
* Lombok - provides syntactic sugar by eliminating a great deal of boilerplate code.

## Architectural and technical concepts

I decided not to use a heavy framework like Spring Boot, and went for a more lightweight solution, because, the way I 
see it, this app has all it takes to be a microservice, and microservices should be light, small, fast and
scalable. While Spring has some very nice features like loose code coupling, rapid development out of the box and the
ability to easily integrate virtually anything, to me it just seems too heavy for this app - the set of features it has is
overkill, it takes time to fire up the context, etc. Spark, on the other hand, weighs nothing and starts momentarily.

The controllers of the system are implemented as singletons, so they should be thread-safe. In fact, the only thing that 
needs improvement in order to scale this app horizontally, is the blacklist cache - currently there is no mechanism that
would sync it between the nodes, so it wouldn't be consistent in a cluster. I wanted to use a distributed data grid,
like Hazelcast, but then decided not to, because it would require network configurations for running the app, it takes a
lot of space, and scaling was out of scope of the task.

If the app were "real", I'd also add Hystrix to the REST client that checks country codes, and possibly add a circuit breaker.
That way, we wouldn't have a chain of timeouts if the external service went down. But, again, this was out of scope.

Logs are non-existent, and the database is also obviously not production-ready. I'd use ELK and Mongo for these purposes
in the real world.

All controllers are covered with unit tests, written in Spock. I've developed a liking for this framework recently, to me
it seems more convenient than JUnit (at least JUnit 4), but that's a matter of taste, I guess.
