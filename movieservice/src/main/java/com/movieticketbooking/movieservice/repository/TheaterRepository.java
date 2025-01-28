package com.movieticketbooking.movieservice.repository;

import com.movieticketbooking.movieservice.entity.Movie;
import com.movieticketbooking.movieservice.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    @Query(value = "select * from theatres where name=:name", nativeQuery = true)
    List<Theater> findByName(String name);
}
