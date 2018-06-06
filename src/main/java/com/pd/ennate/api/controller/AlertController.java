package com.pd.ennate.api.controller;

import com.pd.ennate.api.entity.Alert;
import com.pd.ennate.api.service.AlertService;
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
 *	This is Alert Controller for mapping requests to REST end points.
 */

@RestController
@ResponseBody
@RequestMapping(value = "alert")
@Api(tags = "alert")
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET, value="{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Vehicle's Historical Alert ", notes = "Returns a list of alert for vehicle")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<Alert> findAlertForVehicle(@PathVariable("vin") String vin){
        return alertService.getAlertForVehicle(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value="high", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All High Alerts Within Last 2 hours", notes = "Returns a list of vehicles with high alert")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal Server Error"), })
    public List<Alert> findAlertForLastTwoHours(){
        return alertService.getAlertForLastTwoHours("High");
    }
}
