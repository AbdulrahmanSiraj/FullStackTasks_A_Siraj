package com.vehiclesSystem.vehiclesSystem.dao;

import com.vehiclesSystem.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BikeDaoImpl implements VehicleDao<Bike> {

    private final DatabaseOperations dbOps;

    @Autowired
    public BikeDaoImpl(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    @Override
    public void save(Bike vehicle) {
        dbOps.save(vehicle);
    }

    @Override
    public void update(Bike vehicle) {
        dbOps.update(vehicle);
    }

    @Override
    public void delete(String id) {
        dbOps.delete(Bike.class, id);
    }

    @Override
    public Bike searchById(String id) {
        return (Bike) dbOps.searchById(Bike.class, id);
    }

    @Override
    public List<Bike> getAll() {
        return (List<Bike>) (List<?>) dbOps.getAllVehicles(Bike.class);
    }
}
