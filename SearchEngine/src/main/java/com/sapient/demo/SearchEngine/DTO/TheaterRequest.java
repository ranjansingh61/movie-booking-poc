package com.sapient.demo.SearchEngine.DTO;

import com.sapient.demo.SearchEngine.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TheaterRequest {
    private Long theaterId;
    private String name;
    private String address;
    private String showTimings;
    private List<Seat> assignedSeats;
}
