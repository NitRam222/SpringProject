package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car2 {
    private final String model;
    private double price;

    public Car2(String model) {
        this.model = model;
    }
}
