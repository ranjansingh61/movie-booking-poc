package com.sapient.demo.SearchEngine.controller;

import com.sapient.demo.SearchEngine.DTO.MovieRequest;
import com.sapient.demo.SearchEngine.model.Movie;
import com.sapient.demo.SearchEngine.model.Seat;
import com.sapient.demo.SearchEngine.model.Theater;
import com.sapient.demo.SearchEngine.service.KafkaProducerService;
import com.sapient.demo.SearchEngine.service.SelectionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/select")
public class SelectController {

    @Autowired
    private SelectionServiceImpl selectionService;
    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/movie")
    @ApiOperation(value = "Select a Movie", notes = "")
    public Movie selectMovie(@RequestParam("mid") Long mid) {
        Movie movie = selectionService.getSelectedMovie(mid);
        return movie;
    }

    @GetMapping("/theater")
    @ApiOperation(value = "Select a Theater", notes = "")
    public Theater selectTheater(@RequestParam("tid") Long tid) {
        Theater theater = selectionService.getSelectedTheater(tid);
        return theater;
    }

    @GetMapping("/available/seat")
    @ApiOperation(value = "Selected  Seats", notes = "")
    public List<Seat> getAvailableSeats(@RequestBody List<Integer> seatId) {
        return selectionService.availableSeats(true);
    }

    @PostMapping("/seat")
    @ApiOperation(value = "Selected  Seats", notes = "")
    public MovieRequest getSelectedSeats(
            @RequestParam("tid") Long tid,
            @RequestParam("mid") Long mid,
            @RequestBody List<Seat> seats) {
        MovieRequest movieRequest = selectionService.prepareRequestForBooking(tid, mid, seats);
        producerService.sendMessage(movieRequest);
        return movieRequest;
    }
}
