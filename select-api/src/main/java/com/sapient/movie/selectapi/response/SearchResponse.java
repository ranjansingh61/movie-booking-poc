package com.sapient.movie.selectapi.response;

import com.sapient.movie.selectapi.model.Movie;
import com.sapient.movie.selectapi.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResponse {
    private List<Movie> movies;
    private List<Theatre> theatres;
}
