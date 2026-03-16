<div align="center">

```
 ██████╗ █████╗ ██████╗     ██████╗ ███████╗███╗   ██╗████████╗ █████╗ ██╗     
██╔════╝██╔══██╗██╔══██╗    ██╔══██╗██╔════╝████╗  ██║╚══██╔══╝██╔══██╗██║     
██║     ███████║██████╔╝    ██████╔╝█████╗  ██╔██╗ ██║   ██║   ███████║██║     
██║     ██╔══██║██╔══██╗    ██╔══██╗██╔══╝  ██║╚██╗██║   ██║   ██╔══██║██║     
╚██████╗██║  ██║██║  ██║    ██║  ██║███████╗██║ ╚████║   ██║   ██║  ██║███████╗
 ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝
```

#  Car Rental Management System

**A full-stack enterprise application to digitalize vehicle rental operations**

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-24-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-DB_Migrations-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

</div>

---

## 🌟 What is This?

> **CarRental** is a modern, enterprise-grade platform that replaces paper-based vehicle rental operations with a seamless digital experience — from browsing the fleet to booking, billing, and business intelligence.

```
  Customer    →   Browse Cars   →   Book a Vehicle   →   Return
  Admin       →   Manage Fleet  →   Track Rentals    →   MIS Reports
```

---

## ✨ Key Features

| Feature | Description |
|---|---|
| 🚘 **Car Catalog** | Real-time vehicle availability & status tracking |
| 📅 **Booking Engine** | Automated reservation management |
| 👥 **Customer Management** | Full CRUD for customer records |
| 📊 **MIS Analytics** | Fleet performance & revenue reports |
| 🗄️ **Flyway Migrations** | Version-controlled database schema management |
| 🌐 **REST API** | Clean JSON API consumed by the Angular SPA |

---

## 🏗️ System Architecture

```
┌─────────────────────────────────────────────────────────┐
│                      FRONTEND                           │
│               Angular 24 (SPA)  :4200                   │
│         Components │ Services │ Routing │ HttpClient    │
└──────────────────────┬──────────────────────────────────┘
                       │  HTTP / REST (JSON)
┌──────────────────────▼──────────────────────────────────┐
│                      BACKEND                            │
│            Spring Boot 3  :8080                         │
│     Controllers → Services → Repositories → Entities    │
└──────────────────────┬──────────────────────────────────┘
                       │  JPA / Hibernate
┌──────────────────────▼──────────────────────────────────┐
│                     DATABASE                            │
│              MySQL 8  ←  Flyway Migrations              │
└─────────────────────────────────────────────────────────┘
```

---

## 🛠️ Tech Stack

### Backend
- **Java 17** + **Spring Boot 3**
- **Spring Data JPA** (Hibernate ORM)
- **Flyway** — database version control & migrations
- **Maven** — build & dependency management

### Frontend
- **Angular 24** — Single Page Application
- **TypeScript** + RxJS
- **Angular CLI**

### Database
- **MySQL 8** — primary data store
- **Flyway** — schema versioning

---

## 📋 Prerequisites

- **Java 17+**
- **Node.js 20+** & Angular CLI (`npm install -g @angular/cli`)
- **MySQL 8**
- **Maven 3.9+**

---

## 🚀 Getting Started

### 1️⃣ Clone the Repositories

```bash
# Backend
git clone https://github.com/hashini0123/CarRental_Managemet_System.git
cd CarRental_Managemet_System

# Frontend
git clone <angular-frontend-repo-url>
```

### 2️⃣ Database Setup

```sql
CREATE DATABASE car_rental_db;
```

> Flyway will auto-run all migration scripts on startup — no manual table creation needed! ✅

### 3️⃣ Configure `application.properties`

```properties
server.port=8080

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/car_rental_db
spring.datasource.username=root
spring.datasource.password=your_password

# JPA
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

# CORS
app.cors.allowed-origins=http://localhost:4200
```

### 4️⃣ Run the Backend

```bash
./mvnw spring-boot:run
```
✅ API live at: `http://localhost:8080`

### 5️⃣ Run the Angular Frontend

```bash
cd car-rental-frontend
npm install
ng serve
```
✅ App live at: `http://localhost:4200`

---

## 📡 API Endpoints

Base URL: `http://localhost:8080/api/v1`

### 🚘 Cars
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/cars` | Get all cars |
| `GET` | `/cars/{id}` | Get car by ID |
| `POST` | `/cars` | Add a new car |
| `PUT` | `/cars/{id}` | Update car details |
| `DELETE` | `/cars/{id}` | Remove a car |

### 📅 Bookings
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/bookings` | Get all bookings |
| `GET` | `/bookings/{id}` | Get booking by ID |
| `POST` | `/bookings` | Create a new booking |
| `PUT` | `/bookings/{id}` | Update booking |
| `DELETE` | `/bookings/{id}` | Cancel booking |

### 👥 Customers
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/customers` | Get all customers |
| `GET` | `/customers/{id}` | Get customer by ID |
| `POST` | `/customers` | Add a new customer |
| `PUT` | `/customers/{id}` | Update customer |
| `DELETE` | `/customers/{id}` | Delete customer |

### 📊 Reports (MIS)
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/reports/revenue` | Revenue summary |
| `GET` | `/reports/fleet` | Fleet status report |

---

## 🗄️ Flyway DB Migrations

Migration scripts live in `src/main/resources/db/migration/`:

```
V1__create_customers_table.sql
V2__create_cars_table.sql
V3__create_bookings_table.sql
V4__create_payments_table.sql
...
```

Flyway tracks and applies these automatically on every startup. 🚀

---

## 📁 Project Structure

```
CarRental_Managemet_System/
├── src/main/
│   ├── java/com/carrental/
│   │   ├── controller/        # REST Controllers
│   │   ├── service/           # Business Logic
│   │   ├── repository/        # JPA Repositories
│   │   ├── entity/            # JPA Entities
│   │   ├── dto/               # Request & Response DTOs
│   │   └── config/            # CORS & App Config
│   └── resources/
│       ├── application.properties
│       └── db/migration/      # Flyway SQL scripts
└── pom.xml
```

---

## 👩‍💻 Author

<div align="center">

**Hashini Nanayakkara**
*Undergraduate Software Engineering Student*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/hashini-nanayakkara-11402137a/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/hashini0123)

*Built with ❤️ using Spring Boot + Angular*

</div>
