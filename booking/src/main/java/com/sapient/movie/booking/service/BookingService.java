package com.sapient.movie.booking.service;

import com.sapient.KafkaFirst.model.Movie;
import com.sapient.KafkaFirst.model.Seat;
import com.sapient.movie.booking.model.MovieDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private MongoService mongoService;

    public Movie getBookedMovie() {
        return mongoService.findAll().get(0);
    }

    public int computePriceForAssignedSeat(List<Seat> seats) {
        return seats.stream().map(seat -> seat.getPrice()).reduce(0, Integer::sum);
    }

    public MovieDetails transformMovieDetailsData(Movie movie, int totalPrice) {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovie(movie);
        movieDetails.setTotalBill(totalPrice);
        return movieDetails;
    }
}
