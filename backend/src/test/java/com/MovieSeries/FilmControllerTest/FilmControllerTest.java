package com.MovieSeries.FilmControllerTest;

import com.MovieSeries.controller.FilmController;
import com.MovieSeries.model.Film;
import com.MovieSeries.services.FilmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmControllerTest {
	@Mock
	private FilmService filmService;
@InjectMocks
private  FilmController filmController;
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup((filmController))
				.build();
	}

	@Test
	public void testGetFilmById() throws Exception {
		Film film = new Film();
		film.setId(1L);
		when(filmService.findById(1L)).thenReturn(Optional.of(film));

		mockMvc.perform(MockMvcRequestBuilders.get("/films/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
		 .andExpect(result -> assertTrue(true, "Test passed: Film found by ID"));

		System.out.println("Test passed: Film found by ID");
	}

}
