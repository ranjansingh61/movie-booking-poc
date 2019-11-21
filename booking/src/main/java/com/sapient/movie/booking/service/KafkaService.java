package com.sapient.movie.booking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sapient.KafkaFirst.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaService {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private MongoService mongoService;

    @KafkaListener(topics = "kafkaDemoTopic", groupId = "group_id")
    public void consume(Movie movie) {
        mongoService.save(movie);
    }
}
