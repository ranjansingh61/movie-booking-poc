package com.sapient.movie.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private long movieId;
    private String name;
    private String genre;
    private Date date;
    private String duration;
    private String trailer;
    private Theater theater;
}
