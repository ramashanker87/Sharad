package com.sharad.app.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String ownerName;
    private String regNo;
    private String model;
    private String type; // Fuel type
}
