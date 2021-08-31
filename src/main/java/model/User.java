package model;

public class User {
	private String userId;
	private String pass;
	private String mail;
	private String name;

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
