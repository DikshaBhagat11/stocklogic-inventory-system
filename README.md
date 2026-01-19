# Enterprise Inventory & Analytics Dashboard

A professional-grade management portal designed for real-time inventory tracking, low-stock alerting, and data visualization.

## 🚀 The "Why"
This project solves the problem of manual inventory tracking by providing an automated system that tracks stock history and visualizes trends to help businesses make data-driven purchasing decisions.

## 🛠️ Tech Stack
* **Backend:** Java 21 (Spring Boot 3.x)
* **Database:** PostgreSQL
* **Frontend:** JavaScript (Chart.js), Tailwind CSS
* **Security:** Spring Security (JWT/Session management planned)

## 🏗️ Project Structure
- `/src/main/java/.../model`: Database Entities
- `/src/main/java/.../repository`: Data Access Layer (JPA)
- `/src/main/java/.../service`: Business Logic
- `/src/main/java/.../controller`: REST API Endpoints

## ⚙️ Installation & Setup
1. **Clone the repository:** `git clone https://github.com/DikshaBhagat11/stocklogic-inventory-system.git`
2. **Database Setup:** Create a PostgreSQL database named `stocklogic-inventory`.
3. **Environment Variables:** Set a local environment variable `DB_PASSWORD` with your PostgreSQL password.
4. **Run Application:** Execute `./mvnw spring-boot:run` in the terminal.