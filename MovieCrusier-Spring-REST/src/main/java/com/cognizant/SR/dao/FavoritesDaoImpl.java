package com.cognizant.SR.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.SR.exceptions.FavoritesEmptyException;
import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Favorites;
import com.cognizant.SR.model.Movie;

import lombok.Data;

@Repository
@Data
public class FavoritesDaoImpl implements FavoritesDao {

//	private LinkedHashMap<Integer, Favorites> userFavList;
	private Map<Integer, Favorites> userFavList = new HashMap<>();

	@Autowired
	private MovieDaoImpl movieDaoImpl;

	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> cusMovieList() {

		return movieDaoImpl.getAllMovies();
	}

	@Override
	public void addToFavorites(int userId, int movieId) throws MovieNotFoundException {
		Movie movie = movieDao.getMovieById(movieId);
		if (userFavList.containsKey(userId)) {
			Favorites fav = userFavList.get(userId);
			List<Movie> favMovies = fav.getFavoriteList();
			favMovies.add(movie);
			fav.setFavoriteList(favMovies);
			userFavList.put(userId, fav);
		} else {
			Favorites fav = new Favorites();
			List<Movie> favMovies = new ArrayList<>();
			favMovies.add(movie);
			fav.setFavoriteList(favMovies);
			userFavList.put(userId, fav);
		}

	}

	@Override
	public Favorites getAllFavorites(int userId) throws FavoritesEmptyException {

		Favorites fav = userFavList.get(userId);

		if (fav == null) {
			throw new FavoritesEmptyException("Not Found");
		}

		List<Movie> movieList = fav.getFavoriteList();

		if (movieList == null || movieList.size() < 1)
			throw new FavoritesEmptyException("Not found");
		else {
			int total = 0;
			for (Movie movie : movieList) {
				total++;
			}
			fav.setTotal(total);
		}

		return fav;
	}

	@Override
	public void removeFavMovie(int userId, int movieId) throws FavoritesEmptyException {
		Favorites fav = userFavList.get(userId);

		if (fav == null) {
			throw new FavoritesEmptyException("Not Found");
		}

		List<Movie> movieList = fav.getFavoriteList();

		if (movieList == null || movieList.size() < 1)
			throw new FavoritesEmptyException("Not Found");

		for (Movie movie : movieList) {
			if (movie.getId() == movieId) {
				movieList.remove(movie);
				break;
			}
		}
		fav.setFavoriteList(movieList);
		userFavList.put(userId, fav);

	}

}
