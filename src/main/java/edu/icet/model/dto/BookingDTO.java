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
public class BookingDTO {

    private Long id;

    private Long userId;

    private Long carId;

    private LocalDate start_date;

    private LocalDate end_date;

    private double total_price;

    private String booking_status;

}
