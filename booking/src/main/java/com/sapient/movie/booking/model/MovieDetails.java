package com.sapient.movie.booking.model;

import com.sapient.KafkaFirst.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MovieDetails {
    @Id
    private String movieDetailsId;
    private Movie movie;
    private int totalBill;
    private Status status;
    private String paymentRef;
}
