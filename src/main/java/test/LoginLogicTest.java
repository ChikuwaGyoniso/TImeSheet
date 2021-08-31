package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] arga) {
		testExecute1();
		testExecute2();
	}

	public static void testExecute1() {
		Login login = new Login("chikuwa", "chikuwa456");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if (result) {
			System.out.println("testExecute1:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}

	public static void testExecute2() {
		Login login = new Login("chikuwa", "chikuwa478");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if (!result) {
			System.out.println("testExecute2:成功しました");
		} else {
			System.out.println("testExecute2:失敗しました");
		}
	}
}
