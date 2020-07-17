package com.kvarek.service;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GraphHopperRequestService {

    private final String urlPrefix = "https://graphhopper.com/api/1/route?";
    private final String urlSufix = "&key=";
    private final RestTemplate restTemplate;

    @Autowired
    GeocodeReqestService geocodeReqestService;

    public GraphHopperRequestService(RestTemplateBuilder restTemplate, GeocodeReqestService geocodeReqestService) {
        this.restTemplate = restTemplate.build();
        this.geocodeReqestService = geocodeReqestService;
    }

    public JsonNode route(String place1, String place2, String graphhopperApiKey) {

        String url = urlPrefix + geocodeReqestService.getLocation(place1, place2) + urlSufix+graphhopperApiKey;

        JsonNode path = this.restTemplate.getForObject(url, JsonNode.class).get("paths");
        for (JsonNode jsonNode : path) {
            return jsonNode.get("instructions");
        }

        return path;
    }
}
