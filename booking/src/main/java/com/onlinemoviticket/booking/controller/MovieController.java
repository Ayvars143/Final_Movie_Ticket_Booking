package com.onlinemoviticket.booking.controller;


import com.onlinemoviticket.booking.entity.Theater;
import com.onlinemoviticket.booking.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/theaters")
    @Operation(summary = "Get the list of theaters  by movie_name and date", description = "Fetches the list of theater details by movie name and date")
    public List<Theater> getTheatersByMovieAndDate(@RequestParam String movieTitle, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return movieService.getTheatersByMovieAndDate(movieTitle, date);
    }

}
