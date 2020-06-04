# Booking API

This project contains the representation of an api responsible for managing the CRUD operations associated to bookings.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

```
Docker
Java 11
Maven 3.6.3
Lombok Plugin 1.18.6
Rabbit MQ
```

#### INSTALLING

Install the tool for managing parallel versions of multiple Software Development Kits [SDK MAN](https://sdkman.io/install).

##### JAVA

Execute the following command:

```
sdk install java 11.0.4-sapmchn
```

##### MAVEN

Execute the following command:

```
sdk install maven 3.6.3
```

##### DOCKER

1. Download [Docker](https://www.docker.com/products/docker-desktop)

2. Follow the instructions provided by the wizard.

##### Rabbit MQ

Execute the following command:

```
docker run -d --hostname rabbit --name rabbit-assignment -e RABBITMQ_DEFAULT_VHOST=/ -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

#### Lombok Plugin

Please follow the steps defined on the following links, depending on your IDEA.

* [Lombok Eclipse](https://projectlombok.org/setup/eclipse) - Installing lombok on Eclipse.
* [Lombok Intellij](https://projectlombok.org/setup/intellij) - Installing lombok on Intellij.

## Running in Development Mode

To run the API execute the following command:

```
 mvn spring-boot:run
```

## Running Tests

#### Prerequisites

What things you need to run the tests:

```
Postman
```

#### Postman

1) Download [Postman](https://www.getpostman.com/downloads/) and install it.
2) Import the postman [booking](postman/collection.json) collection.
3) Perform tests using the defined requests. 
