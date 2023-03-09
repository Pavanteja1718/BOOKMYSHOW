package com.bookmyshow.service;

import java.util.List;

import com.bookmyshow.dto.MovieDto;
import com.bookmyshow.entity.MovieEntity;

public interface MovieService {
	
	
	public MovieEntity saveMovie(MovieEntity movieEntity) throws Exception;

	public MovieDto getMovieById(int movieId) throws Exception;

	public List<MovieDto> findMovie(String name) throws Exception;

	public List<MovieDto> getAll() throws Exception;




}
