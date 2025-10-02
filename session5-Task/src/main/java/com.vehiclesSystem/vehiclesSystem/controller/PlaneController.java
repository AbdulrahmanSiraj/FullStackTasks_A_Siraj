package com.vehiclesSystem.vehiclesSystem.controller;

import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaneController {

    private final VehicleService<Plane> planeService;

    @Autowired
    public PlaneController(VehicleService<Plane> planeService) {
        this.planeService = planeService;
    }

    public void saveVehicle(Plane plane) {
        planeService.save(plane);
        System.out.println("Controller: requested save " + plane);
    }

    public void deleteVehicle(String id) {
        planeService.delete(id);
        System.out.println("Controller: requested delete for id " + id);
    }

    public Plane findVehicle(String id) {
        Plane plane = planeService.findById(id);
        System.out.println("Controller: requested find for id " + id + " -> " + plane);
        return plane;
    }

    public List<Plane> listAllVehicles() {
        List<Plane> planes = planeService.getAll();
        System.out.println("Controller: requested listAll -> " + planes.size() + " planes found");
        return planes;
    }
}
