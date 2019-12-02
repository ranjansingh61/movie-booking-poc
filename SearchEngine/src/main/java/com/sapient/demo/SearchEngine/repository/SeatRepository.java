package com.sapient.demo.SearchEngine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.demo.SearchEngine.model.Seat;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SeatRepository extends MongoRepository<Seat, Integer> {
    @Query(value = "{'available': ?0}")
    List<Seat> findAvailableSeats(boolean isAvailable);
}
