package com.cognizant.SR.model;

import java.util.Date;

import lombok.Data;

@Data
public class Movie {
	private int id;
	private String movieTitle;
	private double boxOffice;
	private String genre;
	private boolean teaser;	
	private boolean active;	
	private Date dateOfLaunch;

}
