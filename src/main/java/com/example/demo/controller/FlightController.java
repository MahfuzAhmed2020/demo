package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;   // ✅ Correct import
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/flight")
public class FlightController {

    private final String ACCESS_TOKEN = "uPJR6VSrxvGIIsmM8Ch9sQemoPHq";

    @GetMapping
    public String getFlightPrice(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {

        String url = "https://test.api.amadeus.com/v2/shopping/flight-offers"
                + "?originLocationCode=" + from
                + "&destinationLocationCode=" + to
                + "&departureDate=" + date
                + "&adults=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        ).getBody();
    }
}