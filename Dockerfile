FROM openjdk:21-jdk
LABEL authors="Zach"

# Create a non-root user and group
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Set the working directory
WORKDIR /app

# Copy the application JAR with proper permissions
COPY --chown=appuser:appgroup target/prophet-api*.jar app.jar

# Label metadata
LABEL maintainer="Zach"
LABEL description="Dockerfile for Example Spring Boot API"

# Set environment variables
ENV HOME=/home/appuser
ENV USER=appuser

# Switch to the non-root user
USER appuser

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]