package com.vehiclesSystem.vehiclesSystem.dao;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements VehicleDao<Car> {

    private final DatabaseOperations dbOps;

    @Autowired
    public CarDaoImpl(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    @Override
    public void save(Car vehicle) {
        dbOps.save(vehicle);
    }

    @Override
    public void update(Car vehicle) {
        dbOps.update(vehicle);
    }

    @Override
    public void delete(String id) {
        dbOps.delete(Car.class, id);
    }

    @Override
    public Car searchById(String id) {
        return (Car) dbOps.searchById(Car.class, id);
    }

    @Override
    public List<Car> getAll() {
        return (List<Car>) (List<?>) dbOps.getAllVehicles(Car.class);
    }
}
