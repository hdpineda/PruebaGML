# PruebaGML
ejercicio practico para validación de conocimientos en Automatizaciones frontend y backend

Framework de Automatización: Serenity BDD + Screenplay
Este proyecto contiene una suite de pruebas automatizadas para aplicaciones Web (UI) y servicios REST (API), utilizando un enfoque de Desarrollo Guiado por Comportamiento (BDD).

**Tecnologías Utilizadas**
- Lenguaje: Java 17+
- Framework de Automatización: Serenity BDD
- Patrón de Diseño: Screenplay Pattern
- Gestor de Pruebas: Cucumber & JUnit
- Librería de API: RestAssured
- Gestor de Dependencias: Maven
- Reportes: Serenity Reports (HTML)

**Estructura del Proyecto**
El proyecto sigue el estándar de paquetes de Screenplay para separar las responsabilidades:

Plaintext

src
├── main/java/com/example
│   ├── models            # Clases POJO (ej: Pet)
│   ├── tasks             # Acciones de alto nivel (ej: Authenticate, AddPet).
│   ├── pages             # Localizadores (Targets) de las páginas web.
│   ├── questions         # Verificaciones y aserciones de los tests.
│   ├── stepdefinitions   # Conexión entre Gherkin y el código Java.
│   └── utils             # Clases de soporte y lectura de entornos (no utilizados en este ejercicio)
├── test/java/com/example
│   └── runners           # Lanzadores de las suites de Cucumber.
└── test/resources
    ├── features          # Escenarios de prueba en lenguaje Gherkin.
    └── serenity.conf     # Configuración.

**Casos de Prueba Implementados**
Pruebas Web (The Internet Herokuapp)
- Autenticación: Login exitoso. 
- Checkboxes: Interacción con casillas de verificación.
- Dropdown: Selección de opciones en listas desplegables.

Pruebas API CRUD (Petstore Swagger)
- POST: Creación de nuevas mascotas.
- GET: Consulta de mascotas por ID.
- PUT: Actualización de información de mascotas existentes.
- DELETE: Eliminación de registros de mascotas.


**Ejecución de la prueba**
Bash
mvn clean verify 

Para ejecutar solo una suite específica usando Tags:
Bash
mvn clean verify "-Dcucumber.filter.tags=@SuiteCompleta"
mvn clean verify "-Dcucumber.filter.tags=@API"
