package com.sapient.movie.seatSelection.controller;

import com.sapient.movie.seatSelection.model.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/seat")
public class seatSelectionController {
    @GetMapping("/getSelected")
    public List<Seat> getSelectedSeat() {
        List<Seat> assignedSeats = prepareData();
        return assignedSeats;
    }

    public List<Seat> prepareData() {
        return Arrays.asList(new Seat(1, "Premium", 500),
                new Seat(2, "Premium", 500),
                new Seat(15, "Gold", 300));
    }
}
