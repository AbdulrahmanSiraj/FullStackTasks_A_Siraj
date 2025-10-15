package com.vehiclesSystem.vehiclesSystem.controller;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController {

    private final VehicleService<Car> carService;

    @Autowired
    public CarController(VehicleService<Car> carService) {
        this.carService = carService;
    }

    public void saveVehicle(Car car) {
        carService.save(car);
        System.out.println("Controller: requested save " + car);
    }

    public void deleteVehicle(String id) {
        carService.delete(id);
        System.out.println("Controller: requested delete for id " + id);
    }

    public Car findVehicle(String id) {
        Car car = carService.findById(id);
        System.out.println("Controller: requested find for id " + id + " -> " + car);
        return car;
    }

    public List<Car> listAllVehicles() {
        List<Car> cars = carService.getAll();
        System.out.println("Controller: requested listAll -> " + cars.size() + " cars found");
        return cars;
    }
}
