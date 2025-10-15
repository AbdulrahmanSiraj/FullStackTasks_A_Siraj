package com.vehiclesSystem.vehiclesSystem.controller;

import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeController {

    private final VehicleService<Bike> bikeService;

    @Autowired
    public BikeController(VehicleService<Bike> bikeService) {
        this.bikeService = bikeService;
    }

    public void saveVehicle(Bike bike) {
        bikeService.save(bike);
        System.out.println("Controller: requested save " + bike);
    }

    public void deleteVehicle(String id) {
        bikeService.delete(id);
        System.out.println("Controller: requested delete for id " + id);
    }

    public Bike findVehicle(String id) {
        Bike bike = bikeService.findById(id);
        System.out.println("Controller: requested find for id " + id + " -> " + bike);
        return bike;
    }

    public List<Bike> listAllVehicles() {
        List<Bike> bikes = bikeService.getAll();
        System.out.println("Controller: requested listAll -> " + bikes.size() + " bikes found");
        return bikes;
    }
}
