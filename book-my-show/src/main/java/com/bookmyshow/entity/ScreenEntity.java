package com.bookmyshow.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "screen")
public class ScreenEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "screen_id")
	private int screenId;
	
	@Column(name = "screen_name")
	private String screenName;
	
	@Column(name = "row_numbers")
	private int rowNumber;
	
	@Column(name = "column_number")
	private int columnNumber;
	
	@Column(name = "total_seats")
	private int totalSeats;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "scr_id",referencedColumnName = "screen_id")
	private List<ShowEntity> showEntities;

	public ScreenEntity(int screenId, String screenName, int rowNumber, int columnNumber, int totalSeats, List<ShowEntity> showEntities) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.totalSeats = totalSeats;
		this.showEntities = showEntities;
	}

	public ScreenEntity() {
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

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public List<ShowEntity> getShows() {
		return showEntities;
	}

	public void setShows(List<ShowEntity> showEntities) {
		this.showEntities = showEntities;
	}
	
		
}
