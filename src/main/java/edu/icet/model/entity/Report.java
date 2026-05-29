package edu.icet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String reportType;
    private int totalBookings;
    private double totalRevenue;
    private double utilizationRate;
}
