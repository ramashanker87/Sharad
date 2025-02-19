package com.sharad.app.controller;

import com.sharad.app.models.Owner;
import com.sharad.app.models.Registration;
import com.sharad.app.models.Vehicle;
import com.sharad.app.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VehicleRegistrationController
{
    @Autowired
    private VehicleService vehicleService;
    private final Logger log = LoggerFactory.getLogger(VehicleRegistrationController.class);

    @PostMapping("/register/vehicle")
    public String register(@RequestBody Registration registration)
    {
        log.info("Registration request received");
        return vehicleService.saveVehicle(registration.getVehicle(), registration.getowner());
    }

    @DeleteMapping("deregister/vehicle")
    public String deRegister(@RequestParam String vehicleNumber)
    {
        log.info("De-registration request received");
        return vehicleService.deleteVehicle(vehicleNumber);
    }

    @GetMapping("/get/all-vehicles")
    public List<Registration> getAllVehicles()
    {
        log.info("Get all vehicles request received");
        return vehicleService.getAllVehicles();
    }
}
