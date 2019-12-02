package com.sapient.movie.selectapi.repository;

import com.sapient.movie.selectapi.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show,Integer> {
    Show findByShowId(int showId);
}
