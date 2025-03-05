package com.parking.process.repository;

import com.parking.process.model.ParkingData;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import javax.annotation.PostConstruct;

@Repository
public class ParkingRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<ParkingData> parkingTable;

    public ParkingRepository(DynamoDbClient dynamoDbClient) {
        this.enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
        this.parkingTable = enhancedClient.table("ParkingData", TableSchema.fromBean(ParkingData.class));
    }

    @PostConstruct
    public void createTableIfNotExists() {
        try {
            parkingTable.createTable();
        } catch (Exception e) {
            System.out.println("Table already exists.");
        }
    }

    public void saveParkingData(ParkingData data) {
        parkingTable.putItem(data);
    }

    public ParkingData getParkingData(String regNo) {
        return parkingTable.getItem(r -> r.key(k -> k.partitionValue(regNo)));
    }

    public void deleteParkingData(String regNo) {
        parkingTable.deleteItem(r -> r.key(k -> k.partitionValue(regNo)));
    }
}
