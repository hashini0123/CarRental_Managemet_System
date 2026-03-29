package edu.icet.service.Impl;

import edu.icet.model.dto.BookingDTO;
import edu.icet.repository.BookingRepository;
import edu.icet.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    public final BookingRepository bookingRepository;

    @Override
    public boolean addBook(BookingDTO bookingDTO) {
        return bookingRepository.addBook(bookingDTO);
    }

    @Override
    public boolean updateBook(BookingDTO bookingDTO) {
        return bookingRepository.updateBook(bookingDTO);
    }

    @Override
    public boolean deleteById(String id) {
        return bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingDTO> getAll() {
        return bookingRepository.getAll();
    }
}
