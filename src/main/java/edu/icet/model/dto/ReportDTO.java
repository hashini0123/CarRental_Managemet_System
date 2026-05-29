package edu.icet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDTO {

    private String reportType;

    private int totalBookings;

    private double totalRevenue;

    private double utilizationRate;

}