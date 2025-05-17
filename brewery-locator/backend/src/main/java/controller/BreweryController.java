package com.brewerylocator.controller;

import com.brewerylocator.model.Brewery;
import com.brewerylocator.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/breweries")
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @GetMapping
    public List<Brewery> getBreweries() {
        return breweryService.getBreweryData();
    }

    @GetMapping("/")  // This is the important part!
    public String home() {
        return "Welcome to the Brewery Locator API! Access the breweries at /api/breweries";
    }
}
