package com.onlinemoviticket.booking.service;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShowsByTheater(int theaterId) {
        return showRepository.findAvailableShowsByTheater(theaterId);
    }
}
