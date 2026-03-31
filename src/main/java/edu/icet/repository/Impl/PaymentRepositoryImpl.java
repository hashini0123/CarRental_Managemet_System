package edu.icet.repository.Impl;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.repository.PaymentRepository;

import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public boolean addPayment(PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean updtePayment(PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public List<PaymentDTO> getAll() {
        return List.of();
    }
}
