# API de Conversión de Moneda (currency-converter-api)

Este proyecto es una API de conversión de moneda desarrollada con **Java** y **Spring Boot**. Utiliza **Lombok** para reducir el boilerplate de código y **H2** como base de datos en memoria para almacenar las tasas de cambio. El objetivo de la API es recibir un monto en una moneda y devolver su equivalente en otra moneda, aplicando el tipo de cambio almacenado en la base de datos.

## Características

- Convierte un monto de una moneda origen a una moneda destino usando el tipo de cambio almacenado.
- Almacena y gestiona el tipo de cambio en una base de datos en memoria (H2).
- Permite actualizar el tipo de cambio mediante un endpoint POST.
- Utiliza **Lombok** para reducir el código repetitivo (getters, setters, etc.).
- Desarrollado con **Spring Boot** para fácil despliegue y manejo de dependencias.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- H2 (Base de datos en memoria)
- Lombok
- JPA (para la persistencia de datos)
- Postman (para probar la API)

## Requisitos Previos

- JDK 17 o superior
- Maven 3.x
- Postman o cualquier otra herramienta para probar APIs
- Git

## Endpoints

### 1. Conversión de Moneda

**Descripción**: Convierte un monto de una moneda origen a una moneda destino.

- **Método**: `GET`
- **URL**: `/api/convertir`
- **Parámetros**:
  - `monto` (double): El monto a convertir.
  - `monedaOrigen` (String): La moneda de origen (ej. `USD`).
  - `monedaDestino` (String): La moneda de destino (ej. `EUR`).

- **Ejemplo de URL**: `http://localhost:8080/api/convertir?monto=100&monedaOrigen=USD&monedaDestino=SOL`
- **Respuesta**:
  ```json
  {
    "monto": 100,
    "montoConvertido": 92,
    "monedaOrigen": "USD",
    "monedaDestino": "EUR",
    "tasaCambio": 0.92
  }

### 2. Actualizar tasa de cambio

**Descripción**: Actualiza o agrega una nueva tasa de cambio.

- **Método**: `POST`
- **URL**: `/api/tasa`
- **Request Body**:
  - `id` (Long): Identificador.
  - `monedaOrigen` (String): La moneda de origen (ej. `USD`).
  - `monedaDestino` (String): La moneda de destino (ej. `EUR`).
  - `tasa` (double): Tipo de conversión entre monedaOrigen y monedaDestino.
- **Ejemplo de URL**: `http://localhost:8080/api/tasa`
- **Respuesta**:
    - Status: 200 OK

# API de Conversión de Moneda (currency-converter-api)
**Nota**: cada vez que se realiza una petición de "Actualizar tasa de cambio", se podra ver reflejado en la base de datos H2 de la siguiente manera. Adicionalmente, cada vez se requiera actualizar un registro de la base de datos, en el request body de la petición se debe contemplar el "id" del registro donde se realizar algun cambio en los siguientes campos: `monedaOrigen`,`monedaDestino` y `tasa` y finalmmente realizar la petición, de lo contrario se comenta el "id" para agregar una tasa de cambio.
[![database-h2.png](https://i.postimg.cc/q7ZQwGxB/database-h2.png)](https://postimg.cc/06Dp2D4h)




