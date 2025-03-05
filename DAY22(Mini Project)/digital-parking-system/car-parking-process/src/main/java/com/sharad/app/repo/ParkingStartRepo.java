package com.sharad.app.repo;

import com.sharad.app.module.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingStartRepo extends JpaRepository<ParkingStart, Integer> {



    ParkingStart findByParkingNo(String parkingNumber);
}