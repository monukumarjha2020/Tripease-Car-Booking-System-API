package com.example.carbooking.controller;

import com.example.carbooking.dto.CarDTO;
import com.example.carbooking.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.getAllCars();
    }

    @GetMapping("/<built-in function id>")
    public CarDTO getById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public CarDTO create(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}