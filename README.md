# 📋 ms-evaluaciones

Microservicio REST encargado de la gestión de **Evaluaciones** y **Notas** del sistema escolar del **Colegio Bernardo O'Higgins de Coquimbo**. Forma parte de la arquitectura de microservicios `Digital-Student-Management`.

---

## 🧰 Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 21 |
| Spring Boot | 4.x |
| Spring Data JPA | — |
| MySQL | 8.x |
| Lombok | — |
| Springdoc OpenAPI (Swagger) | — |
| Maven Wrapper | — |

---

## 📁 Estructura del Proyecto

```
ms-evaluaciones/
├── src/
│   └── main/
│       ├── java/com/ms_sistemaEscolar/ms_evaluaciones/
│       │   ├── MsEvaluacionesApplication.java
│       │   ├── controller/
│       │   │   ├── EvaluacionController.java
│       │   │   └── NotaController.java
│       │   ├── models/
│       │   │   ├── dto/
│       │   │   │   ├── EvaluacionDTO.java
│       │   │   │   └── NotaDTO.java
│       │   │   └── entity/
│       │   │       ├── Evaluacion.java
│       │   │       └── Nota.java
│       │   ├── repositories/
│       │   │   ├── EvaluacionRepository.java
│       │   │   └── NotaRepository.java
│       │   └── services/
│       │       ├── EvaluacionService.java
│       │       └── NotaService.java
│       └── resources/
│           └── application.properties
├── peticiones.rest
├── pom.xml
└── README.md
```

---

## 🗃️ Modelo de Datos

### Tabla `evaluacion`
| Columna | Tipo | Descripción |
|---|---|---|
| `id_evaluacion` | INT (PK, AI) | Identificador único |
| `titulo_ev` | VARCHAR | Nombre de la evaluación |
| `fecha_aplicacion` | DATE | Fecha de realización |
| `porcentaje_pond` | DOUBLE | Peso porcentual en la nota final |
| `id_asignatura` | INT | Referencia externa a `ms-asignaturas` |

### Tabla `notas`
| Columna | Tipo | Descripción |
|---|---|---|
| `id_nota` | INT (PK, AI) | Identificador único |
| `valor_calif` | DOUBLE | Calificación obtenida |
| `formato_nota` | VARCHAR | Tipo de evaluación (ej: Examen, Prueba) |
| `puntaje` | INT | Puntaje bruto |
| `observacion` | VARCHAR | Comentario del docente |
| `id_evaluacion` | INT (FK) | Referencia a `evaluacion` |
| `id_estudiante` | INT | Referencia externa a `ms-usuarios` |

---

## ⚙️ Configuración Rápida

### 1. Requisitos previos
- Java 21 instalado
- MySQL 8 corriendo en `localhost:3306`
- Usuario `root` con acceso a la base de datos

### 2. Configurar `application.properties`
```properties
spring.application.name=ms-evaluaciones
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/ms_evaluaciones_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

> La base de datos `ms_evaluaciones_db` se crea automáticamente si no existe.

### 3. Levantar el servidor
```bash
./mvnw spring-boot:run        # Linux / macOS
.\mvnw.cmd spring-boot:run    # Windows
```

El servidor estará disponible en: **`http://localhost:8081`**

---

## 📡 Endpoints REST

### Evaluaciones — `/evaluacion`
| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/evaluacion` | Listar todas las evaluaciones |
| `GET` | `/evaluacion/{id}` | Buscar evaluación por ID |
| `POST` | `/evaluacion` | Crear nueva evaluación |
| `DELETE` | `/evaluacion/{id}` | Eliminar evaluación |

### Notas — `/nota`
| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/nota` | Listar todas las notas |
| `GET` | `/nota/{id}` | Buscar nota por ID |
| `POST` | `/nota` | Crear nueva nota |
| `DELETE` | `/nota/{id}` | Eliminar nota |

---

## 🧪 Cómo Probar

### Opción A — Swagger UI
Accede a la documentación interactiva generada automáticamente:

**`http://localhost:8081/swagger-ui.html`**

Desde ahí puedes ejecutar cualquier endpoint directamente desde el navegador.

### Opción B — REST Client (VS Code)
Abre el archivo **`peticiones.rest`** en la raíz del proyecto con la extensión [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) de VS Code y haz clic en `Send Request` sobre cada bloque.

---

## 🔗 Dependencias con otros microservicios

| Campo | Microservicio relacionado |
|---|---|
| `idAsignatura` (en Evaluacion) | `ms-asignaturas` (puerto 8080) |
| `idEstudiante` (en Nota) | `ms-usuarios` |

> Estos campos son IDs externos. Este microservicio los almacena como referencia pero **no valida su existencia** vía HTTP (sin Feign/WebClient en esta versión).

---

## 👨‍💻 Autor

Proyecto académico — Colegio Bernardo O'Higgins · Sistema Escolar Digital
