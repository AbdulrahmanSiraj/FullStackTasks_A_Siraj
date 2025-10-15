package com.vehiclesSystem.vehiclesSystem.dao;

import com.vehiclesSystem.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaneDaoImpl implements VehicleDao<Plane> {

    private final DatabaseOperations dbOps;

    @Autowired
    public PlaneDaoImpl(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    @Override
    public void save(Plane vehicle) {
        dbOps.save(vehicle);
    }

    @Override
    public void update(Plane vehicle) {
        dbOps.update(vehicle);
    }

    @Override
    public void delete(String id) {
        dbOps.delete(Plane.class, id);
    }

    @Override
    public Plane searchById(String id) {
        return (Plane) dbOps.searchById(Plane.class, id);
    }

    @Override
    public List<Plane> getAll() {
        return (List<Plane>) (List<?>) dbOps.getAllVehicles(Plane.class);
    }
}
