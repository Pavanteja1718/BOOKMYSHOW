package com.bookmyshow.service;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyshow.controller.ScreenController;
import com.bookmyshow.dto.ScreenDto;
import com.bookmyshow.entity.ScreenEntity;
import com.bookmyshow.exception.ExceptionHandling;
import com.bookmyshow.repo.ScreenRepo;

import ch.qos.logback.classic.Logger;

@Service
public class ScreenServiceImp implements ScreenService {

	@Autowired
	ScreenRepo screenRepo;

	@Autowired
	ModelMapper modelMapper;
	
	Logger logger = (Logger) LoggerFactory.getLogger(ScreenController.class);


	@Override
	public ScreenDto getScreen(String screenName, String theatreName){

		ScreenDto screenDto = new ScreenDto();

		ScreenEntity screenEntity = screenRepo.getScreenByScreenName(screenName, theatreName);

		if (screenEntity == null) {
			throw new ExceptionHandling(screenName + " with " + theatreName + " theatre dosen't exist");
		}

		screenDto = modelMapper.map(screenEntity, ScreenDto.class);
		
		logger.info("------  "+screenName +" is fetched with  "+ theatreName +" theatre -------");

		return screenDto;

	}

}
