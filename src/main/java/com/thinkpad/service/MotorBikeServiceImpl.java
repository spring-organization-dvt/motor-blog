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

}
