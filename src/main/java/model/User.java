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
		this.userId = userId;//一覧表示のためのユーザーID
	}

	public User(String userId, String pass, String mail, String name) {
		this.userId = userId;//新規ユーザーID
		this.pass = pass;//新規ユーザーのパスワード
		this.mail = mail;//新規ユーザーのメールアドレス
		this.name = name;//新規ユーザーの名前
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
