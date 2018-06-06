package com.pd.ennate.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is Alert Entity for ORM mapping.
 */
@Entity
public class Alert {

    @Id
    private String id;
    private String vin;
    private String alertType;
    private String alertDescription;
    private Date alertTimeStamp;
    private String priority;


    public Alert(){
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertDescription() {
        return alertDescription;
    }

    public void setAlertDescription(String alertDescription) {
        this.alertDescription = alertDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getAlertTimeStamp() {
        return alertTimeStamp;
    }

    public void setAlertTimeStamp(Date alertTimeStamp) {
        this.alertTimeStamp = alertTimeStamp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", alertType='" + alertType + '\'' +
                ", alertDescription='" + alertDescription + '\'' +
                ", alertTimeStamp=" + alertTimeStamp +
                ", priority='" + priority + '\'' +
                '}';
    }
}
