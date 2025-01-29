package com.onlinemoviticket.booking.controller;

import com.onlinemoviticket.booking.entity.Booking;
import com.onlinemoviticket.booking.repository.BookingRepository;
import com.onlinemoviticket.booking.repository.ShowRepository;
import com.onlinemoviticket.booking.repository.ShowSeatRepository;
import com.onlinemoviticket.booking.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/available-seats")
    @Operation(summary = "Get the list of seats which is available for show  which are available for booking", description = "Fetches the list of seats which are available for booking")
    public ResponseEntity<List<String>> getAvailableSeats(@RequestParam int showId) {
        List<String> availableSeats = bookingService.getAvailableSeats(showId);
        return ResponseEntity.ok(availableSeats);
    }

   @PostMapping("/bookTicket")
   @Operation(summary = "Book the ticket/Mutiple tickets based on the discount scenario", description = "Book the ticket/Mutiple tickets based on the discount scenario")
   public ResponseEntity<Booking> bookTickets(
           @RequestParam Long theaterId,
           @RequestParam LocalDate showDate,
           @RequestParam LocalTime showTime,
           @RequestParam List<String> seatNames) {

       Booking booking = bookingService.bookTickets(theaterId, showDate, showTime, seatNames);
       return ResponseEntity.ok(booking);
   }

}

