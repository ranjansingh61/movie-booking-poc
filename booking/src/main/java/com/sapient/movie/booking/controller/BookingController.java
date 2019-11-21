package com.sapient.movie.booking.controller;

import com.sapient.KafkaFirst.model.Movie;
import com.sapient.movie.booking.model.MovieDetails;
import com.sapient.movie.booking.model.Seat;
import com.sapient.movie.booking.service.BookingService;
import com.sapient.movie.booking.service.KafkaService;
import com.sapient.movie.booking.service.SeatSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class BookingController {
    @Autowired
    private SeatSelectionService seatSelectionService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/bookedMovie")
    public MovieDetails getBookedMovie() {
        Movie movie = bookingService.getBookedMovie();
        List<Seat> assignedSeats = prepareData();//seatSelectionService.assignSeatsToUser();
        int totalPrice = seatSelectionService.computePriceForAssignedSeat(assignedSeats);
        MovieDetails movieDetails = bookingService.transformMovieDetailsData(movie, assignedSeats, totalPrice);
        return movieDetails;
    }

    public List<Seat> prepareData() {
        return Arrays.asList(new Seat(1, "Premium", 500),
                new Seat(2, "Premium", 500),
                new Seat(15, "Gold", 300));
    }
}
