# Andy Grails' Website. Backend.

[![CI](https://github.com/aistomin/andy.grails.backend/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/aistomin/andy.grails.backend/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/aistomin/andy.grails.backend/graph/badge.svg?token=WZFAART6QM)](https://codecov.io/gh/aistomin/andy.grails.backend)

This is the backend service for the **Andy Grails** website.  
It is a Java Spring Boot application providing RESTful APIs to serve music data, media, and metadata consumed by the frontend.

For the full project including frontend and main repository, visit:  
[https://github.com/aistomin/andy.grails](https://github.com/aistomin/andy.grails)

## System Requirements

- **Docker** 28.2.2 or higher

> For backend development, if you want to run app or tests directly on your computer:
> - **Docker Desktop** 4.42.1 or higher
> - **JDK** 21 or higher
> - **Apache Maven** 3.9.8 or higher

## How to test and run the app?

To build and test the app run: `./mvnw clean install package javadoc:javadoc`

To start the app, you have two options:

1. **Recommended (ensures fresh build every time):**
   ```bash
   ./start.sh
2. Alternative (manual):
    ```bash
    docker-compose up --build

> The API should be available at [http://localhost:8080](http://localhost:8080)

Docker image is publicly available at [Docker Hub](https://hub.docker.com/r/andygrails/andy-grails-backend).

## API Documentation
Need to check the API documentation? Use these links:

 - Swagger UI: http://localhost:8080/swagger-ui/index.html
Interactive docs, try out endpoints.
 - OpenAPI JSON: http://localhost:8080/v3/api-docs
Raw spec, for tools or integrations.

## How to Contribute
Do you want to help us with the project? We will be more than just happy.
Please: fork the repository, make changes, submit a pull request. We promise
to review your changes in the next couple of days and merge them to the master
branch, if they look correct. To avoid frustration, before sending us your pull
request please run full Maven build:

```
./mvnw clean install package javadoc:javadoc
```
**Note:** We use Testcontainers — make sure Docker is running when you build.
Also, check the [system requirements](#system-requirements).
