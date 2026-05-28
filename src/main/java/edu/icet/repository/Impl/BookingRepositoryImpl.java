package edu.icet.repository.Impl;

import edu.icet.model.dto.BookingDTO;
import edu.icet.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addBook(BookingDTO bookingDTO) {
        String sql ="INSERT INTO bookings VALUE (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                bookingDTO.getId(),
                bookingDTO.getUserId(),
                bookingDTO.getCarId(),
                bookingDTO.getStart_date(),
                bookingDTO.getEnd_date(),
                bookingDTO.getTotal_price(),
                bookingDTO.getBooking_status()
                )>0;
    }

    @Override
    public boolean updateBook(BookingDTO bookingDTO) {

       String sql = "UPDATE bookings SET user_id=?, car_id=?, start_date=?, end_date=?, total_price=?, booking_status=? WHERE id=?";
       return jdbcTemplate.update(sql,
               bookingDTO.getUserId(),
               bookingDTO.getCarId(),
               bookingDTO.getStart_date(),
               bookingDTO.getEnd_date(),
               bookingDTO.getTotal_price(),
               bookingDTO.getBooking_status(),
               bookingDTO.getId()
               )>0;
    }

    @Override
    public boolean deleteById(String id) {

        String sql  = "DELETE FROM bookings WHERE id=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<BookingDTO> getAll() {

        String sql = "SELECT * FROM bookings";
        List<BookingDTO> bookingDTOList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setId(rs.getLong(1));
            bookingDTO.setUserId(rs.getLong(2));
            bookingDTO.setCarId(rs.getLong(3));
            bookingDTO.setStart_date(LocalDate.parse(rs.getString(4)));
            bookingDTO.setEnd_date(LocalDate.parse(rs.getString(5)));
            bookingDTO.setTotal_price(Double.parseDouble(rs.getString(6)));
            bookingDTO.setBooking_status(rs.getString(7));
            return bookingDTO;

        });
        return bookingDTOList;
    }

    @Override
    public boolean isCarAvailable(Long carId, LocalDate startDate, LocalDate endDate) {
       String sql = "SELECT * FROM bookings WHERE carId=? AND booking_status != 'CANCELLED' AND(start_date <= ? AND end_date >=?)";

       return jdbcTemplate.queryForObject(sql,
               Integer.class,
               carId,
               startDate,
               endDate
       )>0;

    }
}
