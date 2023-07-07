FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn clean package -DskipTests

#
# PACKAGE STAGE
#
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /usr/src/app/target/Azure-Service-bus-0.0.1-SNAPSHOT.jar /usr/app/Azure-Service-bus-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","/usr/app/Azure-Service-bus-0.0.1-SNAPSHOT.jar"]