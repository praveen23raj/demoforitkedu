# Wallet Service

## Overview

This project is a **high-concurrency wallet service** implemented as a Spring Boot–based REST application.  
It supports deposit and withdrawal operations on wallets, ensures data consistency under heavy concurrent load, and exposes REST APIs to retrieve wallet balances.

The solution was developed as a complete production-like system, including database migrations, containerization, concurrency testing, and externalized configuration.

---

## Features

- REST API for wallet operations (**DEPOSIT / WITHDRAW**)
- REST API to retrieve wallet balance
- High-concurrency–safe balance updates (tested with ~1000 concurrent requests)
- Proper validation and error handling:
  - Invalid JSON
  - Wallet not found
  - Insufficient funds
- Database versioning with **Liquibase**
- Fully containerized application and database using **Docker Compose**

---

## Tech Stack

- **Java 17**
- **Spring Boot 3**
- **PostgreSQL**
- **Liquibase** (database migrations)
- **Docker & Docker Compose**
- **Apache JMeter** (load and concurrency testing)
- **JUnit / Spring Test** (endpoint testing)

---

## API Endpoints

### 1. Deposit / Withdraw Wallet

**POST** `/api/v1/wallets`

#### Request Body
```json
{
  "walletId": "UUID",
  "operationType": "DEPOSIT",
  "amount": 1000
}
```

#### Successful Response
```json
{
  "walletId": "UUID",
  "balance": 5000
}
```

---

### 2. Get Wallet Balance

**GET** `/api/v1/wallets/{WALLET_UUID}`

#### Example Request
```
GET /api/v1/wallets/11111111-1111-1111-1111-111111111111
```

#### Successful Response
```json
{
  "walletId": "11111111-1111-1111-1111-111111111111",
  "balance": 5000
}
```

---

## Concurrency Handling

- Designed to handle **~1000 concurrent requests per wallet**
- No lost updates under concurrent access
- No unhandled 5xx errors during load tests

Concurrency behavior was verified using **Apache JMeter** with 1000 concurrent requests.  
Wallet balance updates are performed atomically at the database level to prevent race conditions.

---

## Database Migrations

- All schema changes are managed using **Liquibase**
- Migrations are executed automatically on application startup

---

## Configuration

The application and database are configured via environment variables.

### Application
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SERVER_PORT`

### Database
- `POSTGRES_DB`
- `POSTGRES_USER`
- `POSTGRES_PASSWORD`

No container rebuild is required to change configuration.

---

## Error Handling

The application returns meaningful HTTP responses:

- `400 Bad Request` — invalid JSON or request body
- `404 Not Found` — wallet does not exist
- `409 Conflict` — insufficient funds
- `500 Internal Server Error` — unexpected server errors

---

## Running the Project

### Prerequisites

- Docker
- Docker Compose

### Start Application

```bash
docker compose up --build
```

This starts:
- Spring Boot application
- PostgreSQL database

---

## Testing

- REST endpoints are covered with automated tests
- Load and concurrency testing performed using **Apache JMeter**

---

## Docker

- Application image is built and pushed to **Docker Hub**
- Database runs in a separate PostgreSQL container
- Entire system is orchestrated using **Docker Compose**

---

## Repository

The full source code is available on GitHub:

🔗 https://github.com/praveen23raj/demoforitkedu.git

---


## Author

**Praveen Raj V**
