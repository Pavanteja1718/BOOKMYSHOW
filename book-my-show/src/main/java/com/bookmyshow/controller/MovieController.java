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
	public MovieEntity createMovie(@RequestBody MovieEntity movieEntity) {
	
	 MovieEntity savedMovie = null;
	try {
		savedMovie = movieService.saveMovie(movieEntity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 logger.info("------  movie is saved  -------");
		
		return savedMovie;
		
	}
	
	
	@GetMapping("/allMovies")
	public List<MovieDto> getAllMovies(){
		
		List<MovieDto> movieDto = null;
		
		
		try {
			logger.info("------ All movies fetched -------");
			movieDto = movieService.getAll();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return movieDto;
	}
	
	
	@GetMapping("/movieId/{movieId}")
	public MovieDto getMovieDetails(@PathVariable("movieId") int movieId) throws Exception{
		
		MovieDto movieDto = null;
		
		try {
			movieDto = movieService.getMovieById(movieId);
			logger.info("------  movie is fetched with movie id "+ movieId+" -------");
		}
		catch(Exception e){
			throw new ExceptionHandling("Movie with id " + movieId + " dosen't exist");
		}
		
		return movieDto;
	}
	
	
	@GetMapping("/findMovie/{name}")
	public List<MovieDto> findMovies(@PathVariable("name") String name){
		
		List<MovieDto> movieDto = null;
		
		try {
			movieDto = movieService.findMovie(name);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		return movieDto;
		
	}
	
	
}

