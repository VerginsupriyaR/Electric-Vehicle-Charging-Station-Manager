CREATE TABLE charging_session (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_number VARCHAR(20),
    station_name VARCHAR(50),
    units_consumed DOUBLE,
    total_cost DOUBLE,
    charging_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
