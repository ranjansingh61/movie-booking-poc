package com.sapient.movie.selectapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Movie {
    @Id
    private int movieId;
    private String name;
    private String genre;
    private String duration;
    private String trailer;
    private Date releaseDate;
    private List<Integer> theatreIds;

}
