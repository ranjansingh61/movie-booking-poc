package com.sapient.demo.SearchEngine.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Movie {

	@Id
	private Long movieId;
	private String name;
	private String genre;
	private String duration;
	private String trailer;
	private String releaseDate;
	private List<Theater> theaters;

}
