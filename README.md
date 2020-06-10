# Holy Craap

In search of the one and only Holy Craap - a treasure also known as "Big Whoop(TM)" - a new adventure game written in Java and
JavaScript, using Spring and React.

## Prerequisite

- [Oracle JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) OR [OpenJDK 11](https://openjdk.java.net/install)
- [Gradle 6.5](https://gradle.org)
- [MySQL server 5.7+](https://dev.mysql.com/downloads)

## Installation

Create a new MySQL user:
- once connected to MySQL, type the following commands :
```sh
CREATE USER 'root1'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON *.* TO 'root1'@'localhost';
FLUSH PRIVILEGES;
ALTER USER 'root1'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root1';
```

Then update the `src/main/resources/application.properties` file.

A new database will be created upon startup.

## Test

Use the following command to run the unit tests:
```sh
gradle clean build
```

## Usage

Run a local server:
```sh
gradle bootRun
```

The server listens on port 8080 by default:
```sh
curl http://localhost:8080
```
```
Yo !
```
