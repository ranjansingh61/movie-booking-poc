package com.sapient.movie.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetails {
    private Movie movie;
    private List<Seat> seat;
    private int totalBill;
}
