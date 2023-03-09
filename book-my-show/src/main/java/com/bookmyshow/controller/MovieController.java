package com.bookmyshow.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dto.MovieDto;
import com.bookmyshow.entity.MovieEntity;
import com.bookmyshow.exception.ExceptionHandling;
import com.bookmyshow.service.MovieService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping("/save")
	public MovieEntity createMovie(@RequestBody MovieEntity movieEntity) throws Exception {
	
	 MovieEntity savedMovie =  movieService.saveMovie(movieEntity);
	
	 
	 logger.info("------  movie is saved  -------");
		
		return savedMovie;
		
	}
	
	
	@GetMapping("/allMovies")
	public List<MovieDto> getAllMovies() throws Exception{
		
		List<MovieDto> movieDto	 = movieService.getAll();

			logger.info("------ All movies fetched -------");
		
		return movieDto;
	}
	
	
	@GetMapping("/movieId/{movieId}")
	public MovieDto getMovieDetails(@PathVariable("movieId") int movieId) throws Exception{
		
		MovieDto movieDto = movieService.getMovieById(movieId);
		
		logger.info("------  movie is fetched with movie id "+ movieId+" -------");
		
		return movieDto;
	}
	
	
	@GetMapping("/findMovie/{name}")
	public List<MovieDto> findMovies(@PathVariable("name") String name) throws Exception{
		
		List<MovieDto> movieDto = movieService.findMovie(name);
		
		return movieDto;
		
	}
	
	
}

