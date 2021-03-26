package com.cognizant.SR.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Favorites {

	private List<Movie> favoriteList;
	private int total;

}
