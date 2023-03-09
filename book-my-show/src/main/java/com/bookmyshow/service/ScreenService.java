package com.bookmyshow.service;

import com.bookmyshow.dto.ScreenDto;

public interface ScreenService{
	
	public ScreenDto getScreen(String screenName,String theatreName) throws Exception ;

}
