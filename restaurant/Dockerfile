FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/restaurant-service.jar .
EXPOSE 8080
ENTRYPOINT [ "java","-jar","restaurant-service.jar"]