<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ridex — Backend Documentation</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display:ital@0;1&family=DM+Mono:wght@300;400;500&family=DM+Sans:wght@300;400;500&display=swap" rel="stylesheet">
<style>
  *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

  :root {
    --bg: #f5f2ec;
    --ink: #1a1714;
    --ink-muted: #6b6560;
    --ink-faint: #b0aaa4;
    --accent: #c84b2f;
    --rule: #d8d2ca;
    --code-bg: #ede9e2;
    --font-serif: 'DM Serif Display', Georgia, serif;
    --font-sans: 'DM Sans', sans-serif;
    --font-mono: 'DM Mono', 'Courier New', monospace;
  }

  html { font-size: 16px; scroll-behavior: smooth; }

  body {
    background: var(--bg);
    color: var(--ink);
    font-family: var(--font-sans);
    font-weight: 300;
    line-height: 1.75;
    -webkit-font-smoothing: antialiased;
  }

  /* Layout */
  .page {
    max-width: 820px;
    margin: 0 auto;
    padding: 0 2rem 8rem;
  }

  /* Header */
  header {
    padding: 5rem 0 4rem;
    border-bottom: 1px solid var(--rule);
    margin-bottom: 5rem;
  }

  .eyebrow {
    font-family: var(--font-mono);
    font-size: 0.7rem;
    letter-spacing: 0.2em;
    text-transform: uppercase;
    color: var(--ink-muted);
    margin-bottom: 1.5rem;
  }

  h1 {
    font-family: var(--font-serif);
    font-size: clamp(3.5rem, 8vw, 6rem);
    line-height: 1;
    letter-spacing: -0.02em;
    color: var(--ink);
    margin-bottom: 1.5rem;
  }

  h1 .italic { font-style: italic; color: var(--accent); }

  .header-sub {
    font-size: 1rem;
    color: var(--ink-muted);
    max-width: 500px;
    line-height: 1.7;
    margin-bottom: 2.5rem;
  }

  .meta-row {
    display: flex;
    gap: 2rem;
    flex-wrap: wrap;
  }

  .meta-item {
    font-family: var(--font-mono);
    font-size: 0.72rem;
    color: var(--ink-muted);
    letter-spacing: 0.05em;
  }

  .meta-item strong {
    color: var(--ink);
    font-weight: 500;
    display: block;
    margin-bottom: 0.2rem;
  }

  /* Sections */
  section {
    margin-bottom: 5rem;
  }

  h2 {
    font-family: var(--font-serif);
    font-size: 1.9rem;
    letter-spacing: -0.01em;
    color: var(--ink);
    margin-bottom: 1.5rem;
    display: flex;
    align-items: center;
    gap: 1rem;
  }

  h2::after {
    content: '';
    flex: 1;
    height: 1px;
    background: var(--rule);
  }

  h3 {
    font-family: var(--font-sans);
    font-size: 0.75rem;
    font-weight: 500;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--accent);
    margin-bottom: 1rem;
    margin-top: 2.5rem;
  }

  h3:first-child { margin-top: 0; }

  p {
    font-size: 0.95rem;
    color: var(--ink-muted);
    margin-bottom: 1rem;
    max-width: 65ch;
  }

  /* Tables */
  .table-wrap {
    overflow-x: auto;
    margin: 1.5rem 0;
    border: 1px solid var(--rule);
  }

  table {
    width: 100%;
    border-collapse: collapse;
    font-size: 0.85rem;
  }

  thead tr {
    background: var(--ink);
    color: var(--bg);
  }

  thead th {
    padding: 0.75rem 1rem;
    text-align: left;
    font-family: var(--font-mono);
    font-size: 0.68rem;
    font-weight: 400;
    letter-spacing: 0.12em;
    text-transform: uppercase;
  }

  tbody tr {
    border-bottom: 1px solid var(--rule);
    transition: background 0.15s;
  }

  tbody tr:last-child { border-bottom: none; }
  tbody tr:hover { background: var(--code-bg); }

  td {
    padding: 0.85rem 1rem;
    vertical-align: top;
    color: var(--ink-muted);
    line-height: 1.5;
  }

  td:first-child {
    font-family: var(--font-mono);
    font-size: 0.78rem;
    color: var(--ink);
    white-space: nowrap;
  }

  td .method {
    font-family: var(--font-mono);
    font-size: 0.68rem;
    font-weight: 500;
    padding: 0.15rem 0.4rem;
    border-radius: 2px;
    margin-right: 0.5rem;
  }
  .get  { background: #ddeedd; color: #2a6e3a; }
  .post { background: #dde8f8; color: #1e4a8a; }
  .put  { background: #fef3dd; color: #8a5a1a; }

  /* Code blocks */
  pre {
    background: var(--code-bg);
    border: 1px solid var(--rule);
    padding: 1.5rem;
    overflow-x: auto;
    margin: 1.5rem 0;
    font-family: var(--font-mono);
    font-size: 0.78rem;
    line-height: 1.7;
    color: var(--ink);
  }

  code {
    font-family: var(--font-mono);
    font-size: 0.82em;
    background: var(--code-bg);
    padding: 0.1em 0.35em;
    border: 1px solid var(--rule);
    color: var(--ink);
  }

  pre code {
    background: none;
    border: none;
    padding: 0;
    font-size: inherit;
  }

  /* Flow diagram */
  .flow {
    display: flex;
    flex-direction: column;
    gap: 0;
    margin: 1.5rem 0;
    border: 1px solid var(--rule);
    overflow: hidden;
  }

  .flow-step {
    display: flex;
    align-items: center;
    gap: 1rem;
    padding: 0.85rem 1.25rem;
    border-bottom: 1px solid var(--rule);
    transition: background 0.15s;
  }

  .flow-step:last-child { border-bottom: none; }
  .flow-step:hover { background: var(--code-bg); }

  .flow-num {
    font-family: var(--font-mono);
    font-size: 0.65rem;
    color: var(--ink-faint);
    width: 1.5rem;
    flex-shrink: 0;
  }

  .flow-text {
    font-size: 0.88rem;
    color: var(--ink-muted);
  }

  /* Status pills */
  .status-row {
    display: flex;
    flex-wrap: wrap;
    gap: 0.5rem;
    margin: 1.5rem 0;
    align-items: center;
  }

  .status-pill {
    font-family: var(--font-mono);
    font-size: 0.7rem;
    letter-spacing: 0.08em;
    padding: 0.3rem 0.7rem;
    border: 1px solid var(--rule);
    color: var(--ink-muted);
    background: var(--code-bg);
  }

  .status-arrow {
    font-family: var(--font-mono);
    color: var(--ink-faint);
    font-size: 0.7rem;
  }

  /* Columns */
  .cols {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 2rem;
    margin: 1.5rem 0;
  }

  @media (max-width: 600px) { .cols { grid-template-columns: 1fr; } }

  .col-block {
    border: 1px solid var(--rule);
    padding: 1.25rem;
  }

  .col-block h4 {
    font-family: var(--font-mono);
    font-size: 0.68rem;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--accent);
    margin-bottom: 0.75rem;
  }

  .col-block ul {
    list-style: none;
    padding: 0;
  }

  .col-block ul li {
    font-size: 0.85rem;
    color: var(--ink-muted);
    padding: 0.3rem 0;
    border-bottom: 1px solid var(--rule);
    display: flex;
    align-items: baseline;
    gap: 0.5rem;
  }

  .col-block ul li:last-child { border-bottom: none; }

  .col-block ul li::before {
    content: '';
    width: 4px;
    height: 4px;
    background: var(--ink-faint);
    border-radius: 50%;
    flex-shrink: 0;
    margin-top: 0.4rem;
  }

  /* Architecture diagram */
  .arch {
    border: 1px solid var(--rule);
    overflow: hidden;
    margin: 1.5rem 0;
  }

  .arch-layer {
    display: flex;
    align-items: center;
    padding: 1rem 1.25rem;
    border-bottom: 1px solid var(--rule);
    gap: 1.5rem;
  }

  .arch-layer:last-child { border-bottom: none; }

  .arch-label {
    font-family: var(--font-mono);
    font-size: 0.68rem;
    letter-spacing: 0.1em;
    text-transform: uppercase;
    color: var(--ink-faint);
    width: 100px;
    flex-shrink: 0;
  }

  .arch-name {
    font-family: var(--font-mono);
    font-size: 0.8rem;
    color: var(--ink);
    font-weight: 500;
  }

  .arch-desc {
    font-size: 0.8rem;
    color: var(--ink-muted);
    margin-left: auto;
  }

  .arch-arrow {
    font-family: var(--font-mono);
    color: var(--ink-faint);
    font-size: 0.8rem;
    text-align: center;
    padding: 0.3rem;
    background: var(--code-bg);
    border-bottom: 1px solid var(--rule);
  }

  /* Schema */
  .schema-table {
    font-family: var(--font-mono);
    font-size: 0.78rem;
    background: var(--code-bg);
    border: 1px solid var(--rule);
    padding: 1.25rem;
    margin: 1rem 0;
  }

  .schema-table .table-name {
    color: var(--accent);
    font-weight: 500;
    margin-bottom: 0.5rem;
  }

  .schema-table .fields {
    color: var(--ink-muted);
    line-height: 1.9;
    padding-left: 1rem;
    border-left: 2px solid var(--rule);
  }

  .schema-table .pk { color: var(--ink); font-weight: 500; }
  .schema-table .fk { color: #2a6e8a; }

  /* Step commands */
  .step {
    display: flex;
    gap: 1.5rem;
    margin-bottom: 2rem;
    align-items: flex-start;
  }

  .step-num {
    font-family: var(--font-serif);
    font-size: 2rem;
    line-height: 1;
    color: var(--ink-faint);
    flex-shrink: 0;
    width: 2rem;
    text-align: center;
    margin-top: 0.1rem;
  }

  .step-content h4 {
    font-family: var(--font-sans);
    font-size: 0.88rem;
    font-weight: 500;
    color: var(--ink);
    margin-bottom: 0.4rem;
  }

  .step-content p { margin-bottom: 0.5rem; }

  /* Footer */
  footer {
    border-top: 1px solid var(--rule);
    padding-top: 3rem;
    margin-top: 5rem;
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    flex-wrap: wrap;
    gap: 1rem;
  }

  .footer-title {
    font-family: var(--font-serif);
    font-size: 1.5rem;
    color: var(--ink);
  }

  .footer-title em { font-style: italic; color: var(--accent); }

  .footer-meta {
    font-family: var(--font-mono);
    font-size: 0.68rem;
    color: var(--ink-faint);
    text-align: right;
    line-height: 1.8;
  }

  /* Animations */
  @keyframes fadeUp {
    from { opacity: 0; transform: translateY(16px); }
    to   { opacity: 1; transform: translateY(0); }
  }

  header, section {
    animation: fadeUp 0.5s ease both;
  }

  section:nth-child(2) { animation-delay: 0.05s; }
  section:nth-child(3) { animation-delay: 0.10s; }
  section:nth-child(4) { animation-delay: 0.15s; }
  section:nth-child(5) { animation-delay: 0.20s; }

  /* Nav sidebar dot */
  .nav-dot {
    position: fixed;
    left: 1.5rem;
    top: 50%;
    transform: translateY(-50%);
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    opacity: 0.3;
  }

  @media (max-width: 900px) { .nav-dot { display: none; } }

  .nav-dot a {
    width: 4px;
    height: 4px;
    background: var(--ink);
    border-radius: 50%;
    display: block;
    transition: transform 0.2s, opacity 0.2s;
    text-decoration: none;
  }

  .nav-dot a:hover {
    transform: scale(2);
    opacity: 1;
  }

  a {
    color: var(--accent);
    text-decoration: underline;
    text-underline-offset: 3px;
  }

  a:hover { text-decoration: none; }

  .env-block {
    background: var(--ink);
    color: #c8c2ba;
    padding: 1.5rem;
    font-family: var(--font-mono);
    font-size: 0.78rem;
    line-height: 1.9;
    margin: 1.5rem 0;
    border: 1px solid var(--ink);
  }

  .env-block .comment { color: #6b6560; }
  .env-block .key { color: #d4a87a; }
  .env-block .val { color: #8bc4a8; }
</style>
</head>
<body>

<nav class="nav-dot" aria-hidden="true">
  <a href="#about"></a>
  <a href="#stack"></a>
  <a href="#structure"></a>
  <a href="#auth"></a>
  <a href="#features"></a>
  <a href="#api"></a>
  <a href="#schema"></a>
  <a href="#start"></a>
  <a href="#future"></a>
</nav>

<div class="page">

  <header>
    <div class="eyebrow">Production-grade ride booking backend</div>
    <h1>Ride<span class="italic">x</span></h1>
    <p class="header-sub">An Uber-lite backend API. Monolith first, microservices ready. Built with Spring Boot, PostgreSQL, Redis, and WebSockets.</p>
    <div class="meta-row">
      <div class="meta-item"><strong>Authors</strong> saadhtiwana &amp; abdullahxdev</div>
      <div class="meta-item"><strong>Framework</strong> Spring Boot 3.4.5</div>
      <div class="meta-item"><strong>Database</strong> PostgreSQL + Redis</div>
      <div class="meta-item"><strong>License</strong> MIT</div>
    </div>
  </header>

  <!-- About -->
  <section id="about">
    <h2>About</h2>
    <p>Ridex handles everything from user registration and driver management to real-time location tracking and fare calculation. Starting as a monolith is intentional — it is easier to build, debug, and understand. Once the app is working, it splits cleanly into microservices. The folder structure is already designed to make that transition straightforward.</p>

    <h3>If you are coming from Node.js</h3>
    <p>Spring Boot uses Java, which feels different from Node.js at first. Here is a quick translation.</p>

    <div class="table-wrap">
      <table>
        <thead>
          <tr>
            <th>Node.js / JS</th>
            <th>Spring Boot / Java</th>
            <th>What it does</th>
          </tr>
        </thead>
        <tbody>
          <tr><td>package.json</td><td>pom.xml</td><td>Project dependencies and metadata</td></tr>
          <tr><td>npm install</td><td>Maven auto-downloads on build</td><td>Installs dependencies</td></tr>
          <tr><td>node_modules/</td><td>~/.m2/repository/</td><td>Where dependencies live locally</td></tr>
          <tr><td>express</td><td>spring-boot-starter-web</td><td>HTTP server and routing</td></tr>
          <tr><td>.env</td><td>application.yml</td><td>Environment / config variables</td></tr>
          <tr><td>middleware</td><td>Filter or Interceptor</td><td>Code that runs before / after requests</td></tr>
          <tr><td>module.exports</td><td>@Component, @Service, @Bean</td><td>Making a class available for injection</td></tr>
          <tr><td>require()</td><td>@Autowired or constructor injection</td><td>Using another module or class</td></tr>
          <tr><td>console.log()</td><td>log.info() via SLF4J</td><td>Logging</td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- Tech Stack -->
  <section id="stack">
    <h2>Dependencies</h2>
    <p><code>pom.xml</code> is your <code>package.json</code>. It defines your project, lists dependencies, and configures the build. Maven handles downloads automatically — you never manually fetch JARs.</p>

    <h3>Core</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Dependency</th><th>Why it is here</th></tr></thead>
        <tbody>
          <tr><td>spring-boot-starter-web</td><td>REST API support — routing, HTTP handling, JSON conversion</td></tr>
          <tr><td>spring-boot-starter-data-jpa</td><td>Talk to the database using Java objects instead of raw SQL</td></tr>
          <tr><td>spring-boot-starter-security</td><td>Authentication, authorization, password encoding</td></tr>
          <tr><td>spring-boot-starter-validation</td><td>Validates request bodies (@NotNull, @Email, etc.)</td></tr>
          <tr><td>spring-boot-starter-websocket</td><td>Real-time bidirectional communication for live location tracking</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Database &amp; Cache</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Dependency</th><th>Why it is here</th></tr></thead>
        <tbody>
          <tr><td>postgresql</td><td>The JDBC driver — lets Java talk to PostgreSQL</td></tr>
          <tr><td>spring-boot-starter-data-redis</td><td>Connects to Redis for caching driver locations, OTPs, and token blacklists</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Security &amp; Auth</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Dependency</th><th>Why it is here</th></tr></thead>
        <tbody>
          <tr><td>jjwt-api</td><td>JWT library for creating and validating JSON Web Tokens</td></tr>
          <tr><td>jjwt-impl</td><td>JWT implementation layer</td></tr>
          <tr><td>jjwt-jackson</td><td>JWT + JSON serialization</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Developer Experience</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Dependency</th><th>Why it is here</th></tr></thead>
        <tbody>
          <tr><td>lombok</td><td>Removes boilerplate — auto-generates getters, setters, constructors via annotations</td></tr>
          <tr><td>mapstruct</td><td>Auto-generates code to convert between Entity and DTO</td></tr>
          <tr><td>springdoc-openapi-starter-webmvc-ui</td><td>Auto-generates Swagger UI at /swagger-ui.html</td></tr>
          <tr><td>spring-boot-starter-actuator</td><td>Health check endpoints useful for Docker and monitoring</td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- Structure -->
  <section id="structure">
    <h2>Project Structure</h2>
    <pre><code>ridex-backend/
├── src/main/java/com/ridex/
│   ├── RidexApplication.java            Entry point (like index.js)
│   │
│   ├── config/
│   │   ├── SecurityConfig.java          Who can access what endpoints
│   │   ├── RedisConfig.java             Redis connection setup
│   │   ├── WebSocketConfig.java         WebSocket setup
│   │   └── SwaggerConfig.java           API docs config
│   │
│   ├── controller/                      Route handlers (like Express routers)
│   │   ├── AuthController.java          /api/auth/**
│   │   ├── UserController.java          /api/users/**
│   │   ├── DriverController.java        /api/drivers/**
│   │   ├── BookingController.java       /api/bookings/**
│   │   └── LocationController.java      /api/locations/**
│   │
│   ├── service/                         Business logic layer
│   │   ├── AuthService.java
│   │   ├── UserService.java
│   │   ├── DriverService.java
│   │   ├── BookingService.java
│   │   ├── FareService.java
│   │   └── LocationService.java
│   │
│   ├── repository/                      Database access layer
│   │   ├── UserRepository.java
│   │   ├── DriverRepository.java
│   │   └── BookingRepository.java
│   │
│   ├── entity/                          DB table models (like Mongoose schemas)
│   │   ├── User.java
│   │   ├── Driver.java
│   │   ├── Booking.java
│   │   └── Location.java
│   │
│   ├── dto/
│   │   ├── request/                     What the client sends
│   │   │   ├── LoginRequest.java
│   │   │   ├── RegisterRequest.java
│   │   │   └── BookingRequest.java
│   │   └── response/                    What the server returns
│   │       ├── AuthResponse.java
│   │       ├── BookingResponse.java
│   │       └── FareResponse.java
│   │
│   ├── security/
│   │   ├── JwtTokenProvider.java        Creates and validates JWT tokens
│   │   ├── JwtAuthFilter.java           Intercepts every request to check token
│   │   └── CustomUserDetailsService.java
│   │
│   ├── enums/
│   │   ├── BookingStatus.java           PENDING, ACCEPTED, IN_PROGRESS, COMPLETED, CANCELLED
│   │   ├── DriverStatus.java            ONLINE, OFFLINE, ON_TRIP
│   │   └── Role.java                    RIDER, DRIVER, ADMIN
│   │
│   ├── exception/
│   │   ├── GlobalExceptionHandler.java  Catches all errors app-wide
│   │   ├── ResourceNotFoundException.java
│   │   └── UnauthorizedException.java
│   │
│   └── websocket/
│       ├── LocationWebSocketHandler.java
│       └── LocationMessage.java
│
└── resources/
    ├── application.yml                  Main config (like .env but structured)
    ├── application-dev.yml
    └── application-prod.yml</code></pre>

    <h3>What is a DTO?</h3>
    <p>An <strong>Entity</strong> is the actual database row — it contains all fields including sensitive ones like passwords. A <strong>DTO (Data Transfer Object)</strong> is a stripped-down version used to send and receive data safely.</p>
    <p>For example, your <code>User</code> entity has a <code>password</code> field. You never send that in a response. So <code>UserResponse</code> DTO contains everything except the password. The flow looks like this:</p>
    <pre><code>Client sends RegisterRequest
  → Controller
  → Service
  → Entity saved to DB

DB Entity
  → Service
  → UserResponse DTO
  → Controller sends to Client</code></pre>
  </section>

  <!-- Auth -->
  <section id="auth">
    <h2>Authentication</h2>
    <p>This app uses <strong>JWT (JSON Web Tokens)</strong> — stateless, no sessions stored on the server. When we split into microservices later, each service can independently verify a JWT without calling a central auth server.</p>

    <div class="flow">
      <div class="flow-step"><span class="flow-num">01</span><span class="flow-text">User sends <code>POST /api/auth/login</code> with email and password</span></div>
      <div class="flow-step"><span class="flow-num">02</span><span class="flow-text">Server verifies credentials against the database</span></div>
      <div class="flow-step"><span class="flow-num">03</span><span class="flow-text">Server creates a JWT token signed with a secret key</span></div>
      <div class="flow-step"><span class="flow-num">04</span><span class="flow-text">Server returns <code>{ accessToken, refreshToken }</code></span></div>
      <div class="flow-step"><span class="flow-num">05</span><span class="flow-text">Client stores the token and attaches it to every future request via <code>Authorization: Bearer &lt;token&gt;</code></span></div>
      <div class="flow-step"><span class="flow-num">06</span><span class="flow-text"><code>JwtAuthFilter</code> intercepts every request and validates the token</span></div>
      <div class="flow-step"><span class="flow-num">07</span><span class="flow-text">If valid, the request proceeds. If invalid, the server returns 401 Unauthorized.</span></div>
    </div>
  </section>

  <!-- Features -->
  <section id="features">
    <h2>Features</h2>

    <div class="cols">
      <div class="col-block">
        <h4>User Management</h4>
        <ul>
          <li>Register as rider or driver</li>
          <li>Login and logout</li>
          <li>Refresh access tokens</li>
          <li>Profile management</li>
        </ul>
      </div>
      <div class="col-block">
        <h4>Driver Management</h4>
        <ul>
          <li>Driver onboarding (vehicle, license)</li>
          <li>Toggle availability online / offline</li>
          <li>View earnings and trip history</li>
        </ul>
      </div>
      <div class="col-block">
        <h4>Fare Calculation</h4>
        <ul>
          <li>Base fare + per km + per minute</li>
          <li>Surge pricing during peak hours</li>
          <li>Fare estimate before booking</li>
        </ul>
      </div>
      <div class="col-block">
        <h4>Real-Time Location</h4>
        <ul>
          <li>WebSocket location updates</li>
          <li>Rider sees driver moving on map</li>
          <li>Redis caches driver positions</li>
        </ul>
      </div>
    </div>

    <h3>Ride Lifecycle</h3>
    <div class="status-row">
      <span class="status-pill">PENDING</span>
      <span class="status-arrow">→</span>
      <span class="status-pill">ACCEPTED</span>
      <span class="status-arrow">→</span>
      <span class="status-pill">DRIVER ARRIVED</span>
      <span class="status-arrow">→</span>
      <span class="status-pill">IN PROGRESS</span>
      <span class="status-arrow">→</span>
      <span class="status-pill">COMPLETED</span>
    </div>
    <p>Any state prior to IN PROGRESS can also transition to <span class="status-pill" style="display:inline;font-family:var(--font-mono);font-size:0.7rem;padding:0.15rem 0.5rem;border:1px solid var(--rule);background:var(--code-bg);">CANCELLED</span>.</p>
  </section>

  <!-- API -->
  <section id="api">
    <h2>API Endpoints</h2>

    <h3>Auth</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Method</th><th>Endpoint</th><th>Description</th></tr></thead>
        <tbody>
          <tr><td><span class="method post">POST</span>/api/auth/register</td><td>Register new user or driver</td></tr>
          <tr><td><span class="method post">POST</span>/api/auth/login</td><td>Login and receive tokens</td></tr>
          <tr><td><span class="method post">POST</span>/api/auth/refresh</td><td>Refresh access token</td></tr>
          <tr><td><span class="method post">POST</span>/api/auth/logout</td><td>Invalidate token</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Users</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Method</th><th>Endpoint</th><th>Description</th></tr></thead>
        <tbody>
          <tr><td><span class="method get">GET</span>/api/users/me</td><td>Get current user profile</td></tr>
          <tr><td><span class="method put">PUT</span>/api/users/me</td><td>Update profile</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Drivers</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Method</th><th>Endpoint</th><th>Description</th></tr></thead>
        <tbody>
          <tr><td><span class="method get">GET</span>/api/drivers/nearby</td><td>Get nearby available drivers</td></tr>
          <tr><td><span class="method put">PUT</span>/api/drivers/status</td><td>Toggle online / offline</td></tr>
          <tr><td><span class="method get">GET</span>/api/drivers/me/trips</td><td>Driver trip history</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Bookings</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Method</th><th>Endpoint</th><th>Description</th></tr></thead>
        <tbody>
          <tr><td><span class="method post">POST</span>/api/bookings</td><td>Request a ride</td></tr>
          <tr><td><span class="method get">GET</span>/api/bookings/:id</td><td>Get booking details</td></tr>
          <tr><td><span class="method put">PUT</span>/api/bookings/:id/accept</td><td>Driver accepts ride</td></tr>
          <tr><td><span class="method put">PUT</span>/api/bookings/:id/cancel</td><td>Cancel a booking</td></tr>
          <tr><td><span class="method get">GET</span>/api/bookings/fare-estimate</td><td>Get fare estimate</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Location — WebSocket</h3>
    <div class="table-wrap">
      <table>
        <thead><tr><th>Event</th><th>Description</th></tr></thead>
        <tbody>
          <tr><td>/ws/location</td><td>WebSocket endpoint for real-time updates</td></tr>
          <tr><td>DRIVER_LOCATION_UPDATE</td><td>Driver sends their coordinates</td></tr>
          <tr><td>RIDER_TRACKING</td><td>Rider receives driver location</td></tr>
        </tbody>
      </table>
    </div>
  </section>

  <!-- Schema -->
  <section id="schema">
    <h2>Database Schema</h2>

    <div class="schema-table">
      <div class="table-name">users</div>
      <div class="fields">
        <span class="pk">id</span>, name, email, password, phone,
        role, created_at
      </div>
    </div>

    <div class="schema-table">
      <div class="table-name">drivers</div>
      <div class="fields">
        <span class="pk">id</span>, <span class="fk">user_id</span>,
        license_number, vehicle_make, vehicle_model,
        vehicle_plate, status, rating, total_trips
      </div>
    </div>

    <div class="schema-table">
      <div class="table-name">bookings</div>
      <div class="fields">
        <span class="pk">id</span>, <span class="fk">rider_id</span>,
        <span class="fk">driver_id</span>, pickup_lat, pickup_lng,
        dropoff_lat, dropoff_lng, status, fare,
        distance_km, requested_at, started_at, completed_at
      </div>
    </div>

    <div class="schema-table">
      <div class="table-name">locations</div>
      <div class="fields">
        <span class="pk">id</span>, <span class="fk">driver_id</span>,
        latitude, longitude, recorded_at
      </div>
    </div>

    <h3>Architecture Layers</h3>

    <div class="arch">
      <div class="arch-layer">
        <span class="arch-label">Incoming</span>
        <span class="arch-name">HTTP Request</span>
      </div>
      <div class="arch-arrow">↓</div>
      <div class="arch-layer">
        <span class="arch-label">Controller</span>
        <span class="arch-name">Route handler</span>
        <span class="arch-desc">Receives request, validates input, calls service</span>
      </div>
      <div class="arch-arrow">↓</div>
      <div class="arch-layer">
        <span class="arch-label">Service</span>
        <span class="arch-name">Business logic</span>
        <span class="arch-desc">All logic lives here, calls repository</span>
      </div>
      <div class="arch-arrow">↓</div>
      <div class="arch-layer">
        <span class="arch-label">Repository</span>
        <span class="arch-name">Data access</span>
        <span class="arch-desc">Talks to the database, nothing else</span>
      </div>
      <div class="arch-arrow">↓</div>
      <div class="arch-layer">
        <span class="arch-label">Persistence</span>
        <span class="arch-name">PostgreSQL + Redis</span>
      </div>
    </div>
  </section>

  <!-- Getting Started -->
  <section id="start">
    <h2>Getting Started</h2>
    <p>Make sure you have Java 17+, Maven 3.8+, and Docker Desktop installed. IntelliJ IDEA is recommended.</p>

    <div class="step">
      <span class="step-num">1</span>
      <div class="step-content">
        <h4>Clone the repository</h4>
        <pre><code>git clone https://github.com/yourusername/ridex.git
cd ridex</code></pre>
      </div>
    </div>

    <div class="step">
      <span class="step-num">2</span>
      <div class="step-content">
        <h4>Set up environment variables</h4>
        <pre><code>cp .env.example .env
# Edit .env with your values</code></pre>
      </div>
    </div>

    <div class="step">
      <span class="step-num">3</span>
      <div class="step-content">
        <h4>Start infrastructure</h4>
        <p>Spins up PostgreSQL on port 5432 and Redis on port 6379. No manual installation required.</p>
        <pre><code>docker-compose up -d postgres redis</code></pre>
      </div>
    </div>

    <div class="step">
      <span class="step-num">4</span>
      <div class="step-content">
        <h4>Run the application</h4>
        <pre><code>./mvnw spring-boot:run</code></pre>
        <p>Or open in IntelliJ IDEA and click the green Run button.</p>
      </div>
    </div>

    <div class="step">
      <span class="step-num">5</span>
      <div class="step-content">
        <h4>Verify</h4>
        <p>Swagger UI — <a href="http://localhost:8080/swagger-ui.html">localhost:8080/swagger-ui.html</a></p>
        <p>Health Check — <a href="http://localhost:8080/actuator/health">localhost:8080/actuator/health</a></p>
      </div>
    </div>

    <h3>Full Docker stack</h3>
    <pre><code>docker-compose up --build</code></pre>

    <h3>Environment variables reference</h3>
    <div class="env-block">
      <span class="comment"># Database</span><br>
      <span class="key">DB_URL</span>=<span class="val">jdbc:postgresql://localhost:5432/ridex</span><br>
      <span class="key">DB_USERNAME</span>=<span class="val">ridex_user</span><br>
      <span class="key">DB_PASSWORD</span>=<span class="val">your_password</span><br>
      <br>
      <span class="comment"># JWT</span><br>
      <span class="key">JWT_SECRET</span>=<span class="val">your_super_secret_key_here</span><br>
      <span class="key">JWT_EXPIRATION_MS</span>=<span class="val">86400000</span><br>
      <span class="key">JWT_REFRESH_EXPIRATION_MS</span>=<span class="val">604800000</span><br>
      <br>
      <span class="comment"># Redis</span><br>
      <span class="key">REDIS_HOST</span>=<span class="val">localhost</span><br>
      <span class="key">REDIS_PORT</span>=<span class="val">6379</span><br>
      <br>
      <span class="comment"># App</span><br>
      <span class="key">SERVER_PORT</span>=<span class="val">8080</span><br>
      <span class="key">SPRING_PROFILES_ACTIVE</span>=<span class="val">dev</span>
    </div>
  </section>

  <!-- Future -->
  <section id="future">
    <h2>Microservices Roadmap</h2>
    <p>When ready to decompose, this monolith splits cleanly. Services will communicate via REST for synchronous calls and Kafka or RabbitMQ for asynchronous events.</p>

    <div class="table-wrap">
      <table>
        <thead><tr><th>Service</th><th>Extracted from</th></tr></thead>
        <tbody>
          <tr><td>user-service</td><td>UserController, UserService, UserRepository, User entity</td></tr>
          <tr><td>driver-service</td><td>DriverController, DriverService, DriverRepository, Driver entity</td></tr>
          <tr><td>booking-service</td><td>BookingController, BookingService, BookingRepository, Booking entity</td></tr>
          <tr><td>pricing-service</td><td>FareService, FareResponse</td></tr>
          <tr><td>location-service</td><td>LocationController, LocationService, websocket/</td></tr>
          <tr><td>auth-service</td><td>AuthController, AuthService, security/</td></tr>
        </tbody>
      </table>
    </div>

    <h3>Learning Resources</h3>
    <p>
      <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/" target="_blank">Spring Boot Official Docs</a> —
      <a href="https://www.bezkoder.com/spring-boot-jwt-authentication/" target="_blank">Spring Security + JWT Guide</a> —
      <a href="https://spring.io/guides/gs/accessing-data-jpa/" target="_blank">Spring Data JPA</a> —
      <a href="https://spring.io/guides/gs/messaging-stomp-websocket/" target="_blank">WebSocket in Spring Boot</a> —
      <a href="https://docs.docker.com/compose/" target="_blank">Docker Compose</a>
    </p>
  </section>

  <footer>
    <div>
      <div class="footer-title">Ride<em>x</em></div>
      <p style="margin-top:0.5rem;font-size:0.8rem;">Monolith today, microservices tomorrow.</p>
    </div>
    <div class="footer-meta">
      saadhtiwana &amp; abdullahxdev<br>
      Spring Boot 3.4.5 — MIT License<br>
      Contributions welcome via pull request
    </div>
  </footer>

</div>

</body>
</html>
