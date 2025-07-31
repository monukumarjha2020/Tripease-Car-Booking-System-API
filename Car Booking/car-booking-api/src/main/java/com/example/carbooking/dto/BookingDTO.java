package com.example.carbooking.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private Long carId;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
}