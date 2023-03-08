package com.bookmyshow.service;

import java.util.List;

import com.bookmyshow.dto.MovieDto;
import com.bookmyshow.entity.MovieEntity;

public interface MovieService {
	
	
	public MovieEntity saveMovie(MovieEntity movieEntity);

	public MovieDto getMovieById(int movieId);

	public List<MovieDto> findMovie(String name);

	public List<MovieDto> getAll();




}
