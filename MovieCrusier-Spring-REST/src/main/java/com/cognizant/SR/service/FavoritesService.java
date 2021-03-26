package com.cognizant.SR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.SR.dao.FavoritesDao;
import com.cognizant.SR.exceptions.FavoritesEmptyException;
import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Favorites;
import com.cognizant.SR.model.Movie;

@Service
public class FavoritesService {
	
	@Autowired
	private FavoritesDao favoritesDao;
	
	public List<Movie> cusGetAllMovie() {
		return favoritesDao.cusMovieList();
	}
	
	public void addToFavorites(int userId, int movieId) throws MovieNotFoundException {
		favoritesDao.addToFavorites(userId, movieId);
	}
	public Favorites getAllFavorites(int userId) throws FavoritesEmptyException {
		return favoritesDao.getAllFavorites(userId);
	}
	public void removeFavMovie(int userId, int movieId) throws FavoritesEmptyException{
		favoritesDao.removeFavMovie(userId, movieId);
	}

}
