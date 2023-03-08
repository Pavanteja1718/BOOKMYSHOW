package com.bookmyshow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;
	
	@Column(name = "no_of_seats")
	private int noOfSeats;
	
	@OneToMany
	@JoinColumn(name = "tk_fid",referencedColumnName = "ticket_id")
	private List<SeatEntity> seatEntities;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "ticketEntity")
	private BookingEntity bookingEntity;

	public TicketEntity(int ticketId, int noOfSeats, List<SeatEntity> seatEntities, BookingEntity bookingEntity) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatEntities = seatEntities;
		this.bookingEntity = bookingEntity;
	}

	public TicketEntity() {
		super();
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<SeatEntity> getSeats() {
		return seatEntities;
	}

	public void setSeats(List<SeatEntity> seatEntities) {
		this.seatEntities = seatEntities;
	}

	public BookingEntity getBooking() {
		return bookingEntity;
	}

	public void setBooking(BookingEntity bookingEntity) {
		this.bookingEntity = bookingEntity;
	}
	
	
}
