package com.movieticketbooking.movieservice.exception;

public class TheaterNotFoundException extends RuntimeException {
    public TheaterNotFoundException(int id) {
        super("Movie not found with id: " + id);
    }
}
