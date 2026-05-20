# Use una imagen ligera de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Defini el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copie el archivo JAR generado por Maven al contenedor

COPY target/TechnoMarket-0.0.1-SNAPSHOT.jar app.jar

# Expongo el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación desde terminal
ENTRYPOINT ["java", "-jar", "app.jar"]