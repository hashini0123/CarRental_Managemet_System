package edu.icet.repository.Impl;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.model.dto.UserDTO;
import edu.icet.repository.PaymentRepository;
import edu.icet.repository.UserRepository;
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
        String sql = "UPDATE payments SET booking_id=?, amount=?, paymentDate=?, paymentMethod=? WHERE payment_id=?";
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

            paymentDTO.setPaymentID(rs.getLong(1));
            paymentDTO.setBookingID(rs.getLong(2));
            paymentDTO.setAmount(Double.parseDouble(rs.getString(3)));
            paymentDTO.setPaymentDate(LocalDate.parse(rs.getString(4)));
            paymentDTO.setPaymentMethod(rs.getString(5));
            return paymentDTO;
        });
        return paymentDTOList;
    }

    @RequiredArgsConstructor
    @Repository
    public static class UserRepositoryImpl implements UserRepository {

        private final JdbcTemplate jdbcTemplate;

        @Override
        public boolean addUser(UserDTO userDTO) {
            String sql = "INSERT INTO users VALUES(?,?,?,?,?,?)";
               return jdbcTemplate.update(sql,
                       userDTO.getUserID(),
                       userDTO.getUserName(),
                       userDTO.getEmail(),
                       userDTO.getPassword(),
                       userDTO.getRole(),
                       userDTO.getCreated_at()
                ) > 0;
        }


        @Override
        public boolean updateUser(UserDTO userDTO) {

            String sql = "UPDATE user SET userName=?, email=?, password=?, role=? created_at=? WHERE user_id=?";

            return jdbcTemplate.update(sql,
                    userDTO.getUserID(),
                    userDTO.getUserName(),
                    userDTO.getEmail(),
                    userDTO.getPassword(),
                    userDTO.getRole(),
                    userDTO.getCreated_at()
            )>0;
        }

        @Override
        public boolean deleteByID(String id) {

            String sql = "DELETE FROM users  WHERE user_id=? ";

            return jdbcTemplate.update(sql,id)>0;
        }

        @Override
        public List<UserDTO> getAll() {

            String sql = "SELECT * FROM users";

            List<UserDTO> userDTOList = jdbcTemplate.query(sql,(rs, rowNum) -> {

                UserDTO userDTO = new UserDTO();

                userDTO.setUserID(rs.getLong(1));
                userDTO.setUserName(rs.getString(2));
                userDTO.setEmail(rs.getString(3));
                userDTO.setPassword(rs.getInt(4));
                userDTO.setRole(rs.getString(5));
                userDTO.setCreated_at(rs.getString(6));
                return userDTO;
            });

            return userDTOList;
        }
    }
}
