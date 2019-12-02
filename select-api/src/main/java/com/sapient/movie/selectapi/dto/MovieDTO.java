package com.sapient.movie.selectapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    private int movieId;
    private String name;
    private String genre;
    private String duration;
    private String trailer;
    private String releaseDate;
    private TheatreDTO theater;
}