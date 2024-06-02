#
# Build Stage
#

# FROM maven:3.9.0-eclipse-temurin-17-alphin AS build
FROM maven:3.9.0-eclipse-temurin-19 AS build
WORKDIR /bookclub
COPY . .
RUN mvn clean package -DskipTests

#
# Package Stage
#
FROM openjdk:19
COPY --from=build /target/bookclub.jar bookclub.jar
#ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bookclub.jar"]
