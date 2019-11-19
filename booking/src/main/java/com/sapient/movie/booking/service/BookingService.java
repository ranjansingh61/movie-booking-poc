package com.sapient.movie.booking.service;

import com.sapient.movie.booking.model.Movie;
import com.sapient.movie.booking.model.MovieDetails;
import com.sapient.movie.booking.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    public MovieDetails transformMovieDetailsData(Movie movie, List<Seat> assignedSeats, int totalPrice) {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovie(movie);
        movieDetails.setSeat(assignedSeats);
        movieDetails.setTotalBill(totalPrice);
        return movieDetails;
    }
}
