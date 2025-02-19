package com.sharad.app.controller;

import com.sharad.app.module.Car;
import com.sharad.app.module.ParkingStart;
import com.sharad.app.module.ParkingEnd;
import com.sharad.app.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        return parkingService.startParking(car, parkingNo);
    }

    @GetMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        return parkingService.endParking(regNo);
    }
}
