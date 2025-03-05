package com.sharad.app.repo;


import com.sharad.app.module.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findByRegistrationNumber(String parkingNumber);
}