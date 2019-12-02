package com.sapient.movie.selectapi.controller;

import com.sapient.movie.selectapi.model.Movie;
import com.sapient.movie.selectapi.model.Seat;
import com.sapient.movie.selectapi.model.Show;
import com.sapient.movie.selectapi.model.Theatre;
import com.sapient.movie.selectapi.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/add/movie")
    public void addMovie(@RequestBody Movie movie){
        adminService.addMovie(movie);
    }
    @PostMapping("/add/theatre")
    public void addTheater(@RequestBody Theatre theatre){
        adminService.addTheatre(theatre);
    }
    @PostMapping("/add/show")
    public void addShow(@RequestBody Show show){
        adminService.addShow(show);
    }
    @PostMapping("/add/seat")
    public void addSeat(@RequestBody Seat seat){

    }
}
