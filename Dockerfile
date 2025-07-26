# 1- Build Stage

FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
# 2- Run Stage

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/dealcluster-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]