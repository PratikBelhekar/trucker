package com.pd.ennate.api.controller;

import com.pd.ennate.api.entity.VehicleReading;
import com.pd.ennate.api.service.VehicleReadingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is Vehicle Rading Controller for mapping requests to REST end points.
 */

@RestController
@ResponseBody
@RequestMapping(value = "readings")
@Api(tags = "vehicles")
public class VehicleReadingController {

    @Autowired
    VehicleReadingService vehicleReadingService;

    @CrossOrigin(origins={"http://mocker.egen.io"},maxAge=4800)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Insert payload", notes = "Gets data from mocker.egen.io and stores it in database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public void create(@RequestBody VehicleReading vehicleReadings){
        vehicleReadingService.create(vehicleReadings);
    }

}
