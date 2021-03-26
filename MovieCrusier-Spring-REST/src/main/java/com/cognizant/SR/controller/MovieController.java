package com.cognizant.SR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SR.model.Movie;
import com.cognizant.SR.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/all-movies")
	public List<Movie> getAllmovies() {
		return movieService.getAllMovies();
	}
	
	@PutMapping("/edit-movies")
	public ResponseEntity<String> editMoviesDetails(@RequestBody Movie movie) {
		 movieService.editMovies(movie);
		return ResponseEntity.status(HttpStatus.OK).body("Details Edited Successfully = "+movie);
		
	}
	
	
}
