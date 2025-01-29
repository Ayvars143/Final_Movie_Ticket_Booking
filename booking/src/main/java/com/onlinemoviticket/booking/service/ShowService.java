package com.onlinemoviticket.booking.service;

import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Long showId, Show updatedShow) {
        Optional<Show> existingShow = showRepository.findById(Math.toIntExact(showId));
        if (existingShow.isPresent()) {
            Show show = existingShow.get();
            show.setMovie(updatedShow.getMovie());
            show.setTheater(updatedShow.getTheater());
            show.setShowDate(updatedShow.getShowDate());
            show.setShowTime(updatedShow.getShowTime());
            show.setPrice(updatedShow.getPrice());
            return showRepository.save(show);
        } else {
            throw new RuntimeException("Show not found with ID: " + showId);
        }
    }

    public void deleteShow(Long showId) {
        showRepository.deleteById(Math.toIntExact(showId));
    }

    public List<Show> getShowsForTheater(Long theaterId, LocalDate showDate) {
        return showRepository.findByTheaterIdAndShowDate(theaterId, showDate);
    }
}
