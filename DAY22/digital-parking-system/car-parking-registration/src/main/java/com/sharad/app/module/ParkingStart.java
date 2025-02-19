package com.sharad.app.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingStart {
    private String parkingNo;
    private Date startTime;
    private String status = "Start";
    private String regNo;

    public ParkingStart(String parkingNo, String regNo) {
        this.parkingNo = parkingNo;
        this.startTime = new Date(); // Always current time
        this.regNo = regNo;
    }
}
