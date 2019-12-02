package com.sapient.demo.SearchEngine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.demo.SearchEngine.model.GenericData;
import com.sapient.demo.SearchEngine.model.Movie;
import com.sapient.demo.SearchEngine.model.Seat;
import com.sapient.demo.SearchEngine.model.Theater;


@Service
public interface SearchService {

	public List<Movie> loadMovies();

	public GenericData performGenericSearch(String inputStr);

	public void addSeat(Seat s);

	public void addMovie(Movie m);

	public void addTheater(Theater t);
	
	public List<Theater> getTheater(Long movieId);

}
