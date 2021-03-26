package com.cognizant.SR.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao{
	
	public static List<Movie> moviesList = new ArrayList<>();
	
	public MovieDaoImpl() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("moviecrusier.xml");
		moviesList = (List<Movie>) ctx.getBean("movieList");
	}

	@Override
	public List<Movie> getAllMovies() {
		
		return moviesList;
	}

	@Override
	public void editMovies(Movie movie) {
		try {
			Movie movieget = getMovieById(movie.getId());
			movieget.setMovieTitle(movie.getMovieTitle());
			movieget.setBoxOffice(movie.getBoxOffice());
			movieget.setGenre(movie.getGenre());
			movieget.setTeaser(movie.isTeaser());
			movieget.setActive(movie.isActive());
			movieget.setDateOfLaunch(movie.getDateOfLaunch());
		} catch (MovieNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Movie getMovieById(int id) throws MovieNotFoundException {
		for(Movie movie : moviesList) {
			if (id == movie.getId()) {
				return movie;
				
			}
		}
		throw new MovieNotFoundException("Sorry Movie Not Found");
	}

}
