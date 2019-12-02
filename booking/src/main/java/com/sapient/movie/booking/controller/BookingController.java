package com.sapient.movie.booking.controller;

import com.sapient.KafkaFirst.model.Movie;
import com.sapient.movie.booking.model.MovieDetails;
import com.sapient.movie.booking.service.BookingService;
import com.sapient.movie.booking.service.KafkaService;
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
    private BookingService bookingService;
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/bookedMovie")
    public MovieDetails getBookedMovie() {
        Movie movie = bookingService.getBookedMovie();
        int totalPrice = bookingService.computePriceForAssignedSeat(movie.getSeats());
        MovieDetails movieDetails = bookingService.transformMovieDetailsData(movie, totalPrice);
        return movieDetails;
    }

}
