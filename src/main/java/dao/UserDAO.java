package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.User;

public class UserDAO {
  private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?characterEncording=UTF-8";
  private final String DB_USER = "Sampleuser";
  private final String DB_PASS = "chikuwanoowari458";
  private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

  public User findByLogin(Login login) {
	  User user = null;

	  try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		  Class.forName(DB_DRIVER);

		  String sql = "SELECT USER_ID, PASS, MAIL, NAME FROM APPUSER WHERE USER_ID = ? AND PASS = ?";

		  PreparedStatement pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, login.getUserId());
		  pstmt.setString(2, login.getPass());

		  ResultSet rs = pstmt.executeQuery();

		  if(rs.next()) {
			  String userId = rs.getString("USER_ID");
			  String pass = rs.getString("PASS");
			  String mail = rs.getString("MAIL");
			  String name = rs.getString("NAME");
			  user = new User(userId,pass,mail,name);
		  }
	  }catch(SQLException e) {
		  e.printStackTrace();
		  return null;
	  }catch(ClassNotFoundException e) {
		  e.printStackTrace();
		  return null;
	  }
	  return user;
  }
}
