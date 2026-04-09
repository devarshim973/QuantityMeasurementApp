<div align="center">
 
<h1 align="center">🚀 Quantity Measurement App</h1>
<h3 align="center">Microservice Architecture | Spring Boot | Spring Cloud | JWT</h3>

<br/>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.2.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Cloud-2023.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/JWT-Security-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Services-4_Microservices-blueviolet?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Eureka-Service_Discovery-FF6B35?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/OAuth2-GitHub_Login-181717?style=for-the-badge&logo=github"/>
  <img src="https://img.shields.io/badge/Swagger-API_Docs-85EA2D?style=for-the-badge&logo=swagger&logoColor=black"/>
</p>

<br/>

> **A fully-featured Spring Boot Microservice Architecture** for performing quantity measurement operations — Add, Subtract, Multiply, Divide, Compare & Convert — across **Length, Weight, Volume, and Temperature** units. Built with enterprise-grade security, service discovery, and full operation history tracking.

<br/>

</div>

---

## 📌 Table of Contents

| # | Section |
|---|---------|
| 1 | [📖 Project Overview](#-project-overview) |
| 2 | [🏗️ Architecture Diagram](#️-microservice-architecture) |
| 3 | [🛠️ Tech Stack](#️-tech-stack) |
| 4 | [📁 Project Structure](#-project-structure) |
| 5 | [📋 Services Description](#-services-description) |
| 6 | [✅ Prerequisites](#-prerequisites) |
| 7 | [🗄️ Database Setup](#️-database-setup) |
| 8 | [🚀 How to Run](#-how-to-run) |
| 9 | [📡 API Endpoints](#-api-endpoints) |
| 10 | [📝 Request & Response Examples](#-request--response-examples) |
| 11 | [🔒 Security Flow](#-security-flow) |
| 12 | [🔗 Service Communication](#-service-communication) |
| 13 | [📊 Eureka Dashboard](#-eureka-dashboard) |
| 14 | [📚 Swagger UI](#-swagger-ui) |
| 15 | [⚙️ Environment Configuration](#️-environment-configuration) |
| 16 | [❌ Common Errors & Fixes](#-common-errors--fixes) |
| 17 | [✅ Microservice Rules Followed](#️-microservice-rules-followed) |

---

## 📖 Project Overview

<div align="center">

```
╔══════════════════════════════════════════════════════════════════════╗
║  Originally a Monolithic Spring Boot App → Converted to Microservices ║
╚══════════════════════════════════════════════════════════════════════╝
```

</div>

**Quantity Measurement App** is a production-ready **Spring Boot Microservice** project that supports:

| Operation | Description |
|-----------|-------------|
| ➕ **Add** | Add two quantities (auto unit conversion) |
| ➖ **Subtract** | Subtract two quantities |
| ✖️ **Multiply** | Multiply a quantity by a factor |
| ➗ **Divide** | Divide a quantity by a factor |
| ⚖️ **Compare** | Compare if two quantities are equal |
| 🔄 **Convert** | Convert a value to another unit |

### 🧮 Supported Measurement Types

```
📏 LengthUnit      →   FEET  |  INCHES  |  YARDS  |  CENTIMETERS
⚖️  WeightUnit     →   MILLIGRAM  |  GRAM  |  KILOGRAM  |  POUND  |  TONNE
🧪 VolumeUnit      →   LITRE  |  MILLILITRE  |  GALLON
🌡️  TemperatureUnit →   CELSIUS  |  FAHRENHEIT  |  KELVIN
```

### 🔑 Core Capabilities

- 🔐 **JWT-based Authentication** — secure, stateless sessions
- 🐙 **GitHub OAuth2 Login** — social login support
- 🗃️ **Operation History** — every operation is persisted to MySQL
- ⚡ **Reactive API Gateway** — non-blocking, WebFlux-based routing
- 🔍 **Eureka Service Discovery** — dynamic service registration
- 📚 **Swagger Documentation** — interactive API explorer on each service

---

## 🏗️ Microservice Architecture

<div align="center">

```
                    ┌──────────────────────────────┐
                    │      Frontend (React)         │
                    │       localhost:3000          │
                    └──────────────┬───────────────┘
                                   │  HTTP Requests
                                   ▼
                    ╔══════════════════════════════╗
                    ║         API GATEWAY          ║  ◄── Single Entry Point
                    ║        localhost:8080        ║
                    ║   • JWT Validation           ║
                    ║   • Request Routing          ║
                    ║   • CORS Handling            ║
                    ║   • Load Balancing (lb://)   ║
                    ╚══════════════┬═══════════════╝
                                   │
              ┌────────────────────┼────────────────────┐
              │                    │                    │
              ▼                    ▼                    ▼
   ╔══════════════════╗  ╔══════════════════╗  ╔══════════════════╗
   ║  SECURITY        ║  ║  QUANTITY        ║  ║  EUREKA SERVER   ║
   ║  SERVICE         ║  ║  MEASUREMENT     ║  ║  localhost:8761  ║
   ║  localhost:8081  ║  ║  APP             ║  ║                  ║
   ║                  ║  ║  localhost:8082  ║  ║  • Service       ║
   ║  • Register      ║  ║                  ║  ║    Registry      ║
   ║  • Login         ║  ║  • Add/Subtract  ║  ║  • Heartbeats    ║
   ║  • JWT Issue     ║  ║  • Multiply/Div  ║  ║  • Health Check  ║
   ║  • OAuth2        ║  ║  • Compare       ║  ║  • Dashboard     ║
   ║  • BCrypt        ║  ║  • Convert       ║  ║                  ║
   ║  • User CRUD     ║  ║  • History       ║  ╚══════════════════╝
   ╚════════╤═════════╝  ╚════════╤═════════╝
            │                    │
            ▼                    ▼
   ┌─────────────────┐  ┌─────────────────┐
   │   security_db   │  │   quantity_db   │
   │    (MySQL)      │  │    (MySQL)      │
   |  [User Details] |   |   [Operations]  |
   └─────────────────┘  └─────────────────┘
```

</div>

> 💡 **Key Design:** The API Gateway is the **only public-facing component**. All other services are internal and communicate via Eureka discovery.

---

## 🛠️ Tech Stack

<div align="center">

| Technology | Version | Purpose | Badge |
|------------|---------|---------|-------|
| **Java** | 17 | Programming Language | ![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk) |
| **Spring Boot** | 3.2.0 | Application Framework | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-6DB33F?style=flat-square&logo=spring-boot) |
| **Spring Cloud Gateway** | 2023.0.0 | API Gateway + Routing | ![Gateway](https://img.shields.io/badge/Spring_Cloud_Gateway-2023.0.0-6DB33F?style=flat-square) |
| **Spring Cloud Eureka** | 2023.0.0 | Service Registry & Discovery | ![Eureka](https://img.shields.io/badge/Eureka-2023.0.0-FF6B35?style=flat-square) |
| **Spring Security** | 6.x | Auth & Authorization | ![Security](https://img.shields.io/badge/Spring_Security-6.x-6DB33F?style=flat-square) |
| **Spring Data JPA** | 3.2.0 | ORM & Database Access | ![JPA](https://img.shields.io/badge/Spring_Data_JPA-3.2.0-6DB33F?style=flat-square) |
| **Spring OAuth2 Client** | 3.2.0 | GitHub Social Login | ![OAuth2](https://img.shields.io/badge/OAuth2-GitHub-181717?style=flat-square&logo=github) |
| **OpenFeign** | 2023.0.0 | Declarative REST Client | ![Feign](https://img.shields.io/badge/OpenFeign-2023.0.0-blue?style=flat-square) |
| **JWT (jjwt)** | 0.12.3 | Token Generation & Validation | ![JWT](https://img.shields.io/badge/JWT-0.12.3-000000?style=flat-square&logo=json-web-tokens) |
| **MySQL** | 8.0 | Production Database | ![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat-square&logo=mysql) |
| **Lombok** | Latest | Boilerplate Reduction | ![Lombok](https://img.shields.io/badge/Lombok-Latest-red?style=flat-square) |
| **Swagger / OpenAPI** | 2.1.0 | API Documentation | ![Swagger](https://img.shields.io/badge/Swagger-2.1.0-85EA2D?style=flat-square&logo=swagger&logoColor=black) |
| **Spring Boot Actuator** | 3.2.0 | Health Checks & Monitoring | ![Actuator](https://img.shields.io/badge/Actuator-3.2.0-6DB33F?style=flat-square) |
| **Maven** | 3.8+ | Build Tool | ![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=flat-square&logo=apache-maven) |

</div>

---

## 📁 Project Structure

```
📦 microservice-architecture/
│
├── 📂 eureka-server/                         🔵 Service Registry (Port: 8761)
│   ├── 📂 src/main/java/com/eureka/
│   │   └── 📄 EurekaServerApplication.java
│   ├── 📂 src/main/resources/
│   │   └── 📄 application.yml
│   └── 📄 pom.xml
│
├── 📂 security-service/                      🟢 Auth Service (Port: 8081)
│   ├── 📂 src/main/java/com/security/
│   │   ├── 📄 SecurityServiceApplication.java
│   │   ├── 📂 controller/
│   │   │   └── 📄 AuthController.java
│   │   ├── 📂 service/
│   │   │   ├── 📄 JwtService.java
│   │   │   └── 📄 CustomUserDetailsService.java
│   │   ├── 📂 repository/
│   │   │   └── 📄 UserRepository.java
│   │   ├── 📂 model/
│   │   │   └── 📄 User.java
│   │   ├── 📂 dto/
│   │   │   ├── 📄 LoginRequest.java
│   │   │   ├── 📄 RegisterRequest.java
│   │   │   └── 📄 AuthResponse.java
│   │   ├── 📂 security/
│   │   │   ├── 📄 JwtAuthFilter.java
│   │   │   └── 📄 OAuth2SuccessHandler.java
│   │   ├── 📂 config/
│   │   │   ├── 📄 SecurityConfig.java
│   │   │   └── 📄 SwaggerConfig.java
│   │   └── 📂 exception/
│   │       ├── 📄 GlobalExceptionHandler.java
│   │       ├── 📄 DuplicateEmailException.java
│   │       ├── 📄 UserNotFoundException.java
│   │       └── 📄 ErrorResponse.java
│   ├── 📂 src/main/resources/
│   │   └── 📄 application.yml
│   └── 📄 pom.xml
│
├── 📂 quantity-measurement-app/              🟡 Core Business Service (Port: 8082)
│   ├── 📂 src/main/java/com/quantity/
│   │   ├── 📄 QuantityMeasurementApplication.java
│   │   ├── 📂 controller/
│   │   │   └── 📄 QuantityMeasurementController.java
│   │   ├── 📂 service/
│   │   │   ├── 📄 IQuantityMeasurementService.java
│   │   │   └── 📄 QuantityMeasurementServiceImpl.java
│   │   ├── 📂 repository/
│   │   │   └── 📄 QuantityMeasurementRepository.java
│   │   ├── 📂 model/
│   │   │   └── 📄 QuantityMeasurementEntity.java
│   │   ├── 📂 dto/
│   │   │   ├── 📄 QuantityDTO.java
│   │   │   ├── 📄 QuantityInputDTO.java
│   │   │   ├── 📄 QuantityMeasurementDTO.java
│   │   │   └── 📄 OperationType.java
│   │   ├── 📂 core/
│   │   │   ├── 📄 IMeasurable.java
│   │   │   ├── 📄 SupportsArithmetic.java
│   │   │   ├── 📄 Quantity.java           ◄── Generic Quantity<U> Engine
│   │   │   ├── 📄 LengthUnit.java
│   │   │   ├── 📄 WeightUnit.java
│   │   │   ├── 📄 VolumeUnit.java
│   │   │   └── 📄 TemperatureUnit.java
│   │   ├── 📂 config/
│   │   │   ├── 📄 SecurityConfig.java
│   │   │   └── 📄 SwaggerConfig.java
│   │   └── 📂 exception/
│   │       ├── 📄 GlobalExceptionHandler.java
│   │       ├── 📄 QuantityMeasurementException.java
│   │       ├── 📄 DatabaseException.java
│   │       └── 📄 ErrorResponse.java
│   ├── 📂 src/main/resources/
│   │   └── 📄 application.yml
│   └── 📄 pom.xml
│
└── 📂 api-gateway/                           🔴 API Gateway (Port: 8080)
    ├── 📂 src/main/java/com/gateway/
    │   ├── 📄 ApiGatewayApplication.java
    │   ├── 📂 filter/
    │   │   └── 📄 JwtAuthenticationFilter.java
    │   └── 📂 config/
    │       └── 📄 GatewayConfig.java
    ├── 📂 src/main/resources/
    │   └── 📄 application.yml
    └── 📄 pom.xml

A Maven-based Java application that demonstrates object-oriented design principles
by implementing length equality comparison across multiple development stages (UC1, UC2, UC3).

The project evolves incrementally using Git branches to demonstrate refactoring,
DRY principle, abstraction, polymorphism, and clean architecture.

---

### 📌 Project Overview

A generic, extensible, and SOLID-compliant Java application for performing measurement operations across multiple categories:

- Length
- Weight
- Volume
- Temperature (with selective arithmetic support)

The system evolves incrementally from **UC1 to UC14**, demonstrating clean architecture, generics, functional interfaces, lambda expressions, and interface refactoring principles.

Design a scalable and type-safe measurement system that:

- Supports unit conversion
- Maintains cross-category isolation
- Centralizes arithmetic logic
- Enforces operation validity constraints
- Demonstrates real-world object-oriented design

---

### Project Structure🏗 

#### 🏗 Project Structure (Maven)

```
quantity-measurement-app/
│
├── pom.xml
├── .gitignore
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/quantity/
│   │           ├── app/
│   │           └── domain/
│   │               └── length/
│   │
│   └── test/
│       └── java/
│           └── com/quantity/
│               └── domain/
│                   └── length/
│
└── target/

# 🚀 Quantity Measurement App (UC18 - JWT + OAuth2)

## 📌 Overview

The **Quantity Measurement App** is a Spring Boot-based REST API that supports various measurement operations like **Length, Weight, Volume, and Temperature**.

This project is enhanced with **advanced security features** including:

* 🔐 JWT Authentication
* 🌐 GitHub OAuth2 Login
* 🗄️ JPA & Database Integration
* 📊 Swagger API Documentation
* ⚡ Robust Exception Handling & Validation

---

## 🎯 Key Features

### 🧮 Core Functionalities

* Compare quantities
* Convert units
* Arithmetic operations (Add, Subtract, Divide)
* Measurement history tracking
* Error tracking & reporting

---

### 🔐 Security Features (UC18)

* JWT-based Authentication (Stateless)
* GitHub OAuth2 Login
* Secure REST APIs
* Custom Authentication Filter
* Unauthorized access handling (401 response)

---

### 🗄️ Database & Persistence

* JPA (Hibernate ORM)
* H2 (Development)
* MySQL (Production ready)
* Indexed queries for performance

---

### 📊 API & Monitoring

* Swagger UI (API Testing)
* Spring Boot Actuator
* Logging & Debugging support

---

## 🏗️ Project Structure

```
com.app
│
├── config              # Security & Swagger Config
├── controller          # REST Controllers
├── service             # Business Logic
├── repository          # JPA Repositories
├── model               # Entities & Domain Models
├── dto                 # Request/Response DTOs
├── security            # JWT & OAuth2 Components
├── exception           # Global Exception Handling
└── core                # Measurement Logic
>>>>>>> origin/dev
```

---

## 📋 Services Description

### 🔵 1. Eureka Server — `Port: 8761`

> The **Service Registry** — acts as a phonebook for all microservices.

Every service registers itself here on startup. The API Gateway queries Eureka to discover the location of other services **dynamically** — no hardcoded URLs.

| Feature | Details |
|---------|---------|
| 🔍 Service Discovery | Registers all services on startup |
| 💓 Heartbeat Monitoring | Health checks via periodic heartbeats |
| 📊 Dashboard | Visual UI to view all registered services |
| 🛡️ Self-Preservation | Disabled in dev mode for clean restarts |

---

### 🟢 2. Security Service — `Port: 8081`

> Handles all **authentication and user management** operations.

Responsible for user registration, login, JWT token generation, and GitHub OAuth2 login.

| Feature | Details |
|---------|---------|
| 📝 Registration | User registration with field validation |
| 🔑 JWT Generation | Stateless tokens valid for 24 hours |
| 🐙 GitHub OAuth2 | Social login via GitHub |
| 🔐 BCrypt Encryption | Password hashing with BCrypt |
| 🚫 Session Management | Stateless — no server-side sessions |

---

### 🟡 3. Quantity Measurement App — `Port: 8082`

> The **core business logic** service — handles all quantity operations.

Powered by a **Generic `Quantity<U>` engine** that performs automatic base unit conversions before any arithmetic operation.

| Feature | Details |
|---------|---------|
| ➕➖✖️➗ Operations | Add, Subtract, Multiply, Divide |
| ⚖️ Compare | Equality comparison with auto-conversion |
| 🔄 Convert | Convert between units in same category |
| 📏 Length Units | FEET, INCHES, YARDS, CENTIMETERS |
| ⚖️ Weight Units | MILLIGRAM, GRAM, KILOGRAM, POUND, TONNE |
| 🧪 Volume Units | LITRE, MILLILITRE, GALLON |
| 🌡️ Temperature Units | CELSIUS, FAHRENHEIT, KELVIN |
| 🗃️ History Tracking | All operations saved to MySQL |
| ⚠️ Error Tracking | Failed operations also recorded |

---

### 🔴 4. API Gateway — `Port: 8080`

> The **single entry point** for all client requests.

Routes requests to appropriate services, validates JWT tokens, and handles CORS — all built on **Spring WebFlux (reactive/non-blocking)**.

| Feature | Details |
|---------|---------|
| 🔐 JWT Validation | Validates tokens BEFORE forwarding requests |
| 🔀 Dynamic Routing | Routes via Eureka `lb://` service names |
| 🌐 CORS | Global CORS configuration |
| ⚡ Reactive | Built on WebFlux — non-blocking I/O |
| 🔁 Load Balancing | Automatic via `lb://` prefix |

---

## ✅ Prerequisites

> Make sure the following tools are installed before running the project.

| Tool | Version | Purpose | Download |
|------|---------|---------|----------|
| ☕ **Java JDK** | 17+ | Runtime Environment | [adoptium.net](https://adoptium.net/) |
| 🔨 **Maven** | 3.8+ | Build Tool | [maven.apache.org](https://maven.apache.org/) |
| 🗄️ **MySQL** | 8.0+ | Database Server | [dev.mysql.com](https://dev.mysql.com/downloads/) |
| 💡 **IntelliJ IDEA** | Latest | IDE | [jetbrains.com](https://www.jetbrains.com/idea/) |
| 📮 **Postman** | Latest | API Testing | [postman.com](https://www.postman.com/) |

---

## 🗄️ Database Setup

> Run these SQL commands in **MySQL Workbench** or your terminal before starting services.

```sql
-- ============================================================
-- Step 1: Create both databases
-- ============================================================
CREATE DATABASE security_db;
CREATE DATABASE quantity_db;

-- ============================================================
-- Step 2: Verify creation
-- ============================================================
SHOW DATABASES;

-- Expected output:
-- +--------------------+
-- | Database           |
-- +--------------------+
-- | quantity_db        |
-- | security_db        |
-- +--------------------+
```

> 💡 **Note:** Tables are **auto-created by Hibernate** on first startup due to `ddl-auto: update`. You only need to create the databases manually.

---

## 🚀 How to Run

### Step 1 — Clone / Open Projects

Open all **4 projects** in IntelliJ IDEA or Eclipse as **separate windows**:

```
File → Open → select each project folder → Open in New Window
```

| Project Folder | Opens On |
|---------------|----------|
| `eureka-server/` | Port 8761 |
| `security-service/` | Port 8081 |
| `quantity-measurement-app/` | Port 8082 |
| `api-gateway/` | Port 8080 |

---

### Step 2 — Maven Reload

For **each project**, reload Maven dependencies:

```
Right click pom.xml → Maven → Reload Project
```

---

### Step 3 — Update MySQL Credentials

In `security-service/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/security_db
    username: root
    password: YOUR_MYSQL_PASSWORD   # ← 🔴 Update this
```

In `quantity-measurement-app/src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/quantity_db
    username: root
    password: YOUR_MYSQL_PASSWORD   # ← 🔴 Update this
```

---

### Step 4 — Start Services in Order

> ⚠️ **CRITICAL:** Services MUST be started in this exact order!

```
┌─────────────────────────────────────────────────────────┐
│                   STARTUP ORDER                         │
├─────────────────────────────────────────────────────────┤
│                                                         │
│  1️⃣  eureka-server            → wait for port 8761     │
│          ↓  (wait ~10 seconds)                          │
│  2️⃣  security-service         → wait for port 8081     │
│          ↓  (wait ~10 seconds)                          │
│  3️⃣  quantity-measurement-app → wait for port 8082     │
│          ↓  (wait ~10 seconds)                          │
│  4️⃣  api-gateway              → wait for port 8080     │
│                                                         │
└─────────────────────────────────────────────────────────┘
```

---

### Step 5 — Verify Everything is Running

Open your browser and navigate to:

```
http://localhost:8761
```

You should see **3 services registered** in the Eureka Dashboard:

```
┌──────────────────────────────────────┬──────────────────┐
│ Application                          │ Status           │
├──────────────────────────────────────┼──────────────────┤
│ SECURITY-SERVICE                     │ ✅ UP (1)        │
│ QUANTITY-MEASUREMENT-APP             │ ✅ UP (1)        │
│ API-GATEWAY                          │ ✅ UP (1)        │
└──────────────────────────────────────┴──────────────────┘
```

---

### Author👨‍💻

[DEVARSHI MISHRA](https://github.com/devarshim973) - Software Developer👨‍💻 | Cloud Enthusiast              
B.Tech - `[Computer Science & Engineering]`         
Java | Spring Boot | Maven | JWT & Security | OAuth | React.js | Clean Architecture

