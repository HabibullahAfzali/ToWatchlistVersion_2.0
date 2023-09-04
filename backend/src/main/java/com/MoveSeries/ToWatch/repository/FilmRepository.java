package com.MoveSeries.ToWatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MoveSeries.ToWatch.models.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
