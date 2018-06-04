package com.pd.ennate.api.controller;

import com.pd.ennate.api.entity.Vehicle;
import com.pd.ennate.api.service.VehicleService;
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
 *	This is Vehicle Controller for mapping requests to REST end points.
 */

@RestController
@ResponseBody
@RequestMapping(value = "vehicles")
@Api(tags = "vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @CrossOrigin(origins={"http://mocker.egen.io"},maxAge=4800)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Insert payload", notes = "Gets data from mocker.egen.io and stores it in database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public void create(@RequestBody List<Vehicle> vehicles){
        System.out.println("Inside vehicle"+ vehicles);
       vehicleService.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Fetch all Vehicles ", notes = "Returns a list of vehicles")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public Iterable<Vehicle> findAll(){
        return vehicleService.fetchAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Fetch Particular Vehicles for given VIN", notes = "Returns a vehicle for given VIN")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public Vehicle findById(@PathVariable("id") String id){
        return vehicleService.fetchById(id);
    }
}
