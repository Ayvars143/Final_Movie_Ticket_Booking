package com.movieticketbooking.movieservice.service;

import com.movieticketbooking.movieservice.entity.ShowTiming;
import com.movieticketbooking.movieservice.repository.ShowTimingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowTimingRepository showTimingRepository;

    public List<ShowTiming> getShows(String movieTitle, String townName, LocalDate showDate) {
        return showTimingRepository.findByMovieAndTownAndDate(movieTitle, townName, showDate);
    }
}

