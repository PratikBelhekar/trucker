package com.pd.ennate.api.repository;

import com.pd.ennate.api.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}