package com.example.carbooking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private Long id;
    private String make;
    private String model;
    private int year;
    private double price;
    private int seats;
    private boolean available;
}