package com.onlinemoviticket.booking.entity;

import jakarta.persistence.*;
@Entity
public class ShowSeats {
    @Id
    @Column(name = "show_seat_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "show_id", insertable = false, updatable = false)
    private Show show;

    @Column(name = "seat_type", nullable = false)
    private String seatType; // 'available' or 'booked'

    @Column(name = "seat_name", nullable = false)
    private String seatName;

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Show getShow() { return show; }
    public void setShow(Show show) { this.show = show; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public String getSeatName() { return seatName; }
    public void setSeatName(String seatName) { this.seatName = seatName; }
}
