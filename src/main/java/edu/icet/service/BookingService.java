package edu.icet.service;

import edu.icet.model.dto.BookingDTO;

import java.util.List;

public interface BookingService
{
    boolean addBook(BookingDTO bookingDTO);

    boolean updateBook(BookingDTO bookingDTO);

    boolean deleteById(String id);

    List<BookingDTO> getAll();
}
