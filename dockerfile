FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/enrollment-v1.jar .

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mymongocontainer:27017/enrollment", "-jar","/enrollment-v1.jar"]