package com.bookmyshow.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "shows")
public class ShowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "show_id")
	private int showId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "show_date_time")
    private LocalDateTime showDateTime;
	
	@Column(name = "movie_id")
	private int movieId;
	
	@OneToOne
	@JoinColumn(name = "bk_fid")
	private BookingEntity bookingEntity;

	public ShowEntity(int showId, LocalDateTime showDateTime, int movieId, BookingEntity bookingEntity) {
		super();
		this.showId = showId;
		this.showDateTime = showDateTime;
		this.movieId = movieId;
		this.bookingEntity = bookingEntity;
	}

	public ShowEntity() {
		super();
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowDateTime() {
		return showDateTime;
	}

	public void setShowDateTime(LocalDateTime showDateTime) {
		this.showDateTime = showDateTime;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public BookingEntity getBooking() {
		return bookingEntity;
	}

	public void setBooking(BookingEntity bookingEntity) {
		this.bookingEntity = bookingEntity;
	}
	
	
}
