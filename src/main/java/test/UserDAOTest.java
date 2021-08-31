package test;

import dao.UserDAO;
import model.Login;
import model.User;

public class UserDAOTest {
	public static void main(String[] arga) {
		testFindByLogin1();
		testFindByLogin2();
	}

	public static void testFindByLogin1() {
		Login login = new Login("chikuwa", "chikuwa456");
		UserDAO dao = new UserDAO();
		User result = dao.findByLogin(login);
		if (result != null && result.getUserId().equals("chikuwa") &&
				result.getPass().equals("chikuwa456") &&
				result.getMail().equals("Sample@mail.com") &&
				result.getName().equals("筑後　圭太")) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}

	public static void testFindByLogin2() {
		Login login = new Login("chikuwa", "chikuwa412");
		UserDAO dao = new UserDAO();
		User result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
