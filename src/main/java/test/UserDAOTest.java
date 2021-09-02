package test;

import dao.RegisterTestDAO;
import dao.UserDAO;
import model.Login;
import model.User;

public class UserDAOTest {
	public static void main(String[] arga) {
		testFindByLogin1();//ユーザーが見つかる場合
		testFindByLogin2();//ユーザーが見つからない場合
		testRegister();//ユーザー登録テスト
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

	public static void testRegister() {
		User user = new User("testUser", "123456", "sample@email", "テストテスト");
		Login login = new Login("testuser", "123456");
		UserDAO dao = new UserDAO();
		RegisterTestDAO testdao = new RegisterTestDAO();
		//テストユーザーを仮登録
		dao.RegisterUser(user);
		//テストユーザーで仮ログイン
		User result = dao.findByLogin(login);
		if (result != null && result.getUserId().equals("testUser") && result.getPass().equals("123456")
				&& result.getMail().equals("sample@email") && result.getName().equals("テストテスト")) {
			System.out.println("testRegister:成功しました");
			//仮登録したユーザーを削除
			testdao.DeleteUser(user);
		} else {
			System.out.println("testRegister:失敗しました");
			testdao.DeleteUser(user);
		}
	}
}
