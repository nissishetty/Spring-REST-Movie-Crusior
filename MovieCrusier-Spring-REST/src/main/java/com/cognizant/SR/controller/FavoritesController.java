package com.cognizant.SR.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SR.MovieCrusierSpringRestApplication;
import com.cognizant.SR.exceptions.FavoritesEmptyException;
import com.cognizant.SR.exceptions.MovieNotFoundException;
import com.cognizant.SR.model.Favorites;
import com.cognizant.SR.model.Movie;
import com.cognizant.SR.service.FavoritesService;

@RestController
public class FavoritesController {
	
	private static Logger log= LoggerFactory.getLogger(MovieCrusierSpringRestApplication.class);
	
	@Autowired
	private FavoritesService favoritesService;
	
	@GetMapping("/customer-movie-list")
	public List<Movie> getAllMoviesCustomer() {
		return favoritesService.cusGetAllMovie();
	}
	
	@GetMapping("/allFav-movies/{userId}")
	public Favorites getAllFavorites(@PathVariable int userId) throws FavoritesEmptyException{
		log.info("Start get favorites");
		return favoritesService.getAllFavorites(userId);
	}
	
	@PostMapping("/add-fav/{userId}/{movieId}")
	public ResponseEntity<String> addToFavorites(@PathVariable int userId, @PathVariable int movieId) throws MovieNotFoundException {
		log.info("Start adding to favorites");
		favoritesService.addToFavorites(userId, movieId);
		return ResponseEntity.status(HttpStatus.OK).body("Movie added to fav user ID :"+userId+"Movie ID :"+movieId);
	}
	
	@DeleteMapping("/remove-fav/{userId}/{movieId}")
	public void removeFavMovie(@PathVariable int userId, @PathVariable int movieId) throws FavoritesEmptyException{
		log.info("Start delete from favorites");
		favoritesService.removeFavMovie(userId, movieId);
	}

}
