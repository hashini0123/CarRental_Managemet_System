package edu.icet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String reportType;
    private int generatedBy;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalBookings;
    private double totalRevenue;

}
