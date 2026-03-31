package edu.icet.service;

import edu.icet.model.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    boolean addPayment(PaymentDTO paymentDTO);

    boolean updatePayment(PaymentDTO paymentDTO);

    boolean deleteById(String id);

    List<PaymentDTO> getAll();
}
