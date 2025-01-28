package com.movieticketbooking.theatreservice.controller;

import com.movieticketbooking.theatreservice.entity.Theatre;
import com.movieticketbooking.theatreservice.srevice.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/theaters-mapper")
@Tag(name = "Theatre Controller", description = "APIs for managing movies")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping("/getalltheatres")
    @Operation(summary = "Get all theatre", description = "Fetches the list of all theatres")
    public List<Theatre> getAllTheatres() {

        return theatreService.getAllTheatres();
    }

    @DeleteMapping("/deletetheater/{id}")
    @Operation(summary = "Delete the Theater", description = "Deleting  the theatres from the DB")
    public ResponseEntity<String> deleteTheater(@PathVariable Long id) {
        return theatreService.deleteTheater(id);
    }


}

