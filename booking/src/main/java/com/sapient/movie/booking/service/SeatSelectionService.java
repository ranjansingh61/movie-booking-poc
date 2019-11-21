package com.sapient.movie.booking.service;

import com.sapient.movie.booking.model.Seat;
import com.sapient.movie.booking.model.SeatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatSelectionService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Seat> assignSeatsToUser() {
        String seatApiEndPoint = "";
        ResponseEntity<SeatResponse> response = restTemplate.exchange(seatApiEndPoint, HttpMethod.GET, null, SeatResponse.class, "cat", 0);
        SeatResponse seatResponse = response.getBody();
        return seatResponse.getSeats();
    }

    public int computePriceForAssignedSeat(List<Seat> seats) {
        List<Integer> prices = seats.stream().map(seat -> seat.getPrice()).collect(Collectors.toList());
        return prices.stream().reduce(0, Integer::sum);
    }
}
