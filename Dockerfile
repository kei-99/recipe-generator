# Step 1: Build stage (uses Maven to build the JAR)
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy project files and build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Runtime stage (run the built JAR with lightweight JDK)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
