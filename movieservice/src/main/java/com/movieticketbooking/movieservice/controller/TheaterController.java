package com.movieticketbooking.movieservice.controller;

import com.movieticketbooking.movieservice.entity.Movie;
import com.movieticketbooking.movieservice.entity.Theater;
import com.movieticketbooking.movieservice.service.TheaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater-mapper")
@Tag(name = "Theater Controller", description = "APIs for managing Theaters")
public class TheaterController {
   /* @Autowired
    private TheaterService theaterService;

    @PostMapping("/addtheaters")
    @Operation(summary = "Add the theater", description = "Adding the new Theater in DB")
    public ResponseEntity<ApiResponse> addTheater(@RequestBody Theater theaters) {
        if ( theaterService.addTheater(theaters).getStatusCode().equals(HttpStatus.CONFLICT)) {
            ApiResponse response = new ApiResponse();
            response.setDescription("The theater is already exists in database");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        ApiResponse response = new ApiResponse();
        response.setDescription("theater is Created successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(theaters))); // Set the theater as an example for the response content
        return ResponseEntity.ok(response);

    }
    @GetMapping("/getalltheaters")
    @Operation(summary = "Get all theaters", description = "Fetches the list of all available theaters")
    public ResponseEntity<ApiResponse> getAllTheaters() {
        List<Theater> theaters = theaterService.getAllTheaters();

        if (theaters.isEmpty()) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No theaters found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        ApiResponse response = new ApiResponse();
        response.setDescription("Theaters fetched successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(theaters))); // Set the theaters as an example for the response content
        return ResponseEntity.ok(response);
    }

    @GetMapping("/theaters/{id}")
    @Operation(summary = "Get theaters details by id", description = "Fetches the theater details by theater id")
    public ResponseEntity<ApiResponse>  getTheaters(@PathVariable Long id) {
        if (theaterService.getTheaters(id) == null) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No theaters found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        ApiResponse response = new ApiResponse();
        response.setDescription("Theater found successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(theaterService.getTheaters(id)))); // Set the theaters as an example for the response content
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updatetheater/{id}")
    @Operation(summary = "Update theater details by id", description = "Update the theater details by theater id")
    public ResponseEntity<ApiResponse>  updateTheaters(@PathVariable Long id, @RequestBody Theater updatedTheaters) {
        if (theaterService.updateTheaters(id,updatedTheaters) == null) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No theaters found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        ApiResponse response = new ApiResponse();
        response.setDescription("Theater updated successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(theaterService.getTheaters(id)))); // Set the movies as an example for the response content
        return ResponseEntity.ok(response);


    }
    @DeleteMapping("/deletetheater/{id}")
    @Operation(summary = "Delete the theater details by id", description = "Delete the theater details from database by theater id")
    public ResponseEntity<String> deleteTheater(@PathVariable Long id) {
        return theaterService.deleteTheaters(id);
    }*/

}
