package com.sapient.demo.SearchEngine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sapient.demo.SearchEngine.model.Theater;


public interface TheaterRepository extends MongoRepository<Theater, Long> {
    List<Theater> findByName(String inputStr);

    Theater findByTheaterId(Long tid);

    @Query(value = "{'movies._id': ?0}", fields = "{'movies' : 0}")
    List<Theater> findTheaterByMovieId(Long movieId);
}
