package com.bookmyshow.service;

import java.util.List;

import com.bookmyshow.dto.TheatreDto;

public interface TheatreService {

	
	public List<TheatreDto> findTheatreByMovieId(int movieId);

}
