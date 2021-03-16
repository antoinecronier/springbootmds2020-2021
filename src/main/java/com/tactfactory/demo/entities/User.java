package com.tactfactory.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
