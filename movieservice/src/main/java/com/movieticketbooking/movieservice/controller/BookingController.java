package com.movieticketbooking.movieservice.controller;



import com.movieticketbooking.movieservice.entity.Booking;
import com.movieticketbooking.movieservice.entity.ShowTiming;
import com.movieticketbooking.movieservice.model.DiscountResponse;
import com.movieticketbooking.movieservice.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
   /* @GetMapping("/available-show-timings")
    public List<ShowTiming> getAvailableShowTimings(@RequestParam Long movieId,
                                                    @RequestParam Long theatreId,
                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate showDate) {
        Date sqlShowDate = Date.valueOf(showDate);
        return bookingService.getAvailableShowTimings(movieId, theatreId, showDate);
    }*/


    @PostMapping("/calculate-discount")
    @Operation(summary = "Get discounted price", description = "•\tBooking platform" +
            " offers in selected cities and theatres\n" +
            "o\t50% discount on the third ticket\n" +
            "o\tTickets booked for the afternoon show get a 20% discount\n")
    public DiscountResponse calculateDiscount(@RequestBody Booking booking) {
        return bookingService.calculateDiscount(booking);
    }
}

