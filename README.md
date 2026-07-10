# 📋 ms-evaluaciones — Evaluaciones y Notas

Microservicio encargado de las **evaluaciones** (pruebas, controles) y las **notas** de los
estudiantes.

> Parte del proyecto GED. Para ejecutar **todo el sistema**, ver el [README raíz](../README.md).

---

## ⚙️ Datos técnicos

| | |
|---|---|
| **Puerto** | `8085` |
| **Base de datos** | `ms_evaluaciones_db` (MySQL, se crea automáticamente) |
| **Stack** | Spring Boot 4 · Java 21 · Spring Data JPA · springdoc (Swagger) |

> Nota: este servicio expone sus rutas en **singular y sin prefijo `/api`** (`/evaluacion`, `/nota`).
> El proxy del frontend traduce `/api/evaluaciones → /evaluacion` y `/api/notas → /nota`.

---

## 📡 Endpoints principales

### Evaluaciones — `/evaluacion`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/evaluacion` | Lista todas las evaluaciones |
| GET | `/evaluacion/{id}` | Evaluación por ID |
| POST | `/evaluacion` | Crea (o actualiza si incluye `id_evaluacion`) |
| DELETE | `/evaluacion/{id}` | Elimina una evaluación |

### Notas — `/nota`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/nota` | Lista todas las notas |
| GET | `/nota/{id}` | Nota por ID |
| POST | `/nota` | Crea (o actualiza si incluye `id_nota`) |
| DELETE | `/nota/{id}` | Elimina una nota |

Cada nota referencia una evaluación (`idEvaluacion`) y un estudiante (`idEstudiante`).

---

## ▶️ Ejecución

```bash
mvnw.cmd spring-boot:run     # Windows
./mvnw spring-boot:run       # Linux / macOS
```

- Documentación Swagger: **http://localhost:8085/swagger-ui.html**

> Este servicio también aloja un **Swagger agregado** que enlaza la documentación de los 9
> microservicios. Si al abrirlo aparece *"Failed to load API definition"*, es porque intenta leer
> la documentación de otros servicios (CORS entre puertos); **no afecta el funcionamiento** de la
> aplicación, que en desarrollo pasa por el proxy de Vite.
