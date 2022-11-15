##
## Build
##
FROM maven:3.6.1-jdk-8-slim AS build

WORKDIR /app

COPY . .
RUN mvn package -DskipTests

##
## Deploy
##
FROM openjdk:8-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/gateway-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]