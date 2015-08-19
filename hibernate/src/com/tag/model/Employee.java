package com.tag.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;




@Entity
@Table(name="employee",catalog="test",uniqueConstraints={@UniqueConstraint(columnNames={"emp_name"})})
@NamedQueries(
		{
			@NamedQuery(name="employee.findAll",query="from Employee"),
			@NamedQuery(name="employee.findName",query="select empName from Employee")
		})
//@Where(clause="empId>1")

public class Employee {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name="emp_name",length=30,updatable=true)
	private String empName;
	
	@Column(name="emp_designation",length=10,updatable=true)
	@Check(constraints="emp_designation in ('manager','engineer')")
	private String empDesignation;	
	
	@Version
	@Column
	private Integer version;	 
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Type(type="timestamp")
	//@Formula("date_format(join_date,'%d %b %y')")
	@Column(name="join_date")
	private Date joinDate;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//@JoinColumn(name="dept_id")
	@PrimaryKeyJoinColumn
	@OrderBy("dept_name")
	private Department department;
	
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
