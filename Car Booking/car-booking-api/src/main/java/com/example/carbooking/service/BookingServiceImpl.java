package com.example.carbooking.service;

import com.example.carbooking.dto.BookingDTO;
import com.example.carbooking.entity.Booking;
import com.example.carbooking.entity.Car;
import com.example.carbooking.repository.BookingRepository;
import com.example.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarRepository carRepository;

    private BookingDTO mapToDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .carId(booking.getCar().getId())
                .customerName(booking.getCustomerName())
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .build();
    }

    private Booking mapToEntity(BookingDTO dto) {
        Car car = carRepository.findById(dto.getCarId()).orElseThrow();
        return Booking.builder()
                .id(dto.getId())
                .car(car)
                .customerName(dto.getCustomerName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        return bookingRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    public BookingDTO createBooking(BookingDTO dto) {
        Booking saved = bookingRepository.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}