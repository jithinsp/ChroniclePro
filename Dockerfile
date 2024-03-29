#FROM openjdk:17
#ADD target/springboot-mysql-docker.jar springboot-mysql-docker.jar
#EXPOSE 8081
#ENTRYPOINT ["java","-jar","/springboot-mysql-docker.jar"]

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app/
COPY target/chronicle.jar /app/target/chronicle.jar
COPY src/main/resources/static /app/src/main/resources/static
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app/target/chronicle.jar"]

