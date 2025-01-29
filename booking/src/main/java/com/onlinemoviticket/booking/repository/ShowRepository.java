package com.onlinemoviticket.booking.repository;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query("SELECT t FROM Theater t JOIN Show s ON s.theater.id = t.id WHERE s.movie.title = :movieTitle AND s.showDate = :date")
    List<Theater> findTheatersByMovieAndDate(@Param("movieTitle") String movieTitle, @Param("date") LocalDate date);

   // @Query("SELECT s FROM Show s WHERE s.theater.id = :theaterId AND s.seatsAvailable > 0")
   @Query("SELECT s FROM Show s \n" +
           "    WHERE s.theater.id = :theaterId \n" +
           "    AND (\n" +
           "        SELECT COUNT(ss) FROM ShowSeats ss \n" +
           "        WHERE ss.show.id = s.id AND ss.seatType = 'available'\n" +
           "    )  > 0")
    List<Show> findAvailableShowsByTheater(@Param("theaterId") int theaterId);

    @Query("SELECT s FROM Show s WHERE s.theater.id = :theaterId AND s.showTime = :showTime AND s.showDate = :showDate")
    Optional<Show> findShow(@Param("theaterId") Long theaterId, @Param("showTime") LocalTime showTime, @Param("showDate") LocalDate showDate);

    List<Show> findByTheaterIdAndShowDate(Long theaterId, LocalDate showDate);

}
