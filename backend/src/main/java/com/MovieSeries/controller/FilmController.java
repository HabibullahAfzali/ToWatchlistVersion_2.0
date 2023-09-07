package com.MovieSeries.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MovieSeries.model.Film;
import com.MovieSeries.services.FilmService;

@RestController
@CrossOrigin("*")
@RequestMapping("/films")


public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping
    public Film saveFilm(@RequestBody Film film) {

        return (filmService.save(film));
    }

    @GetMapping("/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {

        return filmService.findById(id);
    }

    @GetMapping
    public List<Film> findAll() {

        return filmService.findAll();
    }

    @PutMapping("/{id}")
    public Film updateFilmById(@PathVariable Long id, @RequestBody Film filmDetails) {

        return filmService.updateFilmById(id, filmDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        filmService.deleteById(id);
    }

}