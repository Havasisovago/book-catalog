FROM openjdk:17-jdk-alpine3.14
COPY "./target/book-catalog-0.0.1-SNAPSHOT.jar" "/app/book-catalog-0.0.1-SNAPSHOT.jar"
EXPOSE 8080
CMD [ "java", "-jar", "/app/book-catalog-0.0.1-SNAPSHOT.jar" ]
