package com.movieticketbooking.movieservice.repository;

import com.movieticketbooking.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "select * from movies where title=:title", nativeQuery = true)
    List<Movie> findByTitle(String title);

   // Optional<Movie> findByTitle(String title);

}
