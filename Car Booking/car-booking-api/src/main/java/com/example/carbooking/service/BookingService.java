package com.example.carbooking.service;

import com.example.carbooking.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    BookingDTO createBooking(BookingDTO bookingDTO);
    void deleteBooking(Long id);
}