package com.thinkpad.service;

import com.thinkpad.model.MotorBike;

import java.util.List;

public interface MotorBikeService {
    List<MotorBike> findAll();

    MotorBike findById(Integer id);

    void save(MotorBike motorBike);

    void remove(Integer id);

}
