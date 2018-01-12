package com.hospital.model;

import java.sql.Timestamp;

public class Model_user {
	
	private int id;
	private String username;
	private String password;
	private Timestamp timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTimestamp() {
		return timestamp.toString();
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Model_user [id=" + id + ", username=" + username + ", password="
				+ password + ", timestamp=" + timestamp + "]";
	}
	public Model_user(int id, String username, String password,
			Timestamp timestamp) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.timestamp = timestamp;
	}
	
	public Model_user(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Model_user() {
		
	}
	
	
	

}
