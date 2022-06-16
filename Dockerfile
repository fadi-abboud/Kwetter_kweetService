FROM maven:3.5-jdk-8 AS build
MAINTAINER Fadi Abboud <fadiabboud591@gmail.com>
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM gcr.io/distroless/java:8
COPY --from=build /usr/src/app/target/kweet-service-1.0.2.jar /usr/app/kweet-service-1.0.2.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/app/kweet-service-1.0.2.jar"]