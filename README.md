# Andy Grails' Website. Backend.

[![CI](https://github.com/aistomin/andy.grails.backend/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/aistomin/andy.grails.backend/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/aistomin/andy.grails.backend/graph/badge.svg?token=WZFAART6QM)](https://codecov.io/gh/aistomin/andy.grails.backend)

## System Requirements
- JDK 21 or higher.
- Apache Maven 3.9.8 or higher.
- Docker 28.2.2 or higher.
- Docker Desktop 4.42.1 or higher. 

## How to test and run the app?

To build and test the app run: `mvn clean install package`

To start the app run: `docker-compose up --build`
> The API should be available at [http://localhost:8080](http://localhost:8080)

## How to Contribute
Do you want to help us with the project? We will be more than just happy.
Please: fork the repository, make changes, submit a pull request. We promise
to review your changes in the next couple of days and merge them to the master
branch, if they look correct. To avoid frustration, before sending us your pull
request please run full Maven build:

```
$ mvn clean install package javadoc:javadoc
```
**Note:** We use Testcontainers — make sure Docker is running when you build.
Also, check the [system requirements](#system-requirements).
