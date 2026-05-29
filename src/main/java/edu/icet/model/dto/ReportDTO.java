package edu.icet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDTO {

    private Long id;
    private String reportType;
    private int generatedBy;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalBookings;
    private double totalRevenue;

}