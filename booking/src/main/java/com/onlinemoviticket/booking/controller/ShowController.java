package com.onlinemoviticket.booking.controller;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    @Operation(summary = "Creating/Adding the new show to the theater", description = "Adding new show to the theater")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        return ResponseEntity.ok(showService.createShow(show));
    }

    @PutMapping("/{showId}")
    @Operation(summary = "Update the show details by using show id", description = "Update the show details by using show id")
    public ResponseEntity<Show> updateShow(@PathVariable Long showId, @RequestBody Show updatedShow) {
        return ResponseEntity.ok(showService.updateShow(showId, updatedShow));
    }

    @DeleteMapping("/{showId}")
    @Operation(summary = "Deleting the show from the theater", description = "Deleting the show from the theater")
    public ResponseEntity<Void> deleteShow(@PathVariable Long showId) {
        showService.deleteShow(showId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{theaterId}/{showDate}")
    @Operation(summary = "Get the list of Show details by theter id and date", description = "Get the list of Show details by theter id and date")
    public ResponseEntity<List<Show>> getShowsForTheater(
            @PathVariable Long theaterId,
            @PathVariable LocalDate showDate) {
        return ResponseEntity.ok(showService.getShowsForTheater(theaterId, showDate));
    }
}

