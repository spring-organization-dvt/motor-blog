package com.thinkpad.service;

import com.thinkpad.model.MotorBike;
import com.thinkpad.repository.MotorBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MotorBikeServiceImpl implements MotorBikeService {

    @Autowired
    private MotorBikeRepository motorBikeRepository;

    @Override
    public List<MotorBike> findAll() {
        return motorBikeRepository.findAll();
    }

    @Override
    public MotorBike findById(Integer id) {
        return motorBikeRepository.findById(id);
    }

    @Override
    public void save(MotorBike motorBike) {
        motorBikeRepository.save(motorBike);
    }

    @Override
    public void remove(Integer id) {
        motorBikeRepository.remove(id);
    }
}
