FROM openjdk
EXPOSE 8080
ADD target/Azure-Service-bus-0.0.1-SNAPSHOT.jar Azure-Service-bus-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java" ,"-jar","/Azure-Service-bus-0.0.1-SNAPSHOT.jar"]