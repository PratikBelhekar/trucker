package com.pd.ennate.api.service;

import com.pd.ennate.api.entity.Alert;
import com.pd.ennate.api.entity.Location;
import com.pd.ennate.api.entity.Vehicle;
import com.pd.ennate.api.entity.VehicleReading;
import com.pd.ennate.api.repository.AlertRepository;
import com.pd.ennate.api.repository.LocationRepository;
import com.pd.ennate.api.repository.VehicelReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is implimentation for Vehicle Reading Service.
 */

@Service
public class VehicleReadingServiceImpl implements VehicleReadingService {

    @Autowired
    VehicelReadingRepository vehicelReadingRepository;

    @Autowired
    AlertService alertService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    LocationRepository locationRepository;

    //Method to save vehicle readings and create alerts
    @Override
    @Transactional()
    public void create(VehicleReading vehicleReadings) {

            vehicelReadingRepository.save(vehicleReadings);
            //Create Alerts for Vehicle Readings
            createAlerts(vehicleReadings);
            //save Location
            saveLocations(vehicleReadings);
    }

    // Method th check readings and save alerts if condition is satisfied
    public void createAlerts(VehicleReading vehicleReading){

        Vehicle vehicle = vehicleService.fetchById(vehicleReading.getVin());
        if (vehicleReading.getEngineRpm() > vehicle.getRedlineRpm()) {
            saveAlert("EngineRpm is greater then RedLineRpm", "High","EngineRpm" ,vehicleReading);
        }
        //rule 2
        if (vehicleReading.getFuelVolume() < (vehicle.getMaxFuelVolume() * 0.10)) {
            saveAlert("Fuel volume is less then 10% of RedLineRpm", "Low","FuelVolume" ,vehicleReading);
        }
        //rule 3
        int frontLeft = vehicleReading.getTires().getFrontLeft();
        int frontRight = vehicleReading.getTires().getFrontRight();
        int rearLeft = vehicleReading.getTires().getRearLeft();
        int rearRight = vehicleReading.getTires().getRearRight();
        if(frontLeft < 32 || frontLeft > 36 ||
                frontRight < 32 || frontRight > 36 ||
                rearLeft < 32 || rearLeft > 36 ||
                rearRight < 32 || rearRight > 36){
            saveAlert("Tire Pressure is less than 32psi or grater than 36psi", "Low","Tire Pressure" ,vehicleReading);
        }

        //rule 4
        if(vehicleReading.isCheckEngineLightOn() || vehicleReading.isEngineCoolantLow()){
            saveAlert("Engine Light is ON or Engine Coolant is low", "Low","Engine Light and Coolant" ,vehicleReading);
        }
    }

    //Method to save alert
    public void saveAlert(String alretDescription,String priority,String type ,VehicleReading vehicleReading){
        Alert alert = new Alert();
        alert.setVin(vehicleReading.getVin());
        alert.setAlertTimeStamp(vehicleReading.getTimestamp());
        alert.setPriority(priority);
        alert.setAlertDescription(alretDescription);
        alert.setAlertType(type);
        alertRepository.save(alert);
    }

    //Method to save location
    public void saveLocations(VehicleReading vehicleReading){
        Location location = new Location();
        location.setVin(vehicleReading.getVin());
        location.setLatitude(vehicleReading.getLatitude());
        location.setLongitude(vehicleReading.getLongitude());
        location.setLocationTimestamp(vehicleReading.getTimestamp());
        locationRepository.save(location);
    }
}
