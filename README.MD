## 📋 Información General

**Nombre del Proyecto:** kafka-cero-a-experto
**Versión:** 0.0.1-SNAPSHOT
**Grupo:** com.davinchicoder
**Descripción:** Proyecto de Spring Kafka
**Java Version:** 21

## 🏗️ Arquitectura del Proyecto

Este es un proyecto de **Spring Boot** enfocado en el aprendizaje y uso de **Apache Kafka**, que utiliza las siguientes
tecnologías:

### Tecnologías Principales

- **Spring Boot 3.5.5**
- **Spring Kafka**
- **Apache Kafka con Apache Avro**
- **Confluent Schema Registry**
- **Java 21**
- **Lombok**
- **MapStruct**

## 📦 Dependencias Principales

### Framework Base

- **Spring Boot Starter Web**: Para crear APIs REST
- **Spring Boot Starter Actuator**: Para monitoreo y métricas
- **Spring Kafka**: Integración de Kafka con Spring

### Serialización y Esquemas

- **Apache Avro (1.12.0)**: Para serialización de datos
- **Confluent Kafka Avro Serializer (7.9.0)**: Serializador Avro para Kafka
- **Confluent Schema Registry Client (7.9.0)**: Cliente para gestión de esquemas

### Utilidades

- **Lombok**: Para reducir código boilerplate
- **MapStruct (1.6.2)**: Para mapeo entre objetos
- **Lombok-MapStruct Binding**: Integración entre Lombok y MapStruct

### Testing

- **Spring Boot Starter Test**: Para pruebas unitarias
- **Spring Kafka Test**: Para pruebas de integración con Kafka

## 🔧 Configuración del Proyecto

### Repositorios Maven

El proyecto está configurado para usar el repositorio de Confluent:

``` xml
<repository>
    <id>confluent</id>
    <url>https://packages.confluent.io/maven/</url>
</repository>
```

### Plugins de Build

1. **Spring Boot Maven Plugin**: Para empaquetar la aplicación
2. **Avro Maven Plugin**: Para generar clases Java a partir de esquemas Avro
    - Directorio de esquemas: `src/main/resources/`
    - Directorio de salida: `src/main/java/`

## 📂 Estructura del Proyecto

``` 
kafka-cero-a-experto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── target/
├── compose.yml
├── pom.xml
├── README.md
└── HELP.md
```

## 🐳 Docker Compose

El proyecto incluye un archivo que probablemente contiene la configuración para levantar: `compose.yml`

- Kafka Broker
- Zookeeper
- Schema Registry (Confluent)

## 🎯 Propósito del Proyecto

Este proyecto está diseñado como una **guía educativa** para aprender Apache Kafka desde cero hasta un nivel experto,
incluyendo:

1. **Configuración básica de Kafka con Spring Boot**
2. **Producción y consumo de mensajes**
3. **Uso de Apache Avro para serialización**
4. **Integración con Schema Registry de Confluent**
5. **Mejores prácticas y patrones avanzados**

## 🚀 Ejecución del Proyecto

### Prerrequisitos

- Java 21
- Maven 3.6+
- Docker (para servicios de Kafka)

### Pasos para ejecutar

1. Levantar servicios con Docker Compose:

``` bash
   docker-compose up -d
```

1. Compilar el proyecto:

``` bash
   ./mvnw clean compile
```

1. Ejecutar la aplicación:

``` bash
   ./mvnw spring-boot:run
```

## 📚 Características del Aprendizaje

Este proyecto permite aprender:

- ✅ Configuración de productores y consumidores Kafka
- ✅ Serialización con Avro y gestión de esquemas
- ✅ Patrones de mensajería
- ✅ Monitoreo y métricas con Actuator
- ✅ Testing de aplicaciones Kafka
- ✅ Integración con infraestructura Confluent

Link al Curso Completo: https://youtu.be/KY7dH3ksf2s?si=CTeA1UXDytIWig2m
Gracias David.
