package com.sapient.movie.selectapi.repository;

import com.sapient.movie.selectapi.model.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat,Integer> {
}
