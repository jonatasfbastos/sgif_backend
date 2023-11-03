FROM amazoncorretto:17-al2-generic-jdk
WORKDIR /app
COPY  ./out/artifacts/sgif_jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./sgif.jar"]