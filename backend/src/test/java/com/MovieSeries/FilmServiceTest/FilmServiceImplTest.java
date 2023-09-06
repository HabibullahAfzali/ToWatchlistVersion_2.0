package com.MovieSeries.FilmServiceTest;

import com.MovieSeries.ExceptionHandling.FilmNotFoundException;
import com.MovieSeries.model.Film;
import com.MovieSeries.services.FilmServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import com.MovieSeries.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FilmServiceImplTest {

	@Mock
	private FilmRepository filmRepository;
	@InjectMocks
	private FilmServiceImpl filmService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindAll() {
		Film film1 = new Film();
		film1.setId(1L);
		Film film2 = new Film();
		film2.setId(2L);
		when(filmRepository.findAll()).thenReturn(List.of(film1, film2));

		List<Film> films = filmService.findAll();

		assertEquals(2, films.size());
	}

	@Test
	public void testFindById() {
		Film film = new Film();
		film.setId(1L);
		when(filmRepository.findById(1L)).thenReturn(Optional.of(film));

		Optional<Film> result = filmService.findById(1L);
		assertTrue(result.isPresent());
		assertEquals(1L, result.get().getId());
	}

	@Test
	public void testSave() {
		Film filmToSave = new Film();
		Film savedFilm = new Film();
		savedFilm.setId(1L);
		when(filmRepository.save(filmToSave)).thenReturn(savedFilm);

		Film result = filmService.save(filmToSave);
		assertEquals(1L, result.getId());
	}

	@Test
	public void testUpdateFilmById() {
//		when(filmRepository.existsById(1L)).thenReturn(true);

		when(filmRepository.findById(1L)).thenReturn(Optional.empty());
		Film existingFilm = new Film();
		existingFilm.setId(1L);
		when(filmRepository.save(existingFilm)).thenReturn(existingFilm);

		assertThrows(FilmNotFoundException.class,()->filmService.updateFilmById(1L,new Film()));

//		Film updatedFilm = filmService.updateFilmById(1L, existingFilm);
//		assertNotNull(updatedFilm);
//		assertEquals(1L, updatedFilm.getId());
	}


	@Test
	public void testDeleteById() {
		when(filmRepository.existsById(1L)).thenReturn(true);
		filmService.deleteById(1L);

		verify(filmRepository, times(1)).deleteById(1L);
	}
}
