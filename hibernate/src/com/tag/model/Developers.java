package com.tag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Developers implements Comparable<Developers>
{
	
	@Id
	@GeneratedValue
	private int devId;
	private String devName;
	private int sal;
	
	@ManyToOne
	@JoinColumn(name="projId")
	private Project project;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public int compareTo(Developers o) {
		return this.devName.compareTo(o.getDevName());
		/*if(this.sal>o.getSal())
			return 1;
		else if(this.sal<o.getSal())
			return -1;
		else 
			return 0;*/
	}
	
	
}
