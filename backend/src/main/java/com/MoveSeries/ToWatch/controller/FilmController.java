package com.MoveSeries.ToWatch.controller;

import java.util.List;
import java.util.Optional;

import com.MoveSeries.ToWatch.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MoveSeries.ToWatch.models.Film;

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
