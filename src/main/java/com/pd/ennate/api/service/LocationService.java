package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Location;
import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Location Service.
 */

public interface LocationService {
    List<Location> findLocation(String vin);
}
