package com.MovieSeries.ExceptionHandling;

public class FilmNotFoundException extends RuntimeException {

	public FilmNotFoundException(String message) {
		super(message);
	}
}
