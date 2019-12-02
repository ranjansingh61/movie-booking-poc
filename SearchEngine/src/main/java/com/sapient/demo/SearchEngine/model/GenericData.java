package com.sapient.demo.SearchEngine.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenericData {
	private List<Movie> movies;
	private List<Theater> theaters;

}
