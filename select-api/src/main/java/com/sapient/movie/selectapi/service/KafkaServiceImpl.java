package com.sapient.movie.selectapi.service;

import com.sapient.movie.selectapi.dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);
    private static final String MOVIE_SELECTION_TOPIC = "movieBookingTopic";

    @Autowired
    private KafkaTemplate<String, MovieDTO> kafkaTemplate;

    public void sendMessageToKafka(MovieDTO message) {
        logger.info("produced response  -> {}",message);
        this.kafkaTemplate.send(MOVIE_SELECTION_TOPIC,message);
    }
}
