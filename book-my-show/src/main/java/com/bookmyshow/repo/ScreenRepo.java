package com.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.ScreenEntity;

@Repository
public interface ScreenRepo extends JpaRepository<ScreenEntity, Integer> {
	
	@Query(nativeQuery = true, value = "select * from  screen,theatres where screen.th_id = theatres.theatre_id and screen_name =?1 and theatres.theatre_name =?2")
	public ScreenEntity getScreenByScreenName(String screenName, String theatreName);
}
