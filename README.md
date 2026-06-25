### Link al video demostrativo de la aplicación: [Click Aqui](https://youtu.be/2oo3rJM51SQ)

## Acerca del Proyecto

Este repositorio contiene la entrega final del curso de **Talento Tech**: **Java Backend**. El proyecto consiste en el desarrollo de una **API RESTful** completa y escalable, diseñada para gestionar el inventario de artículos de una tienda. 

El objetivo principal de esta aplicación es proporcionar un sistema backend robusto que centralice la lógica de negocio y exponga las operaciones clásicas de un sistema **CRUD** (Create, Read, Update, Delete) bajo los estándares de la arquitectura web, preparándolo para ser consumido por cualquier aplicación cliente (Frontend web o móvil) en el futuro.

### Características Principales
* **Gestión de Inventario:** Permite dar de alta, consultar, modificar y eliminar artículos con sus respectivos detalles (nombre, descripción y precio).
* **Persistencia Real:** Los datos se almacenan de forma segura y permanente en una base de datos relacional, garantizando que no se pierda información al reiniciar el servidor.
* **Arquitectura Limpia:** Código modularizado por responsabilidades (Controladores, Servicios, Repositorios y Modelos) facilitando su lectura y escalabilidad.
* **Documentación Viva:** Incluye una interfaz gráfica amigable (SWAGGER) integrada en el propio proyecto para explorar y testear cada endpoint sin depender de software de terceros.

## Configuración del Entorno de Red y Datos

Para evitar conflictos de puertos en sistemas Windows con instalaciones previas locales (como XAMPP, WAMP o Workbench), el puerto externo de MySQL ha sido remapeado estratégicamente en el archivo de propiedades de Spring de la siguiente manera:

| Parámetro | Valor |
|---|---|
| Puerto Interno del Contenedor Docker | `3306` |
| Puerto de Exposición hacia Windows | `3307` |
| Base de Datos Autocreada | `articulos_db` |
| Estrategia DDL de Hibernate | `update` *(Crea automáticamente las tablas físicas la primera vez que se inicializa la aplicación)* |

---

## Guía de Ejecución y Pruebas Paso a Paso

Sigue estas sencillas instrucciones para levantar todo el ecosistema de la aplicación en pocos segundos de manera local:

### 1. Iniciar la Base de Datos con Docker

Asegúrate de tener la aplicación de escritorio activa y ejecutándose:

1. Abre **Docker Desktop** en tu computadora.
2. Abre una terminal de comandos en la carpeta raíz del proyecto (donde se encuentra el archivo `docker-compose.yml`).
3. Ejecuta el comando para descargar y activar el contenedor en segundo plano:

```bash
docker-compose up -d
```

### 2. Levantar la Aplicación Spring Boot

Puedes inicializar el backend directamente desde tu entorno de desarrollo favorito (como VS Code o IntelliJ) presionando el botón de **Run** en la clase principal `ArticulosApplication.java`, o bien mediante la consola de Maven utilizando el wrapper del proyecto:

```bash
./mvnw spring-boot:run
```

> Espera a que la consola muestre la línea `Started ArticulosApplication in X seconds` confirmando la correcta vinculación en el puerto `8080`.

### 3. Probar y Consultar mediante Swagger UI

Gracias a la integración de OpenAPI, puedes testear toda la API de forma interactiva:

1. Abre tu navegador web de preferencia.
2. Ingresa a la siguiente URL directa:

    [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

3. Visualizarás la interfaz gráfica interactiva dividida por colores según el verbo HTTP.
4. Para realizar pruebas (consultas, altas, bajas, modificaciones), simplemente:
   - Despliega cualquier sección de un endpoint.
   - Haz clic en el botón **"Try it out"** *(Pruébalo)*.
   - Edita el cuerpo JSON de ser necesario.
   - Haz clic en el botón azul **"Execute"** *(Ejecutar)* para ver las respuestas en tiempo real reflejadas directamente en tu base de datos MySQL.

---

*Developed by Cristian Gonzalez as a Final Project for the Talento Tech Java Backend Course.*

### Sitio WEB: [EnterCode](https://entercode.com.ar)