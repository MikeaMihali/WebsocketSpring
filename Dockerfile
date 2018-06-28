FROM openjdk:8
ADD target/asset-management-0.0.1-SNAPSHOT.jar asset-management-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","asset-management-0.0.1-SNAPSHOT.jar"]