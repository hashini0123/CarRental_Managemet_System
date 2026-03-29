package edu.icet.controller;

import edu.icet.model.dto.BookingDTO;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public boolean addBook(@RequestBody BookingDTO bookingDTO){
        return bookingService.addBook(bookingDTO);
    }

    @PutMapping("/update")
    public boolean updateBook(@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBook(bookingDTO);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public boolean deleteBook(@PathVariable String id){
        return bookingService.deleteById(id);
    }

    @GetMapping("/get")
    public List<BookingDTO> getAll(){
        return bookingService.getAll();
    }
}
