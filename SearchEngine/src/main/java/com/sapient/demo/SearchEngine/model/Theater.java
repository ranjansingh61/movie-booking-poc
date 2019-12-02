package com.sapient.demo.SearchEngine.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Theater {
	@Id
	private Long theaterId;
	private String name;
	private String address;
	private List<Show> showTimings;
	private Movie movies;
	private List<Seat> seats;
}
