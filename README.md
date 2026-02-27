# 🚗 Ridex Backend

> A production-grade Uber-lite ride booking backend built with Spring Boot — monolith first, microservices ready.

---

## 👋 About This Project

Ridex is a backend API for a ride booking application similar to Uber. It handles everything from user registration and driver management to real-time location tracking and fare calculation.

**Why monolith first?**
Starting as a monolith is intentional. It's easier to build, debug, and understand. Once the app is working, we'll split it into microservices — and the folder structure is already designed to make that transition clean.

**Tech Stack at a Glance:**
- **Spring Boot 3.4.5** — Backend framework (like Express.js but for Java)
- **PostgreSQL** — Relational database
- **Redis** — Caching & session storage
- **JWT** — Authentication
- **WebSocket** — Real-time location tracking
- **Docker** — Containerization
- **Swagger** — API documentation & testing UI

---

## 🧠 If You're Coming From JavaScript/Node.js

Spring Boot uses Java, which feels very different from Node.js at first. Here's a quick translation guide so nothing feels alien:

| Node.js / JS World | Spring Boot / Java World | What It Does |
|---|---|---|
| `package.json` | `pom.xml` | Lists your project dependencies and metadata |
| `npm install` | Maven auto-downloads on build | Installs dependencies |
| `node_modules/` | `~/.m2/repository/` | Where dependencies are stored locally |
| `express` | `spring-boot-starter-web` | HTTP server and routing |
| `app.listen(3000)` | Happens automatically | Starting the server |
| `.env` | `application.yml` | Environment/config variables |
| `middleware` | `Filter` or `Interceptor` | Code that runs before/after requests |
| `async/await` | `@Async` or reactive | Asynchronous operations |
| `module.exports` | `@Component`, `@Service`, `@Bean` | Making a class available for injection |
| `require()` | `@Autowired` or constructor injection | Using another module/class |
| `console.log()` | `log.info()` via SLF4J | Logging |

---

## 📦 What is `pom.xml`?

Think of it as your `package.json`. It does three things:

1. **Defines your project** — name, version, Java version
2. **Lists dependencies** — like `"express": "^4.18.0"` but in XML
3. **Configures the build** — how to compile and package your app

