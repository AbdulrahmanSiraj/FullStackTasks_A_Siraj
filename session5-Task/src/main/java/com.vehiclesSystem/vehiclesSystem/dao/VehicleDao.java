package com.vehiclesSystem.vehiclesSystem.dao;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleDao<T extends Vehicle> {
    void save(T vehicle);
    void update(T vehicle);
    void delete(String id);
    T searchById(String id);
    List<T> getAll();
}
