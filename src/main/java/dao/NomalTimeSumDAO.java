package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import model.User;
import model.WorkTime;

public class NomalTimeSumDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?characterEncording=UTF-8";
	private final String DB_USER = "Sampleuser";
	private final String DB_PASS = "chikuwanoowari458";
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public WorkTime ShowNomalTimeSum(User user) {
		WorkTime worktime = new WorkTime();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			Class.forName(DB_DRIVER);

			String sql = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(nomal_time))) AS total_time FROM timesheet WHERE user_id = ?;";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserId());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Time Nomal_Time_Sum = rs.getTime("total_time");
				worktime = new WorkTime(Nomal_Time_Sum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return worktime;
	}
}
