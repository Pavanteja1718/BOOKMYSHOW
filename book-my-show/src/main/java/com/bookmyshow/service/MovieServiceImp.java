package com.bookmyshow.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookmyshow.controller.MovieController;
import com.bookmyshow.dto.MovieDto;
import com.bookmyshow.entity.MovieEntity;
import com.bookmyshow.exception.ExceptionHandling;
import com.bookmyshow.repo.MovieRepo;

import ch.qos.logback.classic.Logger;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepo moviesRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	

	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);

	@Override
	public MovieEntity saveMovie(MovieEntity movieEntity) {
		
		if(movieEntity.getHero().isEmpty() || movieEntity.getHeroine().isEmpty() || movieEntity.getMovieName().isEmpty() 
				|| movieEntity.getOverview().isEmpty() || movieEntity.getPosterPath().isEmpty()) {
			throw new ExceptionHandling("please enter all input fields");
		}
		
		MovieEntity savedMovie = moviesRepository.save(movieEntity);
		
		return savedMovie;
	}
	
	
	@Override
	public MovieDto getMovieById(int movieId) {
	
	   MovieEntity movieEntity = moviesRepository.findById(movieId).get();
	   
	   MovieDto movieDto = modelMapper.map(movieEntity, MovieDto.class);
		
		return movieDto;
	}


	@Override
	public List<MovieDto> findMovie(String name){
		

		   List<MovieEntity> movieEntities = moviesRepository.findMovie(name);
		   
		   
		   if(movieEntities.size()==0) {
			   throw new ExceptionHandling("Movie with "+ name +" dosen't exist");
		   }
		   
		   List<MovieDto>   movieDto =  movieEntities
					  .stream()
					  .map(movie -> modelMapper.map(movie, MovieDto.class))
					  .collect(Collectors.toList());
			   
		   logger.info("------  movie is fetched with  "+ name +" -------");
			   
		   return movieDto;
		  
	}


	@Override
	public List<MovieDto> getAll(){
		
		List<MovieEntity> movieEntities = moviesRepository.findAll();
		  
		  if(movieEntities.size()==0) {
			   throw new ExceptionHandling("Movies dosen't exist");
		   }
		  
		   
		  List<MovieDto> movieDto = movieEntities
				  .stream()
				  .map(movie -> modelMapper.map(movie, MovieDto.class))
				  .collect(Collectors.toList());
			
			return movieDto;
	
	}

}
