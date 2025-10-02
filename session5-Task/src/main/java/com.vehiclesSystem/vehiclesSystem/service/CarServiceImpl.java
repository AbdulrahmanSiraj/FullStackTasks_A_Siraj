package com.vehiclesSystem.vehiclesSystem.service;

import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements VehicleService<Car> {

    private final VehicleDao<Car> carDao;

    @Autowired
    public CarServiceImpl(VehicleDao<Car> carDao) {
        this.carDao = carDao;
    }

    @Override
    public void save(Car vehicle) { carDao.save(vehicle); }

    @Override
    public void update(Car vehicle) { carDao.update(vehicle); }

    @Override
    public void delete(String id) { carDao.delete(id); }

    @Override
    public Car findById(String id) { return carDao.searchById(id); }

    @Override
    public List<Car> getAll() { return carDao.getAll(); }
}
