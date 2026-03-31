package edu.icet.repository.Impl;

import edu.icet.model.dto.BookingDTO;
import edu.icet.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addBook(BookingDTO bookingDTO) {
        String sql ="INSERT INTO bookings VALUE (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                bookingDTO.getBookingID(),
                bookingDTO.getCustID(),
                bookingDTO.getCarID(),
                bookingDTO.getStartDate(),
                bookingDTO.getEndDate(),
                bookingDTO.getTotalPrice(),
                bookingDTO.getBookingStatus()
                )>0;
    }

    @Override
    public boolean updateBook(BookingDTO bookingDTO) {

       String sql = "UPDATE bookings SET custId=?, carId=?, startDate=?, endDate=?, totalPrice=?, bookingStatus=?, bookingId=?";
       return jdbcTemplate.update(sql,
               bookingDTO.getBookingID(),
               bookingDTO.getCustID(),
               bookingDTO.getCarID(),
               bookingDTO.getStartDate(),
               bookingDTO.getEndDate(),
               bookingDTO.getTotalPrice(),
               bookingDTO.getBookingStatus()
               )>0;
    }

    @Override
    public boolean deleteById(String id) {

        String sql  = "DELETE FROM bookings WHERE bookingId=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<BookingDTO> getAll() {
        return List.of();
    }
}
