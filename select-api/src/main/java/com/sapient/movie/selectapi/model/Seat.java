package com.sapient.movie.selectapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Seat {
    @Id
    private int seatId;
    private SeatType type;
    private int price;
    @JsonIgnore
    private boolean available;
}
