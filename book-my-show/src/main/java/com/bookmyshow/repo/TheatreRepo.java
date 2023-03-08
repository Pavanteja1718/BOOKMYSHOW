package com.bookmyshow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.TheatreEntity;
import com.bookmyshow.response.TheatreDetails;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreEntity, Integer> {

	
	@Query(nativeQuery = true,value = "SELECT theatre_name as theatreName ,show_date_time as showDateTime,city as city , "
			+ "screen_name as ScreenName FROM ((shows s JOIN screen  ON screen.screen_id = s.scr_id ) "
			+ "join theatres  t on t.theatre_id = s.th_id) "
			+ "JOIN movies m ON m.id = s.movie_id where s.movie_id= ?1")
	List<TheatreDetails> findTheatreByMovieId(int movieId) ;
}
