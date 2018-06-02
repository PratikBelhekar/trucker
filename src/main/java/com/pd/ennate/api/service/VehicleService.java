package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    public void create(List<Vehicle> vehicles);
    public Vehicle fetchById(String id);
    public Iterable<Vehicle> fetchAll();
}
