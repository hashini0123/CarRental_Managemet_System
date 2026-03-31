package edu.icet.service.Impl;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.repository.PaymentRepository;
import edu.icet.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) {
         return paymentRepository.addPayment(paymentDTO);
    }

    @Override
    public boolean updatePayment(PaymentDTO paymentDTO) {
        return paymentRepository.updtePayment(paymentDTO);
    }

    @Override
    public boolean deleteById(String id) {
        return paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentDTO> getAll() {
        return paymentRepository.getAll();
    }
}
