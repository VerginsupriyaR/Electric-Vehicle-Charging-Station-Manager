⚡ EV Charging Station Management System (JDBC Console Project)

A simple **Java + MySQL (JDBC)** based console application to manage EV charging sessions.
This project follows a layered architecture using **DTO, DAO, Service and Main (UI)** layers.

---

📌 Project Overview

This project helps to:

* Start a new EV charging session
* Store charging details in MySQL
* View a session by ID
* View all charging sessions
* Update session details
* Delete a session

The system also automatically calculates the total charging cost using a business rule.

---

🧱 Architecture Used

The project is implemented using:

* DTO (Data Transfer Object)
* DAO (Data Access Object)
* Service layer
* Console based UI

Flow:

```
Main → ChargingService → ChargingSessionDAO → MySQL Database
```

---

🛠️ Technologies Used

* Java
* JDBC
* MySQL
* Eclipse / IntelliJ
* Console based UI

---

📁 Package Structure

```
com.evcharging
│
├── Main.java
├── ChargingService.java
├── ChargingSessionDAO.java
├── ChargingSessionDAOImpl.java
└── ChargingSessionDTO.java
```

---

⚙️ Business Rule

```
Cost per unit = ₹15
Total Cost = Units Consumed × 15
```

---

🗄️ Database Details

Database Name

```
ev_charging
```

Table Creation

```sql
CREATE TABLE charging_session (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_number VARCHAR(20),
    station_name VARCHAR(50),
    units_consumed DOUBLE,
    total_cost DOUBLE,
    charging_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

🔧 Database Configuration

Update this section inside
`ChargingSessionDAOImpl.java` if your credentials are different:

```java
private static final String URL = "jdbc:mysql://localhost:3306/ev_charging";
private static final String USER = "root";
private static final String PASS = "root1";
```

---

▶️ How to Run the Project

1. Create database and table in MySQL.

2. Open the project in Eclipse / IntelliJ.

3. Make sure MySQL JDBC driver is added to your project.

4. Run:

```
Main.java
```

---

🖥️ Application Menu

When you run the project, you will see:

```
=== EV CHARGING STATION MANAGER ===
1. Start Charging Session
2. View Session by ID
3. View All Sessions
4. Update Session
5. Delete Session
6. Exit
```

---

✨ Features

* Add charging session
* Auto calculation of total cost
* Fetch session using ID
* View all sessions
* Update existing session
* Delete session
* Clean separation of layers (DAO, Service, DTO)

---

📄 Class Description

1. Main.java

Handles user input and displays menu options.

2. ChargingService.java

Contains business logic and cost calculation.

3. ChargingSessionDAO.java

Interface that defines database operations.

4. ChargingSessionDAOImpl.java

Implements JDBC logic for all CRUD operations.

5. ChargingSessionDTO.java

Model class used to transfer charging session data.

---

🧪 Sample Output

```
ID | Vehicle | Station | Units | Cost
1 | KA01AB1234 | City Station | 12.5 | ₹187.5
```

---

📌 Project Type

* Console based
* Java JDBC CRUD application
* Suitable for:

  * Mini Project
  * Database / JDBC lab project
  * Core Java project

---

🚀 Future Enhancements

* Add user login system
* Add charging station availability tracking
* Add reports (daily / monthly usage)
* Convert console app to web application (Spring Boot)

---

👨‍💻 Author

**Vergin Supriya**
CSE – 6th Semester
EV Charging Station Management System – Java JDBC Project
