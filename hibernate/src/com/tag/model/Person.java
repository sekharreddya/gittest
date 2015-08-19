package com.tag.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Where;


//@Entity(dynamicInsert=true)
@javax.persistence.Entity
@Table
@SecondaryTables(@SecondaryTable(name = "persion_details",pkJoinColumns=@PrimaryKeyJoinColumn(name="persion_id")))
/*@SqlResultSetMapping(entities={@EntityResult(entityClass=com.tag.model.Person.class,fields={
@FieldResult(name="persionName",column="persionName"),
@FieldResult(name="persionId",column="persionId")
})}, name = "persionNameQuery")*/
@NamedQuery(name="persionNameQuery",query="select persionName from Person")
@Where(clause="persionId>1")
public final class Person {

	@Id
	@TableGenerator(allocationSize=5,initialValue=1,name="persion_details",table="id_gen",pkColumnName="entity",pkColumnValue="persion")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="persion_details")
	private int persionId;
	@Column
	private String persionName;
	@Column(table="persion_details")
	private String persionCity;
	private String persionState;
	private String zipCode;
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getPersionId() {
		return persionId;
	}
	public void setPersionId(int persionId) {
		this.persionId = persionId;
	}
	public String getPersionName() {
		return persionName;
	}
	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}
	public String getPersionCity() {
		return persionCity;
	}
	public void setPersionCity(String persionCity) {
		this.persionCity = persionCity;
	}
	public String getPersionState() {
		return persionState;
	}
	public void setPersionState(String persionState) {
		this.persionState = persionState;
	}
}
