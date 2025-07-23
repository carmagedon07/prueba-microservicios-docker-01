# Etapa 1: Compilar el proyecto
FROM maven:3.6.3-jdk-8 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen liviana para ejecutar el JAR
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
