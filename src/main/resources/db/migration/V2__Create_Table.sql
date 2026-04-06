CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    fuel_type VARCHAR(50),
    seating_capacity INT,
    price_per_day DECIMAL(10,2),
    status VARCHAR(50) DEFAULT 'AVAILABLE'
);

CREATE TABLE bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    car_id BIGINT,
    start_date DATE,
    end_date DATE,
    total_price DECIMAL(10,2),
    booking_status VARCHAR(50) DEFAULT 'PENDING',

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_car
        FOREIGN KEY (car_id)
        REFERENCES cars(id)
        ON DELETE CASCADE
);

CREATE TABLE payments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_id BIGINT,
    amount DECIMAL(10,2),
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_status VARCHAR(50),

    CONSTRAINT fk_booking
        FOREIGN KEY (booking_id)
        REFERENCES bookings(id)
        ON DELETE CASCADE
);

CREATE TABLE reports (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    report_type VARCHAR(100) NOT NULL,
    generated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    generated_by BIGINT,
    start_date DATE,
    end_date DATE,
    total_bookings INT DEFAULT 0,
    total_revenue DECIMAL(10,2) DEFAULT 0.00,
    report_status VARCHAR(50) DEFAULT 'GENERATED',

    CONSTRAINT fk_report_user
        FOREIGN KEY (generated_by)
        REFERENCES users(id)
        ON DELETE SET NULL
);