package com.onlinemoviticket.booking.service;

import com.onlinemoviticket.booking.entity.Theater;
import com.onlinemoviticket.booking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private ShowRepository showRepository;

    public List<Theater> getTheatersByMovieAndDate(String movieTitle, LocalDate date) {
        return showRepository.findTheatersByMovieAndDate(movieTitle, date);
    }
}

