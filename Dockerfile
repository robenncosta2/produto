FROM openjdk:17-jdk-alpine
MAINTAINER br.com.itau
COPY target/*.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]
EXPOSE 9000
