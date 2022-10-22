FROM openjdk:8-jdk-alpine
MAINTAINER atakanburakgungor
VOLUME /tmp
EXPOSE 8080
ADD target/appointment-management-0.0.1.jar appointment-management.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/appointment-management.jar"]