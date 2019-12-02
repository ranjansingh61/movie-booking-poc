package com.sapient.movie.selectapi.service;

import com.sapient.movie.selectapi.model.Movie;
import com.sapient.movie.selectapi.model.Show;
import com.sapient.movie.selectapi.model.Theatre;
import com.sapient.movie.selectapi.repository.MovieRepository;
import com.sapient.movie.selectapi.repository.ShowRepository;
import com.sapient.movie.selectapi.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void addTheatre(Theatre theatre) {
        theatreRepository.save(theatre);
    }

    public void addShow(Show show) {
        showRepository.save(show);
    }
}
