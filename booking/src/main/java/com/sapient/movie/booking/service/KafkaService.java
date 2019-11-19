package com.sapient.movie.booking.service;

import com.sapient.movie.booking.model.Movie;
import com.sapient.movie.booking.model.Theater;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaService {
    public Movie getBookedMovie() {
// get data from kafka system
        Theater theater = new Theater(21234,"PVR","Banglore");
        Movie movie = new Movie(1234,"Bala","Comedy",new Date(),"2 hr 30 min","trailer",theater);
        return movie;
    }
}
