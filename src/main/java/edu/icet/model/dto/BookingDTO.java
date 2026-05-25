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

    private Long bookingID;

    private Long userID;

    private Long carID;

    private LocalDate startDate;

    private LocalDate endDate;

    private double totalPrice;

    private String bookingStatus;

}
