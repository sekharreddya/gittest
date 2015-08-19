package com.tag.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
public class Country {

	@Id
	@GeneratedValue
	private int id;
	private String country;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cntry_id")
	@MapKey(name="id")
	@Sort(type=SortType.UNSORTED)
	private Map<Integer,States> mapStates;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Map<Integer, States> getMapStates() {
		return mapStates;
	}
	public void setMapStates(Map<Integer, States> mapStates) {
		this.mapStates = mapStates;
	}
	
}
