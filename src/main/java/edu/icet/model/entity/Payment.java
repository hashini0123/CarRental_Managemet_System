package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private Booking booking;
}
