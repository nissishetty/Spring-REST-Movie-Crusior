package com.cognizant.SR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.SR.dao.MovieDao;
import com.cognizant.SR.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;
	
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}
	
	public void editMovies(Movie movie) {
		movieDao.editMovies(movie);
	}
}
