package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.WorkTime;
import model.YearAndMonth;

public class ViewTimeSheetDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?cahracterEncording=UTF-8";
	private final String DB_USER = "Sampleuser";
	private final String DB_PASS = "chikuwanoowari458";
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public List<WorkTime> findAll(User user, YearAndMonth ymd) {
		List<WorkTime> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			Class.forName(DB_DRIVER);
			String sql = "SELECT * FROM timesheet WHERE USER_ID = ? AND DATE_FORMAT(DATE,'%Y')=? and DATE_FORMAT(DATE, '%m') = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserId());

			pstmt.setString(2, ymd.getYear());

			pstmt.setString(3, ymd.getMonth());
			ResultSet rs = pstmt.executeQuery();

			WorkTime worktime = new WorkTime();
			while (rs.next()) {

				//SELECTの結果をArrayListに格納
				String userid = rs.getString("User_Id");
				Date date = rs.getDate("date");
				Time start_time = rs.getTime("Start_Time");
				Time end_time = rs.getTime("End_Time");
				String work_contents = rs.getString("Work_Contents");
				Time nomal_time = rs.getTime("Nomal_Time");
				Time midnight_time = rs.getTime("Midnight_Time");
				Time holiday_time = rs.getTime("Holiday_Time");
				Time holiday_midnight_time = rs.getTime("Holiday_Midnight_Time");
				Time worktime_sum = rs.getTime("WorkTime_Sum");
				worktime = new WorkTime(userid, date, start_time, end_time, work_contents,
						nomal_time, midnight_time, holiday_time, holiday_midnight_time, worktime_sum);
				list.add(worktime);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
