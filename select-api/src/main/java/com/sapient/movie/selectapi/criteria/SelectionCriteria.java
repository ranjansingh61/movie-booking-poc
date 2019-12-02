package com.sapient.movie.selectapi.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class SelectionCriteria {
    private int movieId;
    private int theatreId;
    private int showId;
    private List<Integer> seatIds;
}
