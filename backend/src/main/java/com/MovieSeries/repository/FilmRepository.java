package com.MovieSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MovieSeries.models.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
