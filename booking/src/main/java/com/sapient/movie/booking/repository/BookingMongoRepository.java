package com.sapient.movie.booking.repository;

import com.sapient.KafkaFirst.model.Movie;
import com.sapient.movie.booking.model.MovieDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMongoRepository extends MongoRepository<Movie,Long> {
}
