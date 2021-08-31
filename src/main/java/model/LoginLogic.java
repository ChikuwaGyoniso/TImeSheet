package model;

import dao.UserDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		UserDAO dao = new UserDAO();
		User user = dao.findByLogin(login);
		return user != null;
	}
}