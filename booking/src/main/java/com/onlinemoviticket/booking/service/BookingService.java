package com.onlinemoviticket.booking.service;

import com.onlinemoviticket.booking.entity.Booking;
import com.onlinemoviticket.booking.entity.Show;
import com.onlinemoviticket.booking.entity.ShowSeats;
import com.onlinemoviticket.booking.repository.BookingRepository;
import com.onlinemoviticket.booking.repository.ShowRepository;
import com.onlinemoviticket.booking.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private  ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private BookingRepository bookingRepository;

  public List<String> getAvailableSeats(int showId) {
        List<String> show = showSeatRepository.findAvailableSeatsByShowId(showId);
        return show;
    }

    public Booking bookTickets(Long theaterId, LocalDate showDate, LocalTime showTime, List<String> seatNames) {
        // 1. Find the Show
        Show show = showRepository.findShow(theaterId, showTime, showDate)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // 2. Check seat availability
        List<ShowSeats> availableSeats = showSeatRepository.findAvailableSeats(show.getId(), seatNames);
        if (availableSeats.size() != seatNames.size()) {
            throw new RuntimeException("Some seats are already booked");
        }

        // 3. Calculate total price
       // double totalPrice = availableSeats.size() * show.getPrice();
        double originalPrice = availableSeats.size() * show.getPrice();
        double discountedPrice = originalPrice;
        // Apply 50% discount for the third ticket
        if (seatNames.size() >= 3) {
            double thirdTicketDiscount = originalPrice / seatNames.size()* 0.5;
            discountedPrice -= thirdTicketDiscount;
        }
        // Apply 20% discount for afternoon shows
        LocalTime afternoonStart = LocalTime.of(12, 0);
        LocalTime afternoonEnd = LocalTime.of(16, 0);
        if (show.getShowTime().isAfter(afternoonStart) && show.getShowTime().isBefore(afternoonEnd)) {
            discountedPrice *= 0.8;
        }



        // 4. Save Booking
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setSeatsBooked(seatNames.size());
        booking.setTotalPrice(BigDecimal.valueOf(discountedPrice));
        booking.setBookingTime(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);

        // 5. Mark seats as 'booked'
        for (ShowSeats seat : availableSeats) {
            seat.setSeatType("booked");
        }
        showSeatRepository.saveAll(availableSeats);

        return savedBooking;
    }
}

