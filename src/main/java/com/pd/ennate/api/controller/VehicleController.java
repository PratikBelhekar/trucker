package com.pd.ennate.api.controller;

import com.pd.ennate.api.entity.Vehicle;
import com.pd.ennate.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins="http://mocker.egen.io",allowCredentials="true",allowedHeaders="Access-Control-Allow-Origin,accept, origin,content-type, Access-Control-Request-Method",maxAge=4800)
@RestController
@ResponseBody
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @CrossOrigin(origins={"http://mocker.egen.io"},maxAge=4800)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody List<Vehicle> vehicles){
        System.out.println("Inside vehicle"+ vehicles);
       vehicleService.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Iterable<Vehicle> findAll(){
        return vehicleService.fetchAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findById(@PathVariable("id") String id){
        return vehicleService.fetchById(id);
    }
}
