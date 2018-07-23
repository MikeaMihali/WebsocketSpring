FROM openjdk:8
ADD target/kafka-websocket-0.0.1-SNAPSHOT.jar kafka-websocket-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","kafka-websocket-0.0.1-SNAPSHOT.jar"]