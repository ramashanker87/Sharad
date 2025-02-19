package com.sharad.app.service;

import com.sharad.app.models.Owner;
import com.sharad.app.models.Registration;
import com.sharad.app.models.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleService
{
    private final Logger log = LoggerFactory.getLogger(VehicleService.class);
    Map<String, Registration> map = new HashMap<>();

    public String saveVehicle(Vehicle vehicle, Owner owner)
    {
        log.info("Vehicle registration started : " + vehicle + " owner : " + owner);
        String vehicleNum = vehicle.getVehicleNumber();
        log.info("Registering the vehicle .......");
        map.put(vehicleNum,new Registration(vehicle,owner));
        log.info("Vehicle registration completed : {} owner : {}", vehicle, owner);
        return owner.getName()+" your vehicle "+vehicleNum+" is registered";
    }
    public String deleteVehicle(String vehicleNumber)
    {
        log.info("Vehicle de-registration started for vehicle number : {}", vehicleNumber);
        map.remove(vehicleNumber);
        log.info("Vehicle de-registration completed successfully for vehicle number : {}", vehicleNumber);
        return vehicleNumber+" has been de-registered Successfully";
    }
    public List<Registration> getAllVehicles()
    {
        log.info("generating vehicle list");
        return new ArrayList<>(map.values());
    }
}
