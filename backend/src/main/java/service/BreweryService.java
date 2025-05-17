package com.brewerylocator.service;

import com.brewerylocator.model.Brewery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

@Service
public class BreweryService {

    @Autowired
    private RestTemplate restTemplate;
    private final String url = "https://api.openbrewerydb.org/v1/breweries"; // Corrected URL

    public List<Brewery> getBreweryData() {
        Brewery[] response = restTemplate.getForObject(url, Brewery[].class);
        return Arrays.asList(response);
    }
}
