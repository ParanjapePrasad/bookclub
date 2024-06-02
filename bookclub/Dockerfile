#
# Build Stage
#

# FROM maven:3.9.0-eclipse-temurin-17-alphin AS build
FROM maven:3.9.0-eclipse-temurin-19 AS build

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY src src

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
