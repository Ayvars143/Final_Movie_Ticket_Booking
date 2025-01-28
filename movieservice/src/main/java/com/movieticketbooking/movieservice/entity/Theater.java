package com.movieticketbooking.movieservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="theatres")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Schema(description = "The unique ID of the theatre", example = "1")
    private Long id;
    @Column(nullable = false)
    @Schema(description = "The theatre name", example = "PVR")
    private String name;



    @ManyToOne
    @JoinColumn(name = "town_id", nullable = false)
    @Schema(description = "The location of the theatre", example = "Hyderabad")
    private Town town;


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
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
