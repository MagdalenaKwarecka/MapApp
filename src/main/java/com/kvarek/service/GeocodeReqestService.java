package com.kvarek.service;

import com.kvarek.model.GeoResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodeReqestService {


    private final String url = "https://geocode.xyz/";
    private final RestTemplate restTemplate;

    public GeocodeReqestService(RestTemplateBuilder restTemplatebuilder) {
        this.restTemplate = restTemplatebuilder.build();
    }

    public String getLocation(String place1, String place2) {
        String url1 = url + place1 + "?json=1";
        String url2 = url + place2 + "?json=1";
        GeoResponseDto loc1 = this.restTemplate.getForObject(url1, GeoResponseDto.class);
        GeoResponseDto loc2 = this.restTemplate.getForObject(url2, GeoResponseDto.class);
        String routePoints = "point=" + loc1.getLatt().toString() + "," + loc1.getLongt().toString() + "&point=" +
                loc2.getLatt().toString() + "," + loc2.getLongt().toString();
        return routePoints;
    }
}


