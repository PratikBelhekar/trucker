package com.pd.ennate.api.repository;

import com.pd.ennate.api.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Location Repository.
 */

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {
    List<Location> findAllByVin(String vin);
}
