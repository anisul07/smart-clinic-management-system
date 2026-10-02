FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
