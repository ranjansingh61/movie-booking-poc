package com.sapient.demo.SearchEngine.service;

import com.sapient.demo.SearchEngine.DTO.MovieRequest;
import com.sapient.demo.SearchEngine.DTO.TheaterRequest;
import com.sapient.demo.SearchEngine.model.*;
import com.sapient.demo.SearchEngine.repository.MovieRepository;
import com.sapient.demo.SearchEngine.repository.SeatRepository;
import com.sapient.demo.SearchEngine.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectionServiceImpl {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private SeatRepository seatRepository;

    public Movie getSelectedMovie(Long mid) {
        return movieRepository.findByMovieId(mid);
    }

    public Theater getSelectedTheater(Long tid) {
        return theaterRepository.findByTheaterId(tid);
    }

    public List<Seat> availableSeats(boolean isAvailable) {
        return seatRepository.findAvailableSeats(isAvailable);
    }

    public List<Seat> updateSeat(List<Seat> seats) {
        List<Seat> selectedSeats = seats.stream().map(seat -> {
            seat.setAvailable(false);
            return seat;
        }).collect(Collectors.toList());
        seatRepository.saveAll(selectedSeats);
        return selectedSeats;
    }

    public MovieRequest prepareRequestForBooking(Long tid, Long mid, List<Seat> seats) {
        Movie selectedMovie = getSelectedMovie(mid);
        Theater selectedTheater = selectedMovie.getTheaters().stream().filter(th -> th.getTheaterId().equals(tid)).collect(Collectors.toList()).get(0);
        List<Seat> selectedSeats = updateSeat(seats);
        return createMovieRequest(selectedMovie, selectedTheater, selectedSeats);
    }

    private MovieRequest createMovieRequest(Movie movie, Theater theater, List<Seat> seats) {
        TheaterRequest tRequest = TheaterRequest.builder()
                .theaterId(theater.getTheaterId())
                .name(theater.getName())
                .address(theater.getAddress())
                .showTimings(theater.getShowTimings())
                .assignedSeats(seats)
                .build();
        return MovieRequest.builder()
                .movieId(movie.getMovieId())
                .name(movie.getName())
                .genre(movie.getGenre())
                .duration(movie.getDuration())
                .trailer(movie.getTrailer())
                .releaseDate(movie.getReleaseDate())
                .theater(tRequest)
                .build();
    }
}
