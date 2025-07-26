# DealCluster

**FX Deals ingestion & clustering service for Bloomberg Data Warehouse**

---

## 🚀 Features

- Ingest FX deals via REST
- Idempotent import (no duplicates)
- Validation of required fields
- No-rollback policy: each row is saved in its own transaction
- Works with PostgreSQL, Docker Compose
- Full unit & integration tests with Testcontainers
- Code generated via Lombok, clean layering (DTO → Controller → Service → Repo)

---

## 📋 Prerequisites

- Java 17 + Maven
- Docker & Docker Compose (for local DB)
- Git

---

## 🛠️ Quickstart

1. **Clone the repo**
   ```bash
   git clone https://github.com/<your-username>/dealcluster.git
   cd dealcluster
2. **Build & Test**
   ```bash
   make test 
3. **Run locally (Without DB)**
   ```bash
   make run 
   # ↳ runs 'java -jar target/dealcluster-0.0.1-SNAPSHOT.jar'
4. **Run With PostgreSQL (Docker Compose)**
   ```bash
   make docker-up 
   # API at http://localhost:8080/api/deals
5. **Shut Down**
   ```bash
   make docker-down

## 🧪 Test & Coverage

- JUnit & integration tests via JUnit 5, Mockito, Spring Boot Test, Testcontainers
- Coverage report under target/site/jacoco/index.html
- To regenerate:
  ```bash
  mvn clean test
  open target/site/jacoco/index.html

## 📦 Docker

- Dockerfile builds & packages the JAR
- docker-compose.yml brings up Postgres + app
- Environment variables (DB_HOST, DB_USER, etc.) all defaulted

## 🔌 API
- POST / api/deals
- body : 
 ```bash
    {
      "dealUniqueId": "deal-001",
      "orderingCurrency": "USD",
      "targetCurrency": "EUR",
      "dealTimestamp": "2025-07-26T12:00:00Z",
      "dealAmount": 12345.67
    }
```
- Response:
```bash
    201 Created: returns saved deal JSON

    409 Conflict: duplicate ID

    400 Bad Request: validation errors
```


