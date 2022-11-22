package com.simobkr.springbootcache.services;

import com.simobkr.springbootcache.models.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>(
            List.of(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d),
                    new Car(4L, "Golf", "VW", 120, 19000d),
                    new Car(5L, "Gallardo", "Lamborghini", 400, 100_000d)
            ));

    //@Cacheable(value = "priceFilterCache",key = "#root.method")
    @Cacheable(value = "priceFilterCache", keyGenerator = "keyGenerator")
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return cars.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

    public List<Car> getCarsWithBrandFilter(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }
}
