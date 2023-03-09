package com.bookmyshow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.dto.TheatreDto;
import com.bookmyshow.exception.ExceptionHandling;
import com.bookmyshow.repo.TheatreRepo;
import com.bookmyshow.response.TheatreDetails;

@Service
public class TheatreServiceImp implements TheatreService{

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	

	
	  @Override public List<TheatreDto> findTheatreByMovieId(int movieId) throws Exception {
		  
		  List<TheatreDetails> theatreDetails =  theatreRepo.findTheatreByMovieId(movieId);
		  
		  try {
			if(theatreDetails.size()==0) {
				   throw new ExceptionHandling("Theatres with movie id "+ movieId +" dosen't exist");
			   }
		} catch (ExceptionHandling e) {
			e.printStackTrace();
		}
		  
		  List<TheatreDto> theatreDto =  theatreDetails
				  .stream()
				  .map(theatreDetail -> modelMapper.map(theatreDetail, TheatreDto.class))
				  .collect(Collectors.toList());
		
		  
		  return theatreDto;
	  
	  }

}
