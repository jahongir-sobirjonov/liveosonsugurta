#FROM amazoncorretto:19-alpine-jdk
#
#COPY target/LiveOsonSugurta-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java" , "-jar" , "/app.jar"]

FROM openjdk:19.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/RealOsonSugurta-0.0.1-SNAPSHOT.jar realosonsugurta.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "realosonsugurta.jar"]
