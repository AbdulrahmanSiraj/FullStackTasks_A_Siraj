package com.vehiclesSystem.vehiclesSystem.service;

import com.vehiclesSystem.dao.VehicleDao;
import com.vehiclesSystem.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements VehicleService<Plane> {

    private final VehicleDao<Plane> planeDao;

    @Autowired
    public PlaneServiceImpl(VehicleDao<Plane> planeDao) {
        this.planeDao = planeDao;
    }

    @Override
    public void save(Plane vehicle) { planeDao.save(vehicle); }

    @Override
    public void update(Plane vehicle) { planeDao.update(vehicle); }

    @Override
    public void delete(String id) { planeDao.delete(id); }

    @Override
    public Plane findById(String id) { return planeDao.searchById(id); }

    @Override
    public List<Plane> getAll() { return planeDao.getAll(); }
}
