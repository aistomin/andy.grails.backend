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

# Set the working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.war app.war

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.war"]
