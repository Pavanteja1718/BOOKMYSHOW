package com.bookmyshow.dto;

import java.time.LocalDateTime;

public class TheatreDto {
	
	private String theatreName;
	private LocalDateTime showDateTime;
	private String city;
	private String screenName;
	
	
	public TheatreDto(String theatreName, LocalDateTime showDateTime, String city, String screenName) {
		super();
		this.theatreName = theatreName;
		this.showDateTime = showDateTime;
		this.city = city;
		this.screenName = screenName;
	}


	public TheatreDto() {
		super();
	}


	public String getTheatreName() {
		return theatreName;
	}


	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}


	public LocalDateTime getShowDateTime() {
		return showDateTime;
	}


	public void setShowDateTime(LocalDateTime showDateTime) {
		this.showDateTime = showDateTime;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	
	
}
