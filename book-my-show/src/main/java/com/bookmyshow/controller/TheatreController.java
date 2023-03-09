package com.bookmyshow.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dto.TheatreDto;
import com.bookmyshow.service.TheatreService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	Logger logger = (Logger) LoggerFactory.getLogger(TheatreController.class);

	@GetMapping("/theatre/{movieId}")
	public List<TheatreDto> getTheatreByMovieId(@PathVariable("movieId") int movieId) throws Exception {

		List<TheatreDto> theatreDtos = theatreService.findTheatreByMovieId(movieId);

			logger.info("------  theatre's list fetched with  movie id " + movieId + " -------");
		
		return theatreDtos;

	}

}
