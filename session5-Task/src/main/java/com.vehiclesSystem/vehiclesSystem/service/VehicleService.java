package com.vehiclesSystem.vehiclesSystem.service;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleService<T extends Vehicle> {
    void save(T vehicle);
    void update(T vehicle);
    void delete(String id);
    T findById(String id);
    List<T> getAll();
}
