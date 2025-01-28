package com.movieticketbooking.movieservice.repository;

import com.movieticketbooking.movieservice.entity.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowTimingRepository extends JpaRepository<ShowTiming, Long> {

    @Query("SELECT st FROM ShowTiming st WHERE st.movie.title = :movieTitle AND st.theatre.town.name = :townName AND st.showDate = :showDate")
    List<ShowTiming> findByMovieAndTownAndDate(
            @Param("movieTitle") String movieTitle,
            @Param("townName") String townName,
            @Param("showDate") LocalDate showDate
    );
    List<ShowTiming> findByMovieIdAndTheatreIdAndShowDate(Long movieId, Long theatreId, LocalDate showDate);
}

