FROM openjdk:8-jdk-alpine
LABEL maintainer="leehwdatabase@gmail.com"
VOLUME /tmp
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://192.168.5.32:27017/admin","-jar","app.jar"]

