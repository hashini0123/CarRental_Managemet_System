package edu.icet.repository;

import edu.icet.model.dto.PaymentDTO;

import java.util.List;

public interface PaymentRepository {
    boolean addPayment(PaymentDTO paymentDTO);

    boolean updtePayment(PaymentDTO paymentDTO);

    boolean deleteById(String id);

    List<PaymentDTO> getAll();
}
