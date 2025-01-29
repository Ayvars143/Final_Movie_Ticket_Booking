package com.onlinemoviticket.booking.repository;

import com.onlinemoviticket.booking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    @Query("SELECT t FROM Theater t JOIN Show s ON s.theater.id = t.id WHERE s.movie.id = :movieId")
    List<Theater> findTheatersByMovie(@Param("movieId") int movieId);
}
