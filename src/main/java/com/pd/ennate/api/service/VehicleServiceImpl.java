package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Vehicle;
import com.pd.ennate.api.exception.ResourceNotFoundException;
import com.pd.ennate.api.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional
    public void create(List<Vehicle> vehicles) {
        for(Vehicle v: vehicles)
            vehicleRepository.save(v);
    }

    @Transactional(readOnly = true)
    public Vehicle fetchById(String id) {
        Optional<Vehicle> existing = vehicleRepository.findById(id);
        if(!existing.isPresent())
            throw new ResourceNotFoundException("Vehicle with id"+ id + "doen't exist.");
        return existing.get();
    }

    @Transactional(readOnly = true)
    public Iterable<Vehicle> fetchAll() {
        return vehicleRepository.findAll();
    }
}
