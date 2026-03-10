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
public class PaymentDTO {

    private String paymentID;

    private String bookingID;

    private double amount;

    private LocalDate paymentDate;

    private String paymentMethod;

}
