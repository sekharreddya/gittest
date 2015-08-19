package com.tag.model;

import java.util.SortedSet;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="test")
//@FilterDef(name="salTest",parameters=@ParamDef(type="java.lang.String", name = "sal"))


public class Project {
	
	@Id
	@GeneratedValue
	private int projId;
	
	private String projName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="projId")
	@Sort(type=SortType.COMPARATOR,comparator=com.tag.compatator.DeveloperSalaryComparator.class)
	//@Filter(name="salTest",condition="sal>:sal") filter dae data based on sum conditions
	private SortedSet<Developers> developersSet;
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	public SortedSet<Developers> getDevelopersSet() {
		return developersSet;
	}
	public void setDevelopersSet(SortedSet<Developers> developersSet) {
		this.developersSet = developersSet;
	}
	
}
