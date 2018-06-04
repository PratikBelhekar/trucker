package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Location;
import com.pd.ennate.api.exception.ResourceNotFoundException;
import com.pd.ennate.api.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is implimentation for location Service.
 */

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    //fetch and returns list of Vehicle containing Location for given VIN

    @Override
    @Transactional(readOnly = true)
    public List<Location> findLocation(String vin) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -30 );
        Date date = cal.getTime();
        //return locationRepository.findAllByVinAndLocationTimestampGreaterThan(vin,date);
        List<Location> result = locationRepository.findAllByVin(vin);
        if(result.isEmpty())
            throw new ResourceNotFoundException("Location not Found for vin"+ vin);
        List<Location> finalResult = new ArrayList<>();
        for(Location l:result){
            if (date.after(l.getLocationTimestamp())){
                finalResult.add(l);
            }
        }
        return finalResult;
    }
}
