package com.pd.ennate.api.service;
import com.pd.ennate.api.entity.Alert;
import java.util.List;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is interface for Alert Service.
 */

public interface AlertService {

    List<Alert> getAlertForVehicle(String vin);

    List<Alert> getAlertForLastTwoHours(String priorityType);
}
