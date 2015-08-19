package com.tag.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {

	private String passportId;
	private String issuer;
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
}
