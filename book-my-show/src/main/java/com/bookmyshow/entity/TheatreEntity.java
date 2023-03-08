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
@Table(name = "theatres")
public class TheatreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "theatre_id")
	private int theatreId;
	
	@Column(name = "theatre_name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "th_id", referencedColumnName = "theatre_id")
	private List<ScreenEntity> screenEntities;
	
	@OneToMany
	@JoinColumn(name = "th_id", referencedColumnName = "theatre_id")
	private List<ShowEntity> showEntity;

	public TheatreEntity(int theatreId, String name, String city, String state, List<ScreenEntity> screenEntities, List<ShowEntity> showEntity) {
		super();
		this.theatreId = theatreId;
		this.name = name;
		this.city = city;
		this.state = state;
		this.screenEntities = screenEntities;
		this.showEntity = showEntity;
	}

	public TheatreEntity() {
		super();
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ScreenEntity> getScreens() {
		return screenEntities;
	}

	public void setScreens(List<ScreenEntity> screenEntities) {
		this.screenEntities = screenEntities;
	}

	public List<ShowEntity> getShow() {
		return showEntity;
	}

	public void setShow(List<ShowEntity> showEntity) {
		this.showEntity = showEntity;
	}
	
	
}
