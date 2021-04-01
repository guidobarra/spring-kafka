#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/spring-kafka*.jar /usr/local/lib/spring-kafka.jar
EXPOSE 9290
ENTRYPOINT ["/bin/sh", "-c" , "echo 'waitting....' && sleep 10 && java -jar /usr/local/lib/spring-kafka.jar"]