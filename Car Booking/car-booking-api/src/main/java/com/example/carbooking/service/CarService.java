package com.example.carbooking.service;

import com.example.carbooking.dto.CarDTO;
import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    CarDTO getCarById(Long id);
    CarDTO createCar(CarDTO carDTO);
    void deleteCar(Long id);
}