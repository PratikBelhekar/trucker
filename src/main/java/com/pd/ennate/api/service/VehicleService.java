package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Vehicle;

import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Vehicle Service.
 */

public interface VehicleService {
    void create(List<Vehicle> vehicles);
    Vehicle fetchById(String id);
    Iterable<Vehicle> fetchAll();
}
