package com.sapient.movie.selectapi.repository;

import com.sapient.movie.selectapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie,Integer> {

    List<Movie> findByName(String input);
    Movie findByMovieId(int movieId);
}
