package com.onlinemoviticket.booking.repository;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.entity.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeats, Long> {
    @Query("SELECT ss.seatName FROM ShowSeats ss WHERE ss.show.id = :showId AND ss.seatType = 'available'")
    List<String> findAvailableSeatsByShowId(@Param("showId") int showId);

    @Query("SELECT s FROM ShowSeats s WHERE s.show.id = :showId AND s.seatType = 'available' AND s.seatName IN :seatNames")
    List<ShowSeats> findAvailableSeats(@Param("showId") Long showId, @Param("seatNames") List<String> seatNames);

}
