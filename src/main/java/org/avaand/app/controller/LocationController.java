package org.avaand.app.controller;

import org.avaand.app.events.Location;
import org.avaand.app.services.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LocationController {

    private final KafkaProducerService<String, Location> kafkaProducerService;

    public LocationController(KafkaProducerService<String, Location> kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/send")
    public ResponseEntity<?> receiveLocation(@RequestParam("latitude") float latitude, @RequestParam("longitude") float longitude) {
        final Location location = new Location(latitude, longitude);
        kafkaProducerService.sendMessage("user-location", UUID.randomUUID().toString(), location);
        return ResponseEntity.ok(location);
    }

}
