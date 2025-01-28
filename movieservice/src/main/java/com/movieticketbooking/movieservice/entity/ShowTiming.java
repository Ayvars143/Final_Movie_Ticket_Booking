package com.movieticketbooking.movieservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "show_timings")
public class ShowTiming {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @Schema(description = "Movie Id", example = "1")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    @Schema(description = "Theater Id", example = "1")
    private Theater theatre;



    @Column(name = "show_date", nullable = false)
    private LocalDate showDate;



    @Column(name = "show_time", nullable = false)
    private LocalTime showTime;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public Theater getTheatre() {
        return theatre;
    }

    public void setTheatre(Theater theatre) {
        this.theatre = theatre;
    }
    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }
    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

}
