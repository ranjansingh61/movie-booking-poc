package com.sapient.demo.SearchEngine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.demo.SearchEngine.model.GenericData;
import com.sapient.demo.SearchEngine.model.Movie;
import com.sapient.demo.SearchEngine.model.Seat;
import com.sapient.demo.SearchEngine.model.Theater;
import com.sapient.demo.SearchEngine.repository.MovieRepository;
import com.sapient.demo.SearchEngine.repository.SeatRepository;
import com.sapient.demo.SearchEngine.repository.TheaterRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private MovieRepository movieDao;

	@Autowired
	private TheaterRepository theaterDao;

	@Autowired
	private SeatRepository seatDao;

	@Override
	public List<Movie> loadMovies() {
		return movieDao.findAll();
	}

	@Override
	public GenericData performGenericSearch(String inputStr) {
		GenericData data = new GenericData();
		data.setMovies(movieDao.findByName(inputStr));
		data.setTheaters(theaterDao.findByName(inputStr));
		return data;
	}

	@Override
	public void addSeat(Seat s) {
		seatDao.save(s);
	}

	@Override
	public void addMovie(Movie m) {
		movieDao.save(m);
	}

	@Override
	public void addTheater(Theater t) {
		theaterDao.save(t);
	}

	@Override
	public List<Theater> getTheater(Long movieId) {
		return theaterDao.findTheaterByMovieId(movieId);
	}

}
