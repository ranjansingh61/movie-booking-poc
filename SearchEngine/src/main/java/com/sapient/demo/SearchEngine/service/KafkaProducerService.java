package com.sapient.demo.SearchEngine.service;

import com.sapient.demo.SearchEngine.DTO.MovieRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String MOVIE_SELECTION_TOPIC = "movieSelectionTopic";

    @Autowired
    private KafkaTemplate<String, MovieRequest> kafkaTemplate;

    public void sendMessage(MovieRequest response) {
        logger.info("produced response  -> {}",response);
        this.kafkaTemplate.send(MOVIE_SELECTION_TOPIC,response);
    }

}
