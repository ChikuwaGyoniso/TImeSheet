package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

//ユーザー登録テストで登録されたテストユーザーを削除するDAO
public class RegisterTestDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?characterEncording=UTF-8";
	private final String DB_USER = "Sampleuser";
	private final String DB_PASS = "chikuwanoowari458";
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public boolean DeleteUser(User user) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			Class.forName(DB_DRIVER);

			String sql = "DELETE FROM APPUSER WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "testUser");

			int result = pstmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
