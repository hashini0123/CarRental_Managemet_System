package edu.icet.repository.Impl;

import edu.icet.model.dto.BookingDTO;
import edu.icet.repository.BookingRepository;

import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    @Override
    public boolean addBook(BookingDTO bookingDTO) {
        return false;
    }

    @Override
    public boolean updateBook(BookingDTO bookingDTO) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public List<BookingDTO> getAll() {
        return List.of();
    }
}
