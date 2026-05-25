package edu.icet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String model;
    private String brand;
    private String fuelType;
    private int seatingCapacity;
    private double dailyRate;
    private String status;
}
