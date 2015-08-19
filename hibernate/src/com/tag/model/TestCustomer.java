package com.tag.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TestCustomer {
	
	@Id
	@GeneratedValue
	private int custId;
	private String custName;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="custId")
	private List<TestOrder> testOrder;
	public int getCustId() {
		return custId;
	}
	public List<TestOrder> getTestOrder() {
		return testOrder;
	}
	public void setTestOrder(List<TestOrder> testOrder) {
		this.testOrder = testOrder;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
}
