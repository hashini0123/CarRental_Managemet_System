INSERT INTO users (name, email, password, role)
VALUES
('Admin User', 'admin@car.com', '123456', 'ADMIN'),
('Hashini', 'hashini@gmail.com', '123456', 'CUSTOMER');

INSERT INTO cars (brand, model, fuel_type, seating_capacity, price_per_day, status)
VALUES
('Toyota', 'Prius', 'Hybrid', 5, 12000.00, 'AVAILABLE'),
('Honda', 'Civic', 'Petrol', 5, 10000.00, 'AVAILABLE'),
('Suzuki', 'Alto', 'Petrol', 4, 7000.00, 'AVAILABLE');

INSERT INTO bookings (user_id, car_id, start_date, end_date, total_price, booking_status)
VALUES
(2, 1, '2026-03-15', '2026-03-18', 36000.00, 'CONFIRMED');

INSERT INTO payments (booking_id, amount, payment_status)
VALUES
(1, 36000.00, 'PAID');