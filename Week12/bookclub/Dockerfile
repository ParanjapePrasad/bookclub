#
# Build Stage
#
FROM maven:3.9.0-eclipse-temurin-19 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package Stage
#
FROM openjdk:19
COPY --from=build /target/bookclub-0.0.1-SNAPSHOT.jar bookclub.jar
#ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bookclub.jar"]
