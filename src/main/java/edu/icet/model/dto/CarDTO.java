package edu.icet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDTO {
    private String carId;

    private String model;

    private String brand;

    private String fuelType;

    private int seatingCapacity;

    private double dailyRate;

    private String status;


}
