package com.sapient.movie.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class SeatResponse {
    List<Seat> seats;
}
