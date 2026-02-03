# Wallet Service

## Overview

This project is a **high-concurrency wallet service** implemented as a Spring Boot–based REST application.  
It supports deposit and withdrawal operations on wallets, ensures data consistency under heavy concurrent load, and exposes an API to retrieve wallet balances.

The solution was developed as a complete production-like system, including database migrations, containerization, concurrency testing, and externalized configuration.

---

## Features

- REST API for wallet operations (**DEPOSIT / WITHDRAW**)
- Retrieve wallet balance by wallet UUID
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

### Deposit / Withdraw

`POST /api/v1/wallets`

```json
{
  "walletId": "UUID",
  "operationType": "DEPOSIT" | "WITHDRAW",
  "amount": 1000
}

## Get Wallet Balance

GET /api/v1/wallets/11111111-1111-1111-1111-111111111111
