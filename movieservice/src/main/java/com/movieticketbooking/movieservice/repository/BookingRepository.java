package com.movieticketbooking.movieservice.repository;

import com.movieticketbooking.movieservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Add any custom queries if required.
}
