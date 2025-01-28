package com.movieticketbooking.movieservice.controller;

import com.movieticketbooking.movieservice.entity.Movie;
import com.movieticketbooking.movieservice.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;



import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies-mapper")
@Tag(name = "Movie Controller", description = "APIs for managing movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addmovies")
    @Operation(summary = "Add the movie", description = "Adding the new Movie in DB")
    public ResponseEntity<ApiResponse>  addMovies( @RequestBody Movie movies) {
        if ( movieService.addMovie(movies).getStatusCode().equals(HttpStatus.CONFLICT)) {
            ApiResponse response = new ApiResponse();
            response.setDescription("The movie already exists in database");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        ApiResponse response = new ApiResponse();
        response.setDescription("Movies Created successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(movies))); // Set the movies as an example for the response content
        return ResponseEntity.ok(response);

    }

    @GetMapping("/getallmovies")
    @Operation(summary = "Get all movies", description = "Fetches the list of all available movies")
    public ResponseEntity<ApiResponse> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        if (movies.isEmpty()) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No movies found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        ApiResponse response = new ApiResponse();
        response.setDescription("Movies fetched successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(movies))); // Set the movies as an example for the response content
        return ResponseEntity.ok(response);
    }

    @GetMapping("/movies/{id}")
    @Operation(summary = "Get movie details by id", description = "Fetches the movie details by movie id")
    public ResponseEntity<ApiResponse>  getMovies(@PathVariable Long id) {
        if (movieService.getMovies(id) == null) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No movies found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        ApiResponse response = new ApiResponse();
        response.setDescription("Movie found successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(movieService.getMovies(id)))); // Set the movies as an example for the response content
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updatemovie/{id}")
    @Operation(summary = "Update movie details by id", description = "Update the movie details by movie id")
    public ResponseEntity<ApiResponse>  updateMovies(@PathVariable Long id, @RequestBody Movie updatedMovies) {
        if (movieService.updateMovies(id,updatedMovies) == null) {
            ApiResponse response = new ApiResponse();
            response.setDescription("No movies found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }

        ApiResponse response = new ApiResponse();
        response.setDescription("Movie updated successfully");
        response.setContent(new Content().addMediaType("application/json", new MediaType().example(movieService.getMovies(id)))); // Set the movies as an example for the response content
        return ResponseEntity.ok(response);


    }
    @DeleteMapping("/deletemovie/{id}")
    @Operation(summary = "Delete the movie details by id", description = "Delete the movie details from database by movie id")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovies(id);
    }
}

