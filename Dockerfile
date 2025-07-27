# Use the official OpenJDK 21 image as base
FROM eclipse-temurin:21-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the Gradle/Maven wrapper and build files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# ---- Runtime Image ----
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.war app.war

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.war"]
