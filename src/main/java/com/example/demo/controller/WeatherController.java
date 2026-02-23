package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/weather")
public class WeatherController {

    private final String API_KEY = "70428157491abb380e0c291e48f097b3";

    @GetMapping
    public String getWeather(@RequestParam String query) {

        String url;

        // If query is number → treat as ZIP
        if (query.matches("\\d+")) {
            url = "https://api.openweathermap.org/data/2.5/weather?zip="
                    + query + "&appid=" + API_KEY + "&units=imperial";
        } else {
            url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + query + "&appid=" + API_KEY + "&units=imperial";
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}