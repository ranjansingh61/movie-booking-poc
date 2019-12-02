package com.sapient.movie.selectapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Theatre {
    @Id
    private int theaterId;
    private String name;
    private String address;
    private List<Integer> showIds;
    private int movieId;
}
