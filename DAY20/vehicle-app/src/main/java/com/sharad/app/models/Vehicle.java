package com.sharad.app.models;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String fuelType;
    private final Logger log = LoggerFactory.getLogger(Vehicle.class);

    public String getVehicleNumber()
    {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType()
    {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    public String getFuelType()
    {
        return fuelType;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
    public Vehicle()
    {
        log.trace("TRACE Level Log - Vehicle Constructor");
        log.debug("DEBUG Level Log - Vehicle Constructor");
        log.info("INFO Level Log - Vehicle Constructor");
        log.warn("WARN Level Log - Vehicle Constructor");
        log.error("ERROR Level Log - Vehicle Constructor");
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
