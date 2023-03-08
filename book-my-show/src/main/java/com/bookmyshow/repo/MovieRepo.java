package com.bookmyshow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyshow.entity.MovieEntity;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {
	
	
	@Query(nativeQuery = true, value = "select * from movies where movie_name = :name OR hero =:name OR heroine =:name OR genre = :name OR language =:name")
	public List<MovieEntity> findMovie(@Param("name") String name);
	

}
