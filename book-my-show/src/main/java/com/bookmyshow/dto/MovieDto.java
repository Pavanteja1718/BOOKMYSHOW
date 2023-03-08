package com.bookmyshow.dto;

import java.util.Date;

import com.bookmyshow.entity.Genre;
import com.bookmyshow.entity.Language;

public class MovieDto {
	
	private int movieId;
	
	private String movieName;
	
	private Genre genre;
	
	private Language language;
	
	private String overview;
	
	private String hero;
	
	private String heroine;
	
	private String posterPath;
	
	private Date releaseDate;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public MovieDto(int movieId, String movieName, Genre genre, Language language, String overview, String hero,
			String heroine, String posterPath, Date releaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.language = language;
		this.overview = overview;
		this.hero = hero;
		this.heroine = heroine;
		this.posterPath = posterPath;
		this.releaseDate = releaseDate;
	}

	public MovieDto() {
		super();
	}
	
	
}
