package com.tag.model;

import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
 
@Entity
@Table(name = "EMP")
@SecondaryTable(name = "EMP_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID"))
public class EmployeeDetails {
 
//	@TableGenerator(name = "employee_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idemployee;
 
	@Column(name = "FIRST_NAME")
	private String firstName;
 
	@Column(name = "LAST_NAME", table = "EMP")
	private String lastName;
 
	@Column(name = "EMAILID", table = "EMP_DETAILS")
	private String email;
 
	@Column(table = "EMP_DETAILS")
	@Temporal(TemporalType.DATE)
	//@Type(type="date")
	private Date joiningDate;
 
	@Column(table = "EMP_DETAILS")
	private double salary;
 
	public int getIdemployee() {
		return idemployee;
	}
 
	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public Date getJoiningDate() {
		return joiningDate;
	}
 
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
 
	public double getSalary() {
		return salary;
	}
 
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}