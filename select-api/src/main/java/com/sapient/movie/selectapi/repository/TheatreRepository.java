package com.sapient.movie.selectapi.repository;

import com.sapient.movie.selectapi.model.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, Integer> {
    List<Theatre> findByName(String input);
    Theatre findByTheaterId(int theatreId);
}
