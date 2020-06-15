FROM openjdk:11.0.7
EXPOSE 8086
ARG JAR_FILE=target/rpm-calendar.jar
COPY ${JAR_FILE} rpm-calendar.jar
ENTRYPOINT ["java","-Duser.timezone=UTC","-jar","rpm-calendar.jar"]
