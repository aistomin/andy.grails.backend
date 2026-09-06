# Use the official OpenJDK 25 image as base
FROM eclipse-temurin:25-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the Gradle/Maven wrapper and build files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# ---- Runtime Image ----
FROM eclipse-temurin:25-jre

# Install curl for the container healthcheck (the 25-jre base image,
# unlike 21-jre, does not ship it)
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.war app.war

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.war"]
