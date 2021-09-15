package model;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String pass;
	private String mail;
	private String name;

	public User() {

	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String pass, String mail, String name) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}
}
