package com.devsuperior.dsmovie.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {
	
	@InjectMocks
	private ScoreService service;

	@Mock
	private UserService userService;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private ScoreRepository scoreRepository;

	private Long existingMovieId;
	private Long nonExistingMovieId;
	private ScoreDTO scoreDTO;
	private ScoreEntity scoreEntity;
	private MovieEntity movie;
	private UserEntity user;

	@BeforeEach
	void setUp() throws Exception {
		existingMovieId = 1L;
		nonExistingMovieId = 1000L;

		scoreEntity = ScoreFactory.createScoreEntity();
		movie = MovieFactory.createMovieEntity();
		user = UserFactory.createUserEntity();
		scoreDTO = ScoreFactory.createScoreDTO();

		when(userService.authenticated()).thenReturn(user);

		when(movieRepository.findById(existingMovieId)).thenReturn(Optional.of(movie));
		when(movieRepository.findById(nonExistingMovieId)).thenReturn(Optional.empty());

		when(scoreRepository.saveAndFlush(any())).thenReturn(scoreEntity);
		when(movieRepository.save(any())).thenReturn(movie);
	}

	@Test
	public void saveScoreShouldReturnMovieDTO() {
		MovieDTO result = service.saveScore(scoreDTO);
		Assertions.assertNotNull(result);
	}

	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {
		ScoreDTO dtoWithNonExistingMovie = new ScoreDTO(nonExistingMovieId, 4.5);
		Assertions.assertThrows(ResourceNotFoundException.class,
				() -> service.saveScore(dtoWithNonExistingMovie));
	}
}
