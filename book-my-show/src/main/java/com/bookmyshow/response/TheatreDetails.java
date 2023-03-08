package com.bookmyshow.response;

import java.time.LocalDateTime;

public interface TheatreDetails {
	
	String getTheatreName();
	LocalDateTime getShowDateTime();
	String getCity();
	String getScreenName();
}
