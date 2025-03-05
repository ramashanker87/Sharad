package com.sharad.app.service;

import com.sharad.app.module.Car;
import com.sharad.app.module.ParkingStart;
import com.sharad.app.module.ParkingEnd;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {

    private final Map<String, ParkingStart> parkingData = new HashMap<>();

    public ParkingStart startParking(Car car, String parkingNo) {
        ParkingStart parkingStart = new ParkingStart(parkingNo, car.getRegNo());
        parkingData.put(car.getRegNo(), parkingStart);
        return parkingStart;
    }

    public ParkingEnd endParking(String regNo) {
        ParkingStart parkingStart = parkingData.get(regNo);
        if (parkingStart == null) {
            throw new IllegalArgumentException("No active parking found for registration number: " + regNo);
        }
        ParkingEnd parkingEnd = new ParkingEnd(
                parkingStart.getParkingNo(),
                parkingStart.getStartTime(),
                new Date(),
                regNo
        );
        parkingData.remove(regNo);
        return parkingEnd;
    }
}
