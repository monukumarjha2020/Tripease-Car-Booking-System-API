package com.example.carbooking.service;

import com.example.carbooking.dto.CarDTO;
import com.example.carbooking.entity.Car;
import com.example.carbooking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    private CarDTO mapToDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .make(car.getMake())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .seats(car.getSeats())
                .available(car.isAvailable())
                .build();
    }

    private Car mapToEntity(CarDTO dto) {
        return Car.builder()
                .id(dto.getId())
                .make(dto.getMake())
                .model(dto.getModel())
                .year(dto.getYear())
                .price(dto.getPrice())
                .seats(dto.getSeats())
                .available(dto.isAvailable())
                .build();
    }

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CarDTO getCarById(Long id) {
        return carRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car saved = carRepository.save(mapToEntity(carDTO));
        return mapToDTO(saved);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}