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
 *	This is Location Entity for ORM mapping.
 */

@Entity
public class Location {

    @Id
    private String id;
    private String vin;
    private Double latitude;
    private Double longitude;
    private Date locationTimestamp;

    public Location(){
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getLocationTimestamp() {
        return locationTimestamp;
    }

    public void setLocationTimestamp(Date locationTimestamp) {
        this.locationTimestamp = locationTimestamp;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", locationTimestamp=" + locationTimestamp +
                '}';
    }
}
