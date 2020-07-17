package com.kvarek.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.kvarek.service.GraphHopperRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphHopperController {
    GraphHopperRequestService graphHopperRequestService;

    @Autowired
    GraphHopperController(GraphHopperRequestService graphHopperRequestService) {
        this.graphHopperRequestService = graphHopperRequestService;
    }

    @GetMapping("/findRoute")
    public JsonNode findRoute(@RequestParam String startPoint, @RequestParam String endPoint, @RequestParam String graphhopperApiKey) {
        return graphHopperRequestService.route(startPoint, endPoint, graphhopperApiKey);
    }
}
