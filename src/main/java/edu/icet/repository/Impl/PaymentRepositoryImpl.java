package edu.icet.repository.Impl;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
        String sql = "SELECT * FROM payments";

        List<PaymentDTO> paymentDTOList = jdbcTemplate.query(sql, (rs, rowNum) -> {

            PaymentDTO  paymentDTO = new PaymentDTO();

            paymentDTO.setPaymentID(rs.getString(1));
            paymentDTO.setBookingID(rs.getString(2));
            paymentDTO.setAmount(Double.parseDouble(rs.getString(3)));
            paymentDTO.setPaymentDate(LocalDate.parse(rs.getString(4)));
            paymentDTO.setPaymentMethod(rs.getString(5));
            return paymentDTO;
        });
        return paymentDTOList;
    }
}
