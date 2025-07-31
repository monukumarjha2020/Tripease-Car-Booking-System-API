package com.example.carbooking.controller;

import com.example.carbooking.dto.BookingDTO;
import com.example.carbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/<built-in function id>")
    public BookingDTO getById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public BookingDTO create(@RequestBody BookingDTO dto) {
        return bookingService.createBooking(dto);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}