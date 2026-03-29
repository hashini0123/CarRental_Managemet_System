package edu.icet.repository;

import edu.icet.model.dto.BookingDTO;

import java.util.List;

public interface BookingRepository {
    boolean addBook(BookingDTO bookingDTO);

    boolean updateBook(BookingDTO bookingDTO);

    boolean deleteById(String id);

    List<BookingDTO> getAll();
}
