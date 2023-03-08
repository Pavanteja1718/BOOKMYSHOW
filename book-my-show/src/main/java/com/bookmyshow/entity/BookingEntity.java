package com.bookmyshow.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column( name = "booking_date", columnDefinition = "DATE")
	private Date bookingDate;
	
	@Column(name = "total_cost")
	private double totalCost;
	
	@OneToOne(mappedBy = "bookingEntity")
	private ShowEntity showEntity;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "tk_fid")
	private TicketEntity ticketEntity;

	public BookingEntity(int bookingId, Date bookingDate, double totalCost, ShowEntity showEntity, TicketEntity ticketEntity) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.showEntity = showEntity;
		this.ticketEntity = ticketEntity;
	}

	public BookingEntity() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public ShowEntity getShow() {
		return showEntity;
	}

	public void setShow(ShowEntity showEntity) {
		this.showEntity = showEntity;
	}

	public TicketEntity getTicket() {
		return ticketEntity;
	}

	public void setTicket(TicketEntity ticketEntity) {
		this.ticketEntity = ticketEntity;
	}
	
	

}
