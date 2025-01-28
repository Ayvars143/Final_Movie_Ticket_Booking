package com.movieticketbooking.theatreservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique ID of the theatre", example = "1")
    private Long id;
    @Schema(description = "The theatre name", example = "PVR")
    private String name;
    @Schema(description = "The location of the theatre", example = "Hyderabad")
    private String location;
    @Schema(description = "The seating capacity of the theatre", example = "200")
    private int capacity;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
