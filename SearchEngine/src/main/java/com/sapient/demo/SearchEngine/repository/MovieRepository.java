package com.sapient.demo.SearchEngine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.demo.SearchEngine.model.Movie;
import org.springframework.data.mongodb.repository.Query;


public interface MovieRepository extends MongoRepository<Movie, Long> {

    List<Movie> findByName(String inputStr);
   // @Query(value = "{'_id': ?0}")
    Movie findByMovieId(Long mid);
}
