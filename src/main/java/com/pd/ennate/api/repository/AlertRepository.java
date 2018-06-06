package com.pd.ennate.api.repository;

import com.pd.ennate.api.entity.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Alert Repository.
 */

@Repository
public interface AlertRepository extends CrudRepository<Alert, String>{
    List<Alert> findAlertsByVin(String vin);

    List<Alert> findAlertsByPriority(String priorityType);
}