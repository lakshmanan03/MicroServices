FROM openjdk:8
ADD target/rpm-gateway.jar rpm-gateway.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "rpm-gateway.jar"]