package com.vehiclesSystem.vehiclesSystem.service;

import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements VehicleService<Bike> {

    private final VehicleDao<Bike> bikeDao;

    @Autowired
    public BikeServiceImpl(VehicleDao<Bike> bikeDao) {
        this.bikeDao = bikeDao;
    }

    @Override
    public void save(Bike vehicle) { bikeDao.save(vehicle); }

    @Override
    public void update(Bike vehicle) { bikeDao.update(vehicle); }

    @Override
    public void delete(String id) { bikeDao.delete(id); }

    @Override
    public Bike findById(String id) { return bikeDao.searchById(id); }

    @Override
    public List<Bike> getAll() { return bikeDao.getAll(); }
}
