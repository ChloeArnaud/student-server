FROM openjdk:17-oracle
MAINTAINER baeldung.com
COPY build/libs/server.jar server.jar
RUN chmod +x server.jar
ENTRYPOINT ["java", "-jar", "server.jar"]