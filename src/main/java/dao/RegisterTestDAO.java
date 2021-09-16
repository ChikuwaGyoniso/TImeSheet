package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import model.User;
import model.WorkTime;

public class RegisterTestDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampleappdb?characterEncording=UTF-8";
	private final String DB_USER = "Sampleuser";
	private final String DB_PASS = "chikuwanoowari458";
	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	//登録テストで登録されたテストユーザーを削除する
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
	public boolean DeleteTimeData(WorkTime worktime) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			Class.forName(DB_DRIVER);

			String sql = "DELETE FROM TIMESHEET WHERE USER_ID = ?";
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
	//時間登録テストで時間が登録されているかのテスト
	public WorkTime testFindByTime(WorkTime worktime) {

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			Class.forName(DB_DRIVER);

			String sql = "SELECT USER_ID,DATE,START_TIME,END_TIME,WORK_CONTENTS,NOMAL_TIME,MIDNIGHT_TIME,HOLIDAY_TIME,HOLIDAY_MIDNIGHT_TIME,"
					+ "WORKTIME_SUM FROM TIMESHEET WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, worktime.getUserId());

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				String userid = rs.getString("USER_ID");
				Date date = rs.getDate("DATE");
				Time start_time = rs.getTime("START_TIME");
				Time end_time = rs.getTime("END_TIME");
				String work_contents = rs.getString("WORK_CONTENTS");
				Time nomal_time = rs.getTime("NOMAL_TIME");
				Time midnight_time = rs.getTime("MIDNIGHT_TIME");
				Time holiday_time = rs.getTime("HOLIDAY_TIME");
				Time holiday_midnight_time = rs.getTime("HOLIDAY_MIDNIGHT_TIME");
				Time worktime_sum = rs.getTime("WORKTIME_SUM");
				worktime = new WorkTime(userid,date,start_time,end_time,work_contents,nomal_time,midnight_time,holiday_time,holiday_midnight_time,worktime_sum);

			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return worktime;

	}
}
