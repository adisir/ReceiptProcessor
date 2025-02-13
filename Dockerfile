FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
CMD ["java", "-jar", "/app/target/ReceiptProcessor-0.0.1-SNAPSHOT.jar"]