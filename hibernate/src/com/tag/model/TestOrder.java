package com.tag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="custId")
	private TestCustomer testCustomer;
	
	public TestCustomer getTestCustomer() {
		return testCustomer;
	}
	public void setTestCustomer(TestCustomer testCustomer) {
		this.testCustomer = testCustomer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
