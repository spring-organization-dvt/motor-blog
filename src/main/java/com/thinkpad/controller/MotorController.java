package com.thinkpad.controller;

import com.thinkpad.service.MotorBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MotorController {
    @Autowired
    private MotorBikeService motorBikeService;

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "motorBikes", motorBikeService.findAll());
    }
}
