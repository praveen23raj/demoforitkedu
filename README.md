# Wallet Service

## Overview

This project is a **high-concurrency wallet service** implemented as a Spring-based REST application. It supports deposit and withdrawal operations on wallets, ensures data consistency under heavy load, and exposes an API to retrieve wallet balances.

The solution was developed as a complete production-like system, including database migrations, containerization, concurrency testing, and CI-ready structure.

## Features

* REST API for wallet operations (DEPOSIT / WITHDRAW)
* Retrieve wallet balance by wallet UUID
* High-concurrency safe balance updates (tested up to 1000 concurrent requests)
* Proper validation and error handling (invalid JSON, wallet not found, insufficient funds)
* Database versioning with Liquibase
* Fully containerized application and database

## Tech Stack

* **Java** 8–17
* **Spring Boot 3**
* **PostgreSQL**
* **Liquibase** (database migrations)
* **Docker & Docker Compose**
* **Apache JMeter** (load and concurrency testing)
* **JUnit / Spring Test** (endpoint testing)

## API Endpoints

### Deposit / Withdraw

`POST /api/v1/wallets`

```json
{
  "walletId": "UUID",
  "operationType": "DEPOSIT" | "WITHDRAW",
  "amount": 1000
}
```

### Get Wallet Balance

`GET /api/v1/wallets/{WALLET_UUID}`

## Concurrency Handling

* Designed to handle **1000 RPS per wallet**
* No lost updates under concurrent access
* No unhandled 5xx errors during load tests

Concurrency behavior was verified using **Apache JMeter** with 1000 concurrent requests.

## Database Migrations

* All schema changes are managed using **Liquibase**
* Migrations are executed automatically on application startup

## Running the Project

### Prerequisites

* Docker
* Docker Compose

### Start Application

```bash
docker-compose up --build
```

This starts:

* Spring Boot application
* PostgreSQL database

All configuration is externalized via environment variables (no image rebuild required).

## Testing

* REST endpoints are covered with automated tests
* Load and concurrency testing performed using **JMeter**

## Docker

* Application image is built and pushed to **Docker Hub**
* Database runs in a separate PostgreSQL container

## Repository

The full source code is available on GitHub:

> **GitHub URL:** *add your repository link here*

## License

MIT

## Author

Praveen Raj V
