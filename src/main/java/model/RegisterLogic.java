package model;

import dao.UserDAO;

public class RegisterLogic {
	public void execute(User user) {
		UserDAO dao = new UserDAO();
		dao.RegisterUser(user);
	}
}
