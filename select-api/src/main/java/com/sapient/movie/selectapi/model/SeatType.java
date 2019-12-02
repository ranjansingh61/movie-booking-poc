package com.sapient.movie.selectapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SeatType {
    SILVER,GOLD,PLATINUM
}

