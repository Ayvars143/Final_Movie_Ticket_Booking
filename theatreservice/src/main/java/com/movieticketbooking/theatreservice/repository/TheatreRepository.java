package com.movieticketbooking.theatreservice.repository;

import com.movieticketbooking.theatreservice.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    //List<Theatre> findByLocationId(int id);
    List<Theatre> findByName(String name);
}
