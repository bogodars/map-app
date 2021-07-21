package com.example.mapapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/add")
    public String addLocation(@RequestParam String place, @RequestParam String address, @RequestParam Integer longitude, @RequestParam Integer latitude ) {
        Location location = new Location();
        location.setPlaceName(place);
        location.setAddress(address);
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        locationRepository.save(location);
        return "Added new location to repo!";
    }

    @GetMapping("/list")
    public Iterable<Location> getLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Location findCustomerById(@PathVariable Integer id) {
        return locationRepository.findLocationById(id);
    }

}
