package com.sapient.demo.SearchEngine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.demo.SearchEngine.model.GenericData;
import com.sapient.demo.SearchEngine.model.Movie;
import com.sapient.demo.SearchEngine.model.Seat;
import com.sapient.demo.SearchEngine.model.Theater;
import com.sapient.demo.SearchEngine.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Online Ticket Booking", description = "Search Catalog")
public class SearchEngineController {

    @Autowired
    private SearchService service;

    @GetMapping("/search")
    @ApiOperation(value = "Search Catalog API", notes = "")
    public GenericData find(@RequestParam("input") String input) {
        return service.performGenericSearch(input);
    }

    @PostMapping("add/seat")
    @ApiOperation(value = "Seat API", notes = "")
    public String addSeats(@RequestBody Seat seat) {
        service.addSeat(seat);
        return "Seats added successfully";
    }

    @PostMapping("add/movie")
    @ApiOperation(value = "Movies API", notes = "")
    public String addMovies(@RequestBody Movie m) {
        service.addMovie(m);
        return "Movies added successfully";
    }

    @PostMapping("add/theater")
    @ApiOperation(value = "Theater API", notes = "")
    public String addTheater(@RequestBody Theater t) {
        service.addTheater(t);
        return "Theater added successfully";
    }

}
