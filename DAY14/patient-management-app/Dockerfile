## Sets the base image to Eclipse-temurin, which contains the Java runtime and development environment.
FROM eclipse-temurin:23-jdk

## Defines a volume at /tmp, allowing temporary files to persist outside the container.
VOLUME /tmp

## Copies the specified JAR file (passed via JAR_FILE) into the container with the name app.jar.
COPY target/*.jar app.jar

## Typically used in Spring Boot applications when running inside a Docker container.
## It ensures that the Java application starts up quickly and runs efficiently.
ENTRYPOINT ["java","-jar","/app.jar"]