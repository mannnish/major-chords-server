FROM maven:3.6.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/majorChordsServer-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "majorChordsServer-0.0.1-SNAPSHOT.jar"]