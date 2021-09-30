FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD AccountSystemWebSpringBoot/target/AccountSystemWebSpringBoot-1.0-SNAPSHOT.war app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]