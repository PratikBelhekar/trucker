package com.pd.ennate.api.repository;

import com.pd.ennate.api.entity.VehicleReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for VehicleReading Repository.
 */

@Repository
public interface VehicelReadingRepository extends CrudRepository<VehicleReading, String> {

}
