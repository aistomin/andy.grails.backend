#!/bin/bash

set -e  # Exit on any error

echo "🐳 Building Docker image with no cache..."
docker compose build --no-cache

echo "🚀 Starting services with docker-compose..."
docker compose up
