package com.bookmyshow.dto;

public class ScreenDto {

   private int screenId;
	
	private String screenName;
	
	private int totalSeats;

	public ScreenDto(int screenId, String screenName, int totalSeats) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.totalSeats = totalSeats;
	}

	public ScreenDto() {
		super();
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	
	
}
