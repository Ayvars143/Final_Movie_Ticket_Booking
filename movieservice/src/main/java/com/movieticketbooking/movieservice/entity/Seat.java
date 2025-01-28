package com.movieticketbooking.movieservice.entity;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;



    @ManyToOne
    @JoinColumn(name = "show_timing_id", nullable = false)
    private ShowTiming showTiming;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public enum SeatStatus {
        AVAILABLE, BOOKED
    }

    // Getters and setters
    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public ShowTiming getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(ShowTiming showTiming) {
        this.showTiming = showTiming;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}

