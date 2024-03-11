FROM maven:3-openjdk-17 as build-image
WORKDIR /to-build-app
COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT [ "/bin/sh", "-c", "java -jar app.jar" ]