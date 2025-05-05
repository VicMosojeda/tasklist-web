[[Proyect](tasklist.png)]()

# 📝 TaskList Web App

Una aplicación web para gestionar tareas de forma sencilla y eficiente. El frontend está construido con HTML, CSS y JavaScript puro, mientras que el backend está desarrollado con Java y Spring Boot, proporcionando una API RESTful para operaciones CRUD (crear, leer, actualizar, eliminar).

## 🚀 Tecnologías utilizadas

### Frontend
- HTML5
- CSS3
- JavaScript (Vanilla)

### Backend
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Base de datos: H2 / PostgreSQL / MySQL (configurable)

## ⚙️ Funcionalidades

- Agregar nuevas tareas
- Editar tareas existentes
- Marcar tareas como completadas
- Eliminar tareas
- Visualizar lista de tareas
- Comunicación con backend mediante fetch y JSON

## 📂 Estructura del proyecto

tasklist/
├── backend/
│ ├── src/
│ │ └── main/java/com/example/tasklist/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ └── service/
│ └── application.properties
├── frontend/
│ ├── index.html
│ ├── styles.css
│ └── app.js
└── README.md


## 🧪 Cómo correr el proyecto

### Requisitos

- Java 17 o superior
- Maven o Gradle
- Navegador web moderno

### Backend

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/tasklist.git
   cd tasklist/backend

2. Ejecuta la aplicación:
   ```bash
  ./mvnw spring-boot:run

3. La API estará disponible en http://localhost:8080/api/tasks:

### Frontend

1. Ve a la carpeta del frontend:
  cd ../frontend

2. Abre index.html en tu navegador o usa un servidor local como Live Server:

### 📬 Endpoints del Backend
- GET /api/tasks – Obtener todas las tareas

- POST /api/tasks – Crear una nueva tarea

- PUT /api/tasks/{id} – Actualizar una tarea

- DELETE /api/tasks/{id} – Eliminar una tarea