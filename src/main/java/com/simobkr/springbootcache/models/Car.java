package com.simobkr.springbootcache.models;

import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;
}
