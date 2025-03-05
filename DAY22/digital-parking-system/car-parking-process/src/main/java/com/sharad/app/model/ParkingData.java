package com.parking.process.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class ParkingData {
    private String parkingNo;
    private String regNo;
    private Date startTime;
    private Date endTime;
    private int price;
    private String status;

    @DynamoDbPartitionKey
    public String getRegNo() {
        return regNo;
    }
}
