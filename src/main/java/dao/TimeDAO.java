package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.WorkTime;

public class TimeDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?characterEncording=UTF-8";
	private final String DB_USER = "Sampleuser";
	private final String DB_PASS = "chikuwanoowari458";
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public boolean RegisterTime(WorkTime worktime) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			Class.forName(DB_DRIVER);

			String sql = "INSERT INTO TIMESHEET (USER_ID,DATE, START_TIME, END_TIME, WORK_CONTENTS,NOMAL_TIME,"
					+ " MIDNIGHT_TIME, HOLIDAY_TIME, HOLIDAY_MIDNIGHT_TIME, SUM_WORKTIME VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, worktime.getUserId());
			pstmt.setString(2, worktime.getDate());
			pstmt.setTime(3, worktime.getStart_Time());
			pstmt.setTime(4, worktime.getEnd_Time());
			pstmt.setString(5, worktime.getWork_Contents());
			pstmt.setTime(6, worktime.getNomal_Time());
			pstmt.setTime(7, worktime.getMidnight_Time());
			pstmt.setTime(8, worktime.getHoliday_Time());
			pstmt.setTime(9, worktime.getHoliday_Midnight_Time());
			pstmt.setTime(10, worktime.getSum_WorkTime());

			int result = pstmt.executeUpdate();

			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			return false;
		}
		return true;
	}
}
