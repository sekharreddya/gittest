package com.tag.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	@Id
	@Column(name="college_id")
    private int collegeId;	
	
	@Column(name="name")
	private String collegeName;
	
	@ElementCollection
	@CollectionTable(name="colleage_student", joinColumns=@JoinColumn(name="college_id"))
	@Column(name="student_name")
	private List<Student> students;
	 
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
