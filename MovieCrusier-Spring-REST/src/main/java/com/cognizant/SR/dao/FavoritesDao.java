package com.cognizant.SR.dao;

import java.util.List;

import com.cognizant.SR.exceptions.FavoritesEmptyException;
import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Favorites;
import com.cognizant.SR.model.Movie;

public interface FavoritesDao {
	List<Movie> cusMovieList();
	void addToFavorites(int userId, int movieId) throws MovieNotFoundException;
	Favorites getAllFavorites(int userId) throws FavoritesEmptyException;	
	void removeFavMovie(int userId, int movieId) throws FavoritesEmptyException;

}
