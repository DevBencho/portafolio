# Usamos una imagen ligera de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Definimos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR generado por Maven al contenedor
# (Asegúrate de ejecutar 'mvn clean package' antes de levantar Docker)
COPY target/TechnoMarket-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]