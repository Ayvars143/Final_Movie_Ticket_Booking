package com.movieticketbooking.theatreservice.srevice;

import com.movieticketbooking.theatreservice.entity.Theatre;
import com.movieticketbooking.theatreservice.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {

        return theatreRepository.findAll();
    }

    public int validation(Theatre theater) {
        List<Theatre> findTheater= theatreRepository.findByName(theater.getName());
        return findTheater.size();
    }

    public ResponseEntity<String> deleteTheater(Long id) {
        if (theatreRepository.findById(id).isPresent()) {
            theatreRepository.deleteById(id);
            return ResponseEntity.ok(" Theater is Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Theater is not found");
        }
    }
}

