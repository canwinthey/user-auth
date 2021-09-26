FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD target/user-auth-service-0.0.1-SNAPSHOT.jar user-auth-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar user-auth-service-0.0.1-SNAPSHOT.jar"]