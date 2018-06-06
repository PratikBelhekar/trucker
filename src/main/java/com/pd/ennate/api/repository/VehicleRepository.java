package com.pd.ennate.api.repository;

import com.pd.ennate.api.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Vehicle Repository.
 */

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}