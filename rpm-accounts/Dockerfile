FROM openjdk:11.0.7
EXPOSE 8084
ARG JAR_FILE=target/Accounts-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Accounts.jar
ENTRYPOINT ["java","-Duser.timezone=UTC","-jar","Accounts.jar"]