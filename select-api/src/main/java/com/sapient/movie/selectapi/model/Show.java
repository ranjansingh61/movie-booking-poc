package com.sapient.movie.selectapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Show {
    @Id
    private int showId;
    private String startDate;
    private String endDate;
    @JsonIgnore
    private String showTiming;
    @JsonIgnore
    private List<Integer> theatreIds;

    private List<Seat> seats;
}
