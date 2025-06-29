# 🏨 Hotel Reservation System

A modern, object-oriented Java application for managing hotel room bookings, user accounts, and additional services. Built as a technical test solution, this project demonstrates clean architecture, robust validation, and full compliance with requirements.

---

## 🚀 Features
- **Room Type Management:** Supports `STANDARD_SUITE`, `JUNIOR_SUITE`, and `MASTER_SUITE`.
- **Booking Validation:** Ensures valid dates, room availability, and sufficient user balance.
- **Data Persistence:** Utilizes in-memory `ArrayList` collections for all entities.
- **Output Ordering:** Displays bookings in latest-first order.
- **Price Change Safety:** Existing bookings retain original prices even after room price updates.
- **Service Management:** Add and manage extra hotel services.

---

## 🛠️ Technologies Used
- **Java 17+**
- Standard Java Collections (no external dependencies)

---

## 📦 Getting Started

### Prerequisites
- Java JDK 17 or higher 
- Git (for cloning the repository)

### Setup & Run
```bash
# 1. Clone the repository
git clone https://github.com/hamza05628/hotel-reservation.git
cd hotel-reservation

# 2. Compile the project
javac src/*.java -d out/

# 3. Run the application
java -cp out Main
```

---

## ✅ Requirement Compliance
| Feature                | Status           | Details                                                      |
|------------------------|------------------|--------------------------------------------------------------|
| Room Type Management   | ✔️ Implemented   | Multiple room types supported                                |
| Booking Validation     | ✔️ Implemented   | Date logic, availability, user balance checks                |
| Data Persistence       | ✔️ Implemented   | Uses `ArrayList` as required                                 |
| Output Ordering        | ✔️ Implemented   | `printAll()` shows latest-first                              |
| Price Change Safety    | ✔️ Implemented   | Bookings retain original prices                              |

---

## 💡 Design Notes
- **Single-Service Architecture:** Chosen for simplicity and test scope.
- **Immutable Bookings:** Bookings snapshot prices to preserve historical accuracy.
- **Bonus Answers:** See code comments for detailed explanations.

---

## 👤 Author
- Hamza (Skypay Technical Test 2)

---


