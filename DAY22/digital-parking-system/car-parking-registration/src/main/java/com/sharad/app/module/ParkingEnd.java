package com.sharad.app.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEnd {
    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private int price;
    private String status = "End";
    private String regNo;

    public ParkingEnd(String parkingNo, Date startTime, Date endTime, String regNo) {
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.regNo = regNo;
        this.price = calculatePrice();
    }

    private int calculatePrice() {
        long durationInMinutes = (endTime.getTime() - startTime.getTime()) / (1000 * 60);
        return (int) durationInMinutes * 2; // Rs. 2 per minute
    }
}
