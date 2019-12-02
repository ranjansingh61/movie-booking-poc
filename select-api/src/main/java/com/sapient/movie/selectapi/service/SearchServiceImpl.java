package com.sapient.movie.selectapi.service;

import com.sapient.movie.selectapi.model.Movie;
import com.sapient.movie.selectapi.model.Theatre;
import com.sapient.movie.selectapi.repository.MovieRepository;
import com.sapient.movie.selectapi.repository.TheatreRepository;
import com.sapient.movie.selectapi.response.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    public SearchResponse getAllData(String input) {
        List<Movie> movies = movieRepository.findByName(input);
        List<Theatre> theatres = theatreRepository.findByName(input);
        return SearchResponse.builder()
                .movies(movies)
                .theatres(theatres)
                .build();
    }
}
