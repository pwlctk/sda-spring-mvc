FROM openjdk:8
ADD target/spring-mvc-docker.jar spring-mvc-docker.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "spring-mvc-docker.jar"]