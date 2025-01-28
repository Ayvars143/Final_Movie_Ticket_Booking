package com.movieticketbooking.movieservice.controller;

import com.movieticketbooking.movieservice.entity.ShowTiming;
import com.movieticketbooking.movieservice.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping
    @Operation(summary = "Browse theatres currently running the " +
            "show (movie selected) in the town, including show timing" +
            " by a chosen date.", description = "" +
            "Step 1 : Choose the movie from the available list to Browse Theatres\n" +
            "\n" +
            "(e.g., \"Avatar 2\").\n" +
            "\n" +
            "\n" +
            "Step 2 : Select a Town/Location\n" +
            "\n" +
            "(e.g., \"Hyderabad\").\n" +
            "\n" +
            "\n" +
            "Step 3 : pick the Date\n" +
            "\n" +
            "(e.g., \"January 28, 2025\" in YYYY-MM-DD formate).\n" +
            "\n" +
            "\n" +
            "<b> View Results </b>\n" +
            "\n" +
            "Display a list of theatres running the selected movie in the chosen town on the selected date. " +
            "Include the following details for each theatre:\n" +
            "\n" +
            "Theatre Name \n" +
            "\n" +
            "Address \n" +
            "\n" +
            "Show Timings (e.g., \"10:00 AM, 1:30 PM, 5:00 PM, 8:45 PM\")\n" )

    public ResponseEntity<?> getShows(
            @RequestParam String movieTitle,
            @RequestParam String townName,
            @RequestParam String showDate) {

        LocalDate date;
        try {
            date = LocalDate.parse(showDate);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }

        List<ShowTiming> shows = showService.getShows(movieTitle, townName, date);

        if (shows.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No shows found for the selected criteria.");
        }

        return ResponseEntity.ok(shows);
    }
}

