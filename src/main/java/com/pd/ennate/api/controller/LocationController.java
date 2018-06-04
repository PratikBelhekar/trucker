package com.pd.ennate.api.controller;

import com.pd.ennate.api.entity.Location;
import com.pd.ennate.api.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is Location Controller for mapping requests to REST end points.
 */

@RestController
@ResponseBody
@RequestMapping(value="location")
@Api(tags = "location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(method = RequestMethod.GET, value="{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle's Location for last 30 mins ", notes = "Returns a list of location for vehicle to be displayed on map")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<Location> fetchLocation(@PathVariable("vin") String vin){
        return locationService.findLocation(vin);
    }
}
