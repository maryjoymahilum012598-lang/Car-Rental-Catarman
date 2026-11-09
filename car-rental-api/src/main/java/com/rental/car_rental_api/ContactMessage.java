package com.rental.car_rental_api;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class ContactMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String message;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMessage() { return message; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMessage(String message) { this.message = message; }
}