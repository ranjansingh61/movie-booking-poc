package com.sapient.movie.booking.service;

import com.sapient.KafkaFirst.model.Movie;
import com.sapient.movie.booking.repository.BookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
    @Autowired
    private BookingMongoRepository mongoRepository;

   public void save(Movie movie){
       mongoRepository.save(movie);
    }

    public List<Movie> findAll(){
        return mongoRepository.findAll();
    }
}
