package com.sapient.movie.selectapi.controller;

import com.sapient.movie.selectapi.criteria.SelectionCriteria;
import com.sapient.movie.selectapi.dto.MovieDTO;
import com.sapient.movie.selectapi.service.KafkaServiceImpl;
import com.sapient.movie.selectapi.service.SelectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class SelectionController {
    @Autowired
    private SelectionServiceImpl selectionService;

    @Autowired
    private KafkaServiceImpl kafkaService;
    @PostMapping("/movie")
    public MovieDTO bookMovie(@RequestBody SelectionCriteria sc){
        MovieDTO movie = selectionService.bookMovie(sc);
        kafkaService.sendMessageToKafka(movie);
        return movie;
    }

}
