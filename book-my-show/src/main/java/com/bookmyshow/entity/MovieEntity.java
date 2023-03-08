package com.bookmyshow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int movieId;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "language")
	private Language language;
	
	@Column(name = "overview")
	private String overview;
	
	@Column(name = "hero")
	private String hero;
	
	
	@Column(name = "heroine")
	private String heroine;
	
	@Column(name = "poster_path")
	private String posterPath;
	
	@Column( name = "release_date", columnDefinition = "DATE")
	private Date releaseDate;

	public MovieEntity(int movieId, String movieName, Genre genre, Language language, String overview, String hero,
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

	public MovieEntity() {
		super();
	}

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
	
	
	
	
}
