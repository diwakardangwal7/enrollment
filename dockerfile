FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD  target/theater-1.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/theater-1.1-SNAPSHOT.jar"]