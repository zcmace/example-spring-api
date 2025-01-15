FROM openjdk:21-jdk
LABEL authors="Zach"
WORKDIR /app
COPY . .

RUN chmod +x ./mvnw
RUN ./mvnw clean install
RUN mv ./target/*.jar ./target/build.jar

ENTRYPOINT ["java", "-jar", "/app/target/build.jar"]