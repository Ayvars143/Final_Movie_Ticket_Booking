package com.movieticketbooking.movieservice.repository;

import com.movieticketbooking.movieservice.entity.Seat;
import com.movieticketbooking.movieservice.entity.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowTimingAndStatus(ShowTiming showTiming, Seat.SeatStatus status);
}
