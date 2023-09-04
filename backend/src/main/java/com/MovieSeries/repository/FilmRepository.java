package com.MovieSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MovieSeries.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