```xml
<!-- This is like "dependencies": { "express": "^4.18.0" } in package.json -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

You never manually download JARs (like you never manually download `node_modules`). Maven (the build tool, like npm) handles it automatically.

---

## 🛠️ Dependencies Used & Why

### Core

| Dependency | Why We Need It |
|---|---|
| `spring-boot-starter-web` | Provides REST API support — routing, HTTP handling, JSON conversion |
| `spring-boot-starter-data-jpa` | Lets us talk to the database using Java objects instead of raw SQL |
| `spring-boot-starter-security` | Authentication, authorization, password encoding |
| `spring-boot-starter-validation` | Validates request bodies (e.g., `@NotNull`, `@Email`) |
| `spring-boot-starter-websocket` | Real-time bidirectional communication for live location tracking |

### Database

| Dependency | Why We Need It |
|---|---|
| `postgresql` | The PostgreSQL JDBC driver — lets Java talk to PostgreSQL |
| `spring-boot-starter-data-redis` | Connects to Redis for caching driver locations, OTPs, token blacklists |

### Security & Auth

| Dependency | Why We Need It |
|---|---|
| `jjwt-api` | JWT library — for creating and validating JSON Web Tokens |
| `jjwt-impl` | JWT implementation |
| `jjwt-jackson` | JWT + JSON serialization |

### Developer Experience

| Dependency | Why We Need It |
|---|---|
| `lombok` | Removes boilerplate — auto-generates getters, setters, constructors via annotations |
| `mapstruct` | Auto-generates code to convert between Entity ↔ DTO |
| `springdoc-openapi-starter-webmvc-ui` | Auto-generates Swagger UI at `/swagger-ui.html` |
| `spring-boot-starter-actuator` | Exposes health check endpoints — useful for Docker & monitoring |

---

## 🗂️ Project Structure Explained

```
swiftride-backend/
├── src/
│   └── main/
│       ├── java/com/ridex/
│       │   ├── RidexApplication.java        ← Entry point (like index.js)
│       │   │
│       │   ├── config/                          ← App-wide configuration
│       │   │   ├── SecurityConfig.java          ← Who can access what endpoints
│       │   │   ├── RedisConfig.java             ← Redis connection setup
│       │   │   ├── WebSocketConfig.java         ← WebSocket setup
│       │   │   └── SwaggerConfig.java           ← API docs config
│       │   │
│       │   ├── controller/                      ← Route handlers (like Express routers)
│       │   │   ├── AuthController.java          ← /api/auth/** endpoints
│       │   │   ├── UserController.java          ← /api/users/** endpoints
│       │   │   ├── DriverController.java        ← /api/drivers/** endpoints
│       │   │   ├── BookingController.java       ← /api/bookings/** endpoints
│       │   │   └── LocationController.java      ← /api/locations/** endpoints
│       │   │
│       │   ├── service/                         ← Business logic layer
│       │   │   ├── AuthService.java             ← Login, register, token refresh
│       │   │   ├── UserService.java             ← User CRUD operations
│       │   │   ├── DriverService.java           ← Driver management, availability
│       │   │   ├── BookingService.java          ← Ride lifecycle management
│       │   │   ├── FareService.java             ← Fare calculation logic
│       │   │   └── LocationService.java         ← Driver location updates
│       │   │
│       │   ├── repository/                      ← Database access layer (like DB queries)
│       │   │   ├── UserRepository.java          ← User table queries
│       │   │   ├── DriverRepository.java        ← Driver table queries
│       │   │   └── BookingRepository.java       ← Booking table queries
│       │   │
│       │   ├── entity/                          ← Database table models (like Mongoose schemas)
│       │   │   ├── User.java                    ← users table
│       │   │   ├── Driver.java                  ← drivers table
│       │   │   ├── Booking.java                 ← bookings table
│       │   │   └── Location.java                ← location history table
│       │   │
│       │   ├── dto/                             ← Data Transfer Objects
│       │   │   ├── request/                     ← What the client sends to us
│       │   │   │   ├── LoginRequest.java
│       │   │   │   ├── RegisterRequest.java
│       │   │   │   └── BookingRequest.java
│       │   │   └── response/                    ← What we send back to the client
│       │   │       ├── AuthResponse.java
│       │   │       ├── BookingResponse.java
│       │   │       └── FareResponse.java
│       │   │
│       │   ├── security/                        ← JWT auth internals
│       │   │   ├── JwtTokenProvider.java        ← Creates and validates JWT tokens
│       │   │   ├── JwtAuthFilter.java           ← Intercepts every request to check token
│       │   │   └── CustomUserDetailsService.java ← Loads user by email for Spring Security
│       │   │
│       │   ├── enums/                           ← Fixed value sets
│       │   │   ├── BookingStatus.java           ← PENDING, ACCEPTED, IN_PROGRESS, COMPLETED, CANCELLED
│       │   │   ├── DriverStatus.java            ← ONLINE, OFFLINE, ON_TRIP
│       │   │   └── Role.java                    ← RIDER, DRIVER, ADMIN
│       │   │
│       │   ├── exception/                       ← Error handling
│       │   │   ├── GlobalExceptionHandler.java  ← Catches all errors app-wide (like Express error middleware)
│       │   │   ├── ResourceNotFoundException.java ← 404 errors
│       │   │   └── UnauthorizedException.java   ← 401 errors
│       │   │
│       │   └── websocket/                       ← Real-time location
│       │       ├── LocationWebSocketHandler.java ← Handles WS connections
│       │       └── LocationMessage.java          ← Message structure
│       │
│       └── resources/
│           ├── application.yml                  ← Main config (like .env but structured)
│           ├── application-dev.yml              ← Dev environment overrides
│           └── application-prod.yml             ← Production environment overrides
│
├── docker-compose.yml                           ← Spins up app + PostgreSQL + Redis together
├── Dockerfile                                   ← How to containerize the app
├── .env.example                                 ← Template for environment variables
├── .gitignore
└── README.md
```

### 🤔 What is a DTO?

This is a concept you won't have in Node.js normally but it's very important in Spring Boot.

- **Entity** = the actual database row/model. Contains all fields including sensitive ones.
- **DTO (Data Transfer Object)** = a stripped-down version of the entity for sending/receiving data.

For example, your `User` entity has a `password` field. You never want to send that in a response. So you create a `UserResponse` DTO that has everything *except* the password. Same idea for requests — a `RegisterRequest` DTO only has the fields a user fills in on signup, not system-generated fields like `id` or `createdAt`.

```
Client sends RegisterRequest → Controller → Service → Entity saved to DB
DB Entity → Service → UserResponse DTO → Controller sends to Client
```

---

## 🔐 Authentication Flow

This app uses **JWT (JSON Web Tokens)** — stateless, no sessions stored on server.

```
1. User sends POST /api/auth/login with { email, password }
2. Server verifies credentials
3. Server creates a JWT token (signed with a secret key)
4. Server returns { accessToken, refreshToken }
5. Client stores the token and sends it in every future request:
   Header: Authorization: Bearer <token>
6. JwtAuthFilter intercepts every request and validates the token
7. If valid → request proceeds. If invalid → 401 Unauthorized.
```

**Why JWT over sessions?**
When we split into microservices later, each service can independently verify a JWT token without calling a central auth server. Sessions would require a shared session store which is harder to scale.

---

## 🏗️ Core Features

### 1. User Management
- Register as rider or driver
- Login / logout
- Refresh access tokens
- Profile management

### 2. Driver Management
- Driver onboarding (vehicle details, license)
- Toggle availability (ONLINE / OFFLINE)
- View earnings and trip history

### 3. Booking / Ride Lifecycle
```
RIDER requests ride
       ↓
   PENDING (finding driver)
       ↓
   ACCEPTED (driver accepts)
       ↓
   DRIVER_ARRIVED
       ↓
   IN_PROGRESS (trip started)
       ↓
   COMPLETED / CANCELLED
```

### 4. Fare Calculation
- Base fare + per km rate + per minute rate
- Surge pricing multiplier during peak hours
- Fare estimate before booking

### 5. Real-Time Location (WebSocket)
- Driver sends location updates every few seconds
- Rider sees driver moving on map in real time
- Redis caches latest driver locations for fast nearby-driver queries

---

## 🚀 Getting Started

### Prerequisites

Make sure you have these installed:

- **Java 17+** — [Download](https://adoptium.net/)
- **Maven 3.8+** — usually comes with your IDE
- **Docker & Docker Compose** — [Download](https://www.docker.com/products/docker-desktop/)
- **IntelliJ IDEA** (recommended) or VS Code with Java extensions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ridex.git
cd ridex
```

### 2. Set Up Environment Variables

```bash
cp .env.example .env
# Edit .env with your values
```

### 3. Start Infrastructure (PostgreSQL + Redis)

```bash
docker-compose up -d postgres redis
```

This spins up PostgreSQL on port `5432` and Redis on port `6379`. You don't need to install them manually.

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Or open the project in IntelliJ IDEA and click the green Run button.

### 5. Verify It's Running

Open your browser and go to:
- **Swagger UI** → http://localhost:8080/swagger-ui.html
- **Health Check** → http://localhost:8080/actuator/health

---

## 🐳 Running with Docker (Full Stack)

To run everything (app + database + Redis) in containers:

```bash
docker-compose up --build
```

---

## 📡 API Endpoints Overview

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user or driver |
| POST | `/api/auth/login` | Login and receive tokens |
| POST | `/api/auth/refresh` | Refresh access token |
| POST | `/api/auth/logout` | Invalidate token |

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users/me` | Get current user profile |
| PUT | `/api/users/me` | Update profile |

### Drivers
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/drivers/nearby` | Get nearby available drivers |
| PUT | `/api/drivers/status` | Toggle online/offline |
| GET | `/api/drivers/me/trips` | Driver trip history |

### Bookings
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/bookings` | Request a ride |
| GET | `/api/bookings/:id` | Get booking details |
| PUT | `/api/bookings/:id/accept` | Driver accepts ride |
| PUT | `/api/bookings/:id/cancel` | Cancel a booking |
| GET | `/api/bookings/fare-estimate` | Get fare estimate |

### Location (WebSocket)
| Event | Description |
|-------|-------------|
| `/ws/location` | WebSocket endpoint for real-time updates |
| `DRIVER_LOCATION_UPDATE` | Driver sends their coordinates |
| `RIDER_TRACKING` | Rider receives driver location |

---

## 🗄️ Database Schema Overview

```
users
  id, name, email, password, phone, role, created_at

drivers
  id, user_id (FK), license_number, vehicle_make, vehicle_model,
  vehicle_plate, status, rating, total_trips

bookings
  id, rider_id (FK), driver_id (FK), pickup_lat, pickup_lng,
  dropoff_lat, dropoff_lng, status, fare, distance_km,
  requested_at, started_at, completed_at

locations
  id, driver_id (FK), latitude, longitude, recorded_at
```

---

## 🧩 Architecture Layers Explained

Spring Boot follows a **layered architecture**. Think of it like this:

```
HTTP Request
     ↓
[Controller Layer]   ← Receives request, validates input, calls service
     ↓
[Service Layer]      ← Business logic lives here, calls repository
     ↓
[Repository Layer]   ← Talks to the database, nothing else
     ↓
[Database]
```

**Why layers?** Each layer has one job. Controllers don't query the DB directly. Services don't parse HTTP requests. This separation makes testing and debugging much easier.

---

## 🔮 Future: Microservices Split

When we're ready to decompose, this monolith splits cleanly into:

| Microservice | Extracted From |
|---|---|
| `user-service` | `UserController`, `UserService`, `UserRepository`, `User` entity |
| `driver-service` | `DriverController`, `DriverService`, `DriverRepository`, `Driver` entity |
| `booking-service` | `BookingController`, `BookingService`, `BookingRepository`, `Booking` entity |
| `pricing-service` | `FareService`, `FareResponse` |
| `location-service` | `LocationController`, `LocationService`, `websocket/` |
| `auth-service` | `AuthController`, `AuthService`, `security/` |

Services will communicate via **REST** (synchronous) or **Kafka/RabbitMQ** (asynchronous events).

---

## 🧪 Testing (Coming Soon)

- Unit tests for service layer (JUnit 5 + Mockito)
- Integration tests for controllers (MockMvc)
- Repository tests (Spring Data JPA Test with H2)

---

## 📝 Environment Variables Reference

```env
# Database
DB_URL=jdbc:postgresql://localhost:5432/swiftride
DB_USERNAME=swiftride_user
DB_PASSWORD=your_password

# JWT
JWT_SECRET=your_super_secret_key_here
JWT_EXPIRATION_MS=86400000
JWT_REFRESH_EXPIRATION_MS=604800000

# Redis
REDIS_HOST=localhost
REDIS_PORT=6379

# App
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=dev
```

---

## 🤝 Contributing

This is a learning project. If you spot something to improve:

1. Fork the repo
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "Add: description"`
4. Push and open a PR

---

## 📚 Learning Resources

- [Spring Boot Official Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Security + JWT Guide](https://www.bezkoder.com/spring-boot-jwt-authentication/)
- [PostgreSQL + Spring Data JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [WebSocket in Spring Boot](https://spring.io/guides/gs/messaging-stomp-websocket/)
- [Docker Compose for Spring Boot](https://docs.docker.com/compose/)

---

## 📄 License

MIT License — free to use, modify, and learn from.

---

*Built as a learning project — monolith today, microservices tomorrow* 🚀