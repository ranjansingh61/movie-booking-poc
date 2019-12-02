package com.sapient.demo.SearchEngine.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class MovieRequest {
    private Long movieId;
    private String name;
    private String genre;
    private String duration;
    private String trailer;
    private String releaseDate;
    private TheaterRequest theater;
}
