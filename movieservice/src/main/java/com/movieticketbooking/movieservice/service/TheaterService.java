package com.movieticketbooking.movieservice.service;

import com.movieticketbooking.movieservice.entity.Movie;
import com.movieticketbooking.movieservice.entity.Theater;
import com.movieticketbooking.movieservice.exception.MovieNotFoundException;
import com.movieticketbooking.movieservice.exception.TheaterNotFoundException;
import com.movieticketbooking.movieservice.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public int validation(Theater theater) {
        List<Theater> findMovie = theaterRepository.findByName(theater.getName());
        System.out.println(findMovie.size());
        return findMovie.size();
    }


    public ResponseEntity<Theater> addTheater(Theater theater) {
        if (theater.getName() == null || theater.getName().isEmpty()) {
            throw new IllegalArgumentException("Theater name cannot be null or empty");
        }

        Theater theaterSaveRepo = new Theater();
        theaterSaveRepo.setId(theater.getId());
        theaterSaveRepo.setName(theater.getName());
        theaterSaveRepo.setCapacity(theater.getCapacity());
        theaterSaveRepo.setLocation(theater.getLocation());



        if (validation(theater) == 0) {
            theaterSaveRepo = theaterRepository.save(theater);
            return new ResponseEntity<>(theaterSaveRepo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public List<Theater> getAllTheaters() {
        List<Theater> theaters = theaterRepository.findAll();
        System.out.println("Theaters fetched from DB: " + theaters);
        return theaters;
    }
    public Theater getTheaters(Long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new TheaterNotFoundException(Math.toIntExact(id)));
    }
    public ResponseEntity<Theater> updateTheaters(Long id, Theater updatedTheaters) {
        return theaterRepository.findById(id)
                .map(theaters -> {
                    if (validation(updatedTheaters) == 0) {
                        theaters.setId(updatedTheaters.getId());
                        theaters.setName(updatedTheaters.getName());
                        theaters.setCapacity(updatedTheaters.getCapacity());
                        theaters.setLocation(updatedTheaters.getLocation());
                        theaterRepository.save(theaters);

                        return new ResponseEntity<>(theaters, HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>(theaters, HttpStatus.CONFLICT);
                    }
                }).orElseThrow(() -> new TheaterNotFoundException(Math.toIntExact(id)));

    }
    public ResponseEntity<String> deleteTheaters(Long id) {
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return ResponseEntity.ok("Theater is deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Theater not found");
        }
    }

}
