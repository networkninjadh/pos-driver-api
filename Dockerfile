FROM adoptopenjdk/openjdk11:alpine-jre
CMD mvn clean package
COPY target/pos-driver-api-0.0.1-SNAPSHOT.jar pos-driver-api.jar
ENTRYPOINT ["java", "-jar", "pos-driver-api.jar"]
EXPOSE 8088