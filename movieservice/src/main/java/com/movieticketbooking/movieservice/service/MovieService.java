package com.movieticketbooking.movieservice.service;

import com.movieticketbooking.movieservice.entity.Movie;
import com.movieticketbooking.movieservice.exception.MovieNotFoundException;
import com.movieticketbooking.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public int validation(Movie movies) {
        List<Movie> findMovie = movieRepository.findByTitle(movies.getTitle());
        System.out.println(findMovie.size());
        return findMovie.size();
    }


    public ResponseEntity<Movie> addMovie(Movie movies) {
        if (movies.getTitle() == null || movies.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be null or empty");
        }

        Movie movieSaveRepo = new Movie();
        movieSaveRepo.setId(movies.getId());
        movieSaveRepo.setReleaseDate(movies.getReleaseDate());
        movieSaveRepo.setGenre(movies.getGenre());
        movieSaveRepo.setTitle(movies.getTitle());
        movieSaveRepo.setDescription(movies.getDescription());


        if (validation(movies) == 0) {
            movieSaveRepo = movieRepository.save(movies);
            return new ResponseEntity<>(movieSaveRepo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("Movies fetched from DB: " + movies);
        return movies;
    }

    public Movie getMovies(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(Math.toIntExact(id)));
    }

    public ResponseEntity<Movie> updateMovies(Long id, Movie updatedMovies) {
        return movieRepository.findById(id)
                .map(movies -> {
                    if (validation(updatedMovies) == 0) {
                        movies.setId(updatedMovies.getId());
                        movies.setTitle(updatedMovies.getTitle());
                        movies.setGenre(updatedMovies.getGenre());
                        movies.setDescription(updatedMovies.getDescription());
                        movies.setReleaseDate(updatedMovies.getReleaseDate());

                        movieRepository.save(movies);
                        return new ResponseEntity<>(movies, HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>(movies, HttpStatus.CONFLICT);
                    }
                }).orElseThrow(() -> new MovieNotFoundException(Math.toIntExact(id)));

    }

    public ResponseEntity<String> deleteMovies(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return ResponseEntity.ok(" Movie is Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }
}

