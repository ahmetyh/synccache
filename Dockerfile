FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sync_cache.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/sync_cache.jar"]