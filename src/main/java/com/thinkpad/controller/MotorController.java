package com.thinkpad.controller;

import com.thinkpad.model.MotorBike;
import com.thinkpad.service.MotorBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MotorController {
    @Autowired
    private MotorBikeService motorBikeService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home", "motorBikes", motorBikeService.findAll());
    }

    @GetMapping("/delete-motorbike/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        MotorBike motorBike = motorBikeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("motorbike", motorBike);
        return modelAndView;
    }

    @PostMapping("/delete-motorbike")
    public ModelAndView delete(@ModelAttribute("motorbike") MotorBike motorBike) {
        motorBikeService.remove(motorBike.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/create-motorbike")
    public ModelAndView createMotorBike() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("motorbike", new MotorBike());
        return modelAndView;
    }

    @PostMapping("/create-motorbike")
    public ModelAndView saveMotorBike(@ModelAttribute("motorbike") MotorBike motorbike) {
        motorBikeService.save(motorbike);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("motorbike", new MotorBike());
        modelAndView.addObject("message", "Successfully!");
        return modelAndView;
    }

    @GetMapping("/detail-motorbike/{id}")
    public ModelAndView detail(@PathVariable int id) {
        MotorBike motorBike = motorBikeService.findById(id);
        if (motorBike != null) {
            ModelAndView modelAndView = new ModelAndView("detail");
            modelAndView.addObject("motorbike", motorBike);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @GetMapping("/update-motorbike/{id}")
    public ModelAndView showUpdateForm(@PathVariable Integer id) {
        MotorBike motorBike = motorBikeService.findById(id);
        if (motorBike != null) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("motorbike", motorBike);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/update-motorbike")
    public ModelAndView update(@ModelAttribute("motorbike") MotorBike motorBike) {
        motorBikeService.save(motorBike);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("motorbike", new MotorBike());
        modelAndView.addObject("message", "Successfully!");
        return modelAndView;
    }
}
