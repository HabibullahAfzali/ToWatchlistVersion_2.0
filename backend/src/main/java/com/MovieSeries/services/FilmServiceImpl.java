package com.MovieSeries.services;

import java.util.List;
import java.util.Optional;

import com.MovieSeries.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MovieSeries.models.Film;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmrepository;

    @Override
    @Transactional(readOnly = true)
    public List<Film> findAll() {
        return filmrepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Film> findById(Long id) {
        return filmrepository.findById(id);
    }

    @Override
    @Transactional
    public Film save(Film film) {
        return filmrepository.save(film);
    }

    @Override
    public void deleteById(Long id) {
        filmrepository.deleteById(id);
    }

    @Override

    @Transactional
    public Film updateFilmById(Long id, Film filmDetails) {
        Optional<Film> optionalFilm = findById(id);

        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            film.setTitle(filmDetails.getTitle());
            film.setDate(filmDetails.getDate());
            film.setGenre(filmDetails.getGenre());
            film.setWhereToWatch(filmDetails.getWhereToWatch());
            return save(film);
        } else {

            return null;
        }
    }

}