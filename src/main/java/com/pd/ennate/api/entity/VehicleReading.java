package com.pd.ennate.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

/**
 * @author Pratik Belhekar
 *	Date : 06/03/2018
 *	Version : 1.0.0
 *
 *	This is Vehicle Reading Entity for ORM mapping.
 */

@Entity
public class VehicleReading {

        @Id
        private String id;
        private String vin;
        private double latitude;
        private double longitude;
        private Date timestamp;
        private int fuelVolume;
        private int speed;
        private int engineHp;
        private boolean checkEngineLightOn;
        private boolean engineCoolantLow;
        private boolean cruiseControlOn;
        private int engineRpm;

        @OneToOne(cascade = {CascadeType.ALL})
        private Tires tires;

        public VehicleReading(){
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public int getFuelVolume() {
            return fuelVolume;
        }

        public void setFuelVolume(int fuelVolume) {
            this.fuelVolume = fuelVolume;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getEngineHp() {
            return engineHp;
        }

        public void setEngineHp(int engineHp) {
            this.engineHp = engineHp;
        }

        public boolean isCheckEngineLightOn() {
            return checkEngineLightOn;
        }

        public void setCheckEngineLightOn(boolean checkEngineLightOn) {
            this.checkEngineLightOn = checkEngineLightOn;
        }

        public boolean isEngineCoolantLow() {
            return engineCoolantLow;
        }

        public void setEngineCoolantLow(boolean engineCoolantLow) {
            this.engineCoolantLow = engineCoolantLow;
        }

        public boolean isCruiseControlOn() {
            return cruiseControlOn;
        }

        public void setCruiseControlOn(boolean cruiseControlOn) {
            this.cruiseControlOn = cruiseControlOn;
        }

        public int getEngineRpm() {
            return engineRpm;
        }

        public void setEngineRpm(int engineRpm) {
            this.engineRpm = engineRpm;
        }

        public Tires getTires() {
            return tires;
        }

        public void setTires(Tires tires) {
            this.tires = tires;
        }

    @Override
    public String toString() {
        return "VehicleReading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}


