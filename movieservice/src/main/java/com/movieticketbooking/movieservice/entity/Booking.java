package com.movieticketbooking.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Column(name = "movie_id")
    @Schema(description = "Movie Id", example = "1")
    private Long movieId;

    @Column(name = "theatre_id")
    @Schema(description = "Theater Id", example = "1")
    private Long theatreId;

    @Column(name = "show_date")
    @Schema(description = "Show Date", example = "2025-01-28")
    private Date showDate;

    @Column(name = "show_time")
    @Schema(description = "Show Time", example = "13:50:21")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime showTime;

    @Column(name = "ticket_count")
    @Schema(description = "Number of tickets", example = "3")
    private int ticketCount;

    @Column(name = "total_amount")
    @Schema(description = "Discounted price", example = "900")
    private double totalAmount;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
