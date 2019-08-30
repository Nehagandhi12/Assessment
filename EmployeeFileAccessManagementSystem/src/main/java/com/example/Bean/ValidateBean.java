package com.example.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Bean for validate table
@Entity(name = "validate")
@Table(name = "validate")
public class ValidateBean {
	@Id
	private int id;
	private String password;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ValidateBean [id=" + id + ", password=" + password + ", role=" + role + "]";
	}

}
