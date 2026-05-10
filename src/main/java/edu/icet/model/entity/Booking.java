package edu.icet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private String bookingStatus;
    private User customer;
    private Car car;
}
