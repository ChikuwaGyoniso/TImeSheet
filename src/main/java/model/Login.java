package model;

public class Login {
	private String userId;
	private String pass;

	public Login(String userId, String pass) {
		this.userId = userId;//ユーザーID
		this.pass = pass;//パスワード
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}
}
