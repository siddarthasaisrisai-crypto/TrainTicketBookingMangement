# Train Ticket Booking Management System (TTBMS)

Resume-aligned Spring Boot REST API project using Java 17, Spring Boot, Spring Data JPA/Hibernate, Maven, and MySQL.

## Architecture
`Postman/Client -> Controller -> Service -> DAO (Spring Data JPA) -> MySQL`

Packages:
- `config` – application configuration
- `controller` – REST API endpoints
- `dao` – database access interfaces
- `dto` – validated request objects
- `exception` – consistent API error handling
- `model` – JPA entities
- `service` – booking, seat availability, and cancellation logic
- `util` – optional shared utilities

## Run
1. Install JDK 17+, Maven, and MySQL 8+.
2. Create database: `CREATE DATABASE train_booking;`
3. Set environment variables `DB_USERNAME` and `DB_PASSWORD`, or change credentials in `application.properties`.
4. Run `mvn spring-boot:run`.

## API
- `POST /api/trains` — add a train
- `GET /api/trains` — list trains
- `GET /api/trains/{id}` — get one train
- `POST /api/reservations` — reserve seats
- `GET /api/reservations` — list reservations
- `DELETE /api/reservations/{id}` — cancel a reservation

This is an educational portfolio project. Before production use, add authentication/authorization, database migrations, integration tests, and row-level locking or another concurrency strategy for simultaneous seat bookings.
