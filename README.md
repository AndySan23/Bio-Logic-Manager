# 🌿 Bio-Logic Manager

Un sistema integral de gestión botánica y análisis de datos desarrollado en Java. 
Diseñado bajo estándares de arquitectura limpia, este proyecto permite administrar inventarios, controlar roles de usuario y calcular proyecciones de crecimiento mediante 
un motor matemático integrado.

## 🚀 Características Principales

* **Gestión de Inventario Botánico:** Operaciones CRUD completas para el registro, seguimiento y archivo de especies vegetales.
* **Motor Matemático (Cálculo de Crecimiento):** Módulo automatizado que procesa tasas de crecimiento diario basándose en la fórmula de la pendiente ($m = \frac{y_2 - y_1}{x_2 - x_1}$), validando discrepancias temporales y evitando errores de división por cero.
* **Control de Acceso Basado en Roles (RBAC):** Sistema de seguridad visual que restringe el acceso a módulos administrativos según el nivel de permisos del usuario conectado.

## 🏗️ Arquitectura y Buenas Prácticas

Este proyecto se aleja del código "espagueti" y aplica principios de ingeniería de software de grado empresarial:

* **Patrón MVC (Modelo-Vista-Controlador):** Separación estricta entre la interfaz gráfica (Java Swing) y la lógica de negocio.
* **Data Access Object (DAO):** Implementación de clases especializadas (`PlantaDAO`, `UsuarioDAO`) para centralizar y aislar las consultas SQL, protegiendo las ventanas de la manipulación directa de la base de datos y previniendo inyecciones SQL.
* **Clean Code & DRY:** Refactorización constante para evitar la repetición de código y asegurar métodos de una sola responsabilidad.

## 🧪 Control de Calidad (Testing)

El núcleo lógico del sistema está respaldado por pruebas unitarias automatizadas:
* **Framework:** JUnit 4 / Hamcrest.
* **Cobertura:** Pruebas rigurosas sobre el `MotorMatematico` para garantizar la precisión de los cálculos flotantes y la correcta emisión de excepciones (`ArithmeticException`, `IllegalArgumentException`) ante entradas inválidas o escenarios imposibles.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 8+)
* **Interfaz Gráfica:** Java Swing
* **Base de Datos:** MySQL (Controladores JDBC)
* **Pruebas Unitarias:** JUnit 4
* **Control de Versiones:** Git / GitHub

## ⚙️ Instalación y Ejecución

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone [https://github.com/AndySan23/Bio-Logic-Manager.git](https://github.com/AndySan23/Bio-Logic-Manager.git)
