# Use the official OpenJDK 21 image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/ReceiptProcessor-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on (modify if needed)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]