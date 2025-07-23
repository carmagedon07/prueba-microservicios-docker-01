# 📦 BackEndPruebaGit

Este proyecto consiste en una arquitectura de microservicios para la gestión de productos e inventario. Desarrollado en Java con Spring Boot, permite registrar productos y realizar compras que actualizan el inventario automáticamente.

## 📂 Microservicios

- `Producto`: gestiona el catálogo de productos.
- `Inventario`: administra el stock y realiza operaciones de compra.

## 🔧 Tecnologías utilizadas

- Java 11 / 17
- Spring Boot
- Spring Data JPA
- Spring Web
- OpenFeign
- H2 Database
- Docker + Docker Compose
- Maven

---

## ▶️ Ejecución

### Opción 1: Docker Compose


docker-compose up --build
Servicios disponibles:

Producto Service: http://localhost:8081

Inventario Service: http://localhost:8082

H2 Console (Inventario): http://localhost:8082/h2-console

🧪 Endpoints
📦 Producto Service (localhost:8081)
Método	Endpoint	Descripción
GET	/api/productos/{id}	Consulta los datos de un producto

🏷️ Inventario Service (localhost:8082)
Método	Endpoint	Descripción
GET	/inventario/{id}	Consulta el inventario de un producto
POST	/compra	Realiza una compra (descuenta stock)

📄 Documentación de API
Swagger UI
La documentación de los endpoints estará disponible si se incluye la dependencia de Swagger/OpenAPI. Por ejemplo:


<!-- En el pom.xml -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>
Luego accede a:

http://localhost:8081/swagger-ui.html

http://localhost:8082/swagger-ui.html

🧭 Diagrama de Arquitectura

                ┌────────────────────┐
                │   Cliente (Postman)│
                └────────┬───────────┘
                         │
               POST /compra (ID, cantidad)
                         │
              ┌──────────▼────────────┐
              │ Inventario Service    │
              │ Verifica y descuenta  │
              └──────────┬────────────┘
                         │
         GET /productos/{id} con Feign Client
                         │
              ┌──────────▼────────────┐
              │  Producto Service     │
              │  Retorna datos        │
              └───────────────────────┘
📬 Colección Postman (opcional)
Puedes crear una colección de Postman con estos endpoints y añadirla a este repositorio como postman_collection.json. Ejemplo de llamada POST /compra:


POST http://localhost:8082/compra
Content-Type: application/json

{
  "productoId": 1,
  "cantidad": 3
}
✅ Estado
 Funcionalidad de productos

 Gestión de inventario

 Documentación Swagger incluida

 Pruebas unitarias completas

 Seguridad/autenticación

📌 Autor
Pedro Nel
Especialista en Ingeniería de Software