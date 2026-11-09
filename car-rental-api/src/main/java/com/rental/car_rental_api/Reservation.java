package com.rental.car_rental_api;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carId;
    private String customerName;
    private String rentalDate; // BAGO: Date of Pickup
    private Integer rentalDays;
    private Double totalFee;
    private String gcashRef;
    private String paymentMethod;
    private String status = "Pending";

    // Setters
    public void setCarId(Long carId) { this.carId = carId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setRentalDate(String rentalDate) { this.rentalDate = rentalDate; } // BAGO
    public void setRentalDays(Integer rentalDays) { this.rentalDays = rentalDays; }
    public void setTotalFee(Double totalFee) { this.totalFee = totalFee; }
    public void setGcashRef(String gcashRef) { this.gcashRef = gcashRef; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setStatus(String status) { this.status = status; }

    // Getters
    public Long getId() { return id; }
    public Long getCarId() { return carId; }
    public String getCustomerName() { return customerName; }
    public String getRentalDate() { return rentalDate; } // BAGO
    public Integer getRentalDays() { return rentalDays; }
    public Double getTotalFee() { return totalFee; }
    public String getGcashRef() { return gcashRef; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
}