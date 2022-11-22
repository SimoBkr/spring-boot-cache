package com.simobkr.springbootcache.controllers;

import com.simobkr.springbootcache.models.Car;
import com.simobkr.springbootcache.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(@RequestParam Double minPrice,@RequestParam Double maxPrice){
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping(params = {"brand"})
    public List<Car> getAllFilteredByBrand(@RequestParam String brand){
        return carService.getCarsWithBrandFilter(brand);
    }
}
