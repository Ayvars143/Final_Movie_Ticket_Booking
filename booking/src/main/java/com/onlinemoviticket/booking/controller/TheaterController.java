package com.onlinemoviticket.booking.controller;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.service.TheaterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/{theaterId}/shows")
    @Operation(summary = "Get the list of shows by theaters and which is having seats to book ", description = "Fetches the list of shows which is having available seats")
    public List<Show> getShowsByTheater(@PathVariable int theaterId) {
        return theaterService.getShowsByTheater(theaterId);
    }
}

