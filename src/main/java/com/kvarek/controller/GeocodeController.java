package com.kvarek.controller;


import com.kvarek.service.GeocodeReqestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeocodeController {


    GeocodeReqestService geocodeReqestService;


    @Autowired
    GeocodeController(GeocodeReqestService geocodeReqestService) {
        this.geocodeReqestService = geocodeReqestService;
    }


    @GetMapping("/findPoint")
    public String findPoint(@RequestParam String startPoint, @RequestParam String endPoint) {
        return geocodeReqestService.getLocation(startPoint, endPoint);
    }


}