package edu.icet.repository.Impl;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addPayment(PaymentDTO paymentDTO) {
        String sql = "INSERT INTO payments VALUE (?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                paymentDTO.getPaymentID(),
                paymentDTO.getBookingID(),
                paymentDTO.getAmount(),
                paymentDTO.getPaymentDate(),
                paymentDTO.getPaymentMethod()
                )>0;
    }

    @Override
    public boolean updtePayment(PaymentDTO paymentDTO) {
        String sql = "UPDATE payments SET bookingId=?, amount=?, paymentDate=?, paymentMehod=? WHERE paymentId=?";
        return jdbcTemplate.update(sql,
                paymentDTO.getPaymentID(),
                paymentDTO.getBookingID(),
                paymentDTO.getAmount(),
                paymentDTO.getPaymentDate(),
                paymentDTO.getPaymentMethod()
                )>0;
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM payments WHERE paymentId=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<PaymentDTO> getAll() {
        return List.of();
    }
}
