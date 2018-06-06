package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Alert;
import com.pd.ennate.api.exception.ResourceNotFoundException;
import com.pd.ennate.api.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is Implimentation for Alert Service.
 */

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    //Fetch and returns list of Alert for given VIN
    @Override
    public List<Alert> getAlertForVehicle(String vin) {
        return alertRepository.findAlertsByVin(vin);
    }

    //Fetch and returns List of Vehicles with High Alert within last 2 hours
    @Override
    @Transactional(readOnly = true)
    public List<Alert> getAlertForLastTwoHours(String priorityType) {

        List<Alert> finalResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, - 2);
        Date date = cal.getTime();
        List<Alert> result = alertRepository.findAlertsByPriority(priorityType);
        if(result.isEmpty())
            throw new ResourceNotFoundException("No Record Found with High Priority");
        for (Alert a:result){
            if (date.after(a.getAlertTimeStamp())){
                finalResult.add(a);
            }
        }
        return finalResult;
    }
}