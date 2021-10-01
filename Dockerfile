FROM openjdk:8
EXPOSE 8090
ADD AccountSystemWebSpringBoot/target/AccountSystemWebSpringBoot-1.0-SNAPSHOT.war app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]