package com.sapient.movie.selectapi.service;

import com.sapient.movie.selectapi.criteria.SelectionCriteria;
import com.sapient.movie.selectapi.dto.MovieDTO;
import com.sapient.movie.selectapi.dto.TheatreDTO;
import com.sapient.movie.selectapi.model.Movie;
import com.sapient.movie.selectapi.model.Seat;
import com.sapient.movie.selectapi.model.Show;
import com.sapient.movie.selectapi.model.Theatre;
import com.sapient.movie.selectapi.repository.MovieRepository;
import com.sapient.movie.selectapi.repository.ShowRepository;
import com.sapient.movie.selectapi.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectionServiceImpl {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ShowRepository showRepository;

    public MovieDTO bookMovie(SelectionCriteria sc) {
        Movie movie = movieRepository.findByMovieId(sc.getMovieId());
        Theatre theatre = theatreRepository.findByTheaterId(sc.getTheatreId());
        Show show = showRepository.findByShowId(sc.getShowId());
        List<Seat> seats = show.getSeats().stream()
                .filter(seat -> sc.getSeatIds().stream().anyMatch(bs -> bs.equals(seat.getSeatId())))
                .collect(Collectors.toList());
        updateSeatStatus();
        show.setSeats(seats);
        MovieDTO mDTO = getMovieDTO(movie, theatre, show);
        return mDTO;
    }

    private MovieDTO getMovieDTO(Movie movie, Theatre theatre, Show show) {
        TheatreDTO tDTO = TheatreDTO.builder()
                .theaterId(theatre.getTheaterId())
                .name(theatre.getName())
                .address(theatre.getAddress())
                .showTiming(show)
                .build();
        return MovieDTO.builder()
                .movieId(movie.getMovieId())
                .name(movie.getName())
                .theater(tDTO)
                .build();
    }

    private void updateSeatStatus() {
      //s  Show show = showRepository.save();
    }

}
