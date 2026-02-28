<div align="center">
  <img src="ridex.jpg" alt="Ridex" width="80" /><br><br>
  Uber-lite ride booking backend. Spring Boot + PostgreSQL + Redis.<br><br>

  <img src="https://img.shields.io/badge/Spring_Boot-3.4.5-black?style=flat-square" />
  <img src="https://img.shields.io/badge/Java-17-black?style=flat-square" />
  <img src="https://img.shields.io/badge/Status-In_Development-black?style=flat-square" />
</div>

---

Work in progress by [saadhtiwana](https://github.com/saadhtiwana) and [abdullahxdev](https://github.com/abdullahxdev).

---

## Stack

| Layer | Tech |
|---|---|
| Backend | Spring Boot 3.4.5 |
| Database | PostgreSQL |
| Cache | Redis |
| Auth | JWT |
| Realtime | WebSocket |
| Docs | Swagger UI |
| Infra | Docker |

## Running Locally

```bash
# Start PostgreSQL and Redis
docker-compose up -d postgres redis

# Run the app
./mvnw spring-boot:run
```

Swagger UI → `http://localhost:8080/swagger-ui.html`

## Structure

```
config/        app-wide configuration
controller/    route handlers
service/       business logic
repository/    database access
entity/        table models
dto/           request and response shapes
security/      JWT filter and token provider
websocket/     realtime location
exception/     error handling
enums/         BookingStatus, DriverStatus, Role
```

## Ride States

```
PENDING → ACCEPTED → DRIVER ARRIVED → IN PROGRESS → COMPLETED
                                                   ↘ CANCELLED
```

---

MIT License
