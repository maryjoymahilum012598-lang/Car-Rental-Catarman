package com.rental.car_rental_api;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String transmission;
    private Integer seats;
    private Double pricePerDay;
    private Integer availableUnits;
    private String imageUrl;

    public Long getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getTransmission() { return transmission; }
    public Integer getSeats() { return seats; }
    public Double getPricePerDay() { return pricePerDay; }
    public Integer getAvailableUnits() { return availableUnits; }
    public String getImageUrl() { return imageUrl; }

    public void setAvailableUnits(Integer availableUnits) { this.availableUnits = availableUnits; }
}