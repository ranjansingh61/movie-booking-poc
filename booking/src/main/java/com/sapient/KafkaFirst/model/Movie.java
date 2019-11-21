package com.sapient.KafkaFirst.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@NoArgsConstructor
@Document
public class Movie  {
    @Id
    private long movieId;
    private String name;
    private String genre;
    private Date date;
    private String duration;
    private String trailer;
    private Theater theater;
}
