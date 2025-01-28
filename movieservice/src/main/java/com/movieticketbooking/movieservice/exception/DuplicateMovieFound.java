package com.movieticketbooking.movieservice.exception;

public class DuplicateMovieFound extends RuntimeException {
    public DuplicateMovieFound(int id) {
        super("Duplicate movie found for id: " + id);
    }
}
