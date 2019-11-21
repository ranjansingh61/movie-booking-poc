package com.sapient.KafkaFirst.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Theater {
    private long theaterId;
    private String name;
    private String address;
}