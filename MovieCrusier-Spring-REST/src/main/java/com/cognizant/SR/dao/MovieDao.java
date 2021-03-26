package com.cognizant.SR.dao;

import java.util.List;

import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Movie;

public interface MovieDao {
	List<Movie> getAllMovies();
	void editMovies(Movie movie);
	Movie getMovieById(int id) throws MovieNotFoundException;

}
