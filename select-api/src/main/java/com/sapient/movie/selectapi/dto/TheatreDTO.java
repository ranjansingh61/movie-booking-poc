package com.sapient.movie.selectapi.dto;

import com.sapient.movie.selectapi.model.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TheatreDTO {
    private int theaterId;
    private String name;
    private String address;
    private Show showTiming;
}
