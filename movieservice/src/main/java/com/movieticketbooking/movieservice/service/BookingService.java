package com.movieticketbooking.movieservice.service;

import com.movieticketbooking.movieservice.entity.Booking;
import com.movieticketbooking.movieservice.entity.ShowTiming;
import com.movieticketbooking.movieservice.model.DiscountResponse;
import com.movieticketbooking.movieservice.repository.BookingRepository;
import com.movieticketbooking.movieservice.repository.ShowTimingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowTimingRepository showTimingRepository;

    public List<ShowTiming> getAvailableShowTimings(Long movieId, Long theatreId, LocalDate showDate) {
        return showTimingRepository.findByMovieIdAndTheatreIdAndShowDate(movieId, theatreId, showDate);
    }


    public DiscountResponse calculateDiscount(Booking booking) {
        double originalPrice = booking.getTotalAmount();
        double discountedPrice = originalPrice;

        // Apply 50% discount for the third ticket
        if (booking.getTicketCount() >= 3) {
            double thirdTicketDiscount = originalPrice / booking.getTicketCount() * 0.5;
            discountedPrice -= thirdTicketDiscount;
        }

        // Apply 20% discount for afternoon shows
        LocalTime afternoonStart = LocalTime.of(12, 0);
        LocalTime afternoonEnd = LocalTime.of(16, 0);

        if (booking.getShowTime().isAfter(afternoonStart) && booking.getShowTime().isBefore(afternoonEnd)) {
            discountedPrice *= 0.8;
        }

        String message = "Discount applied successfully";
        return new DiscountResponse(originalPrice, discountedPrice, message);
    }
}

