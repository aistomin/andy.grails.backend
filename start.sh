#!/bin/bash

set -e  # Exit on any error

echo "🔨 Building the application..."

# Detect Maven or Gradle
if [ -f "pom.xml" ]; then
    ./mvnw clean package -DskipTests
elif [ -f "build.gradle" ] || [ -f "build.gradle.kts" ]; then
    ./gradlew clean build -x test
else
    echo "❌ No Maven or Gradle build file found."
    exit 1
fi

echo "🐳 Building Docker image with no cache..."
docker-compose build --no-cache

echo "🚀 Starting services with docker-compose..."
docker-compose up
