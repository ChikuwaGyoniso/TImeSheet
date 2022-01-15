package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.WorkTime;

public class TimeDAO extends DataSourceManager {

	public boolean RegisterTime(WorkTime worktime) {
		try {

			String sql = "INSERT INTO TIMESHEET (USER_ID, DATE, START_TIME, END_TIME, WORK_CONTENTS,NORMAL_TIME,"
					+ " MIDNIGHT_TIME, HOLIDAY_TIME, HOLIDAY_MIDNIGHT_TIME, WORKTIME_SUM) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = connection.prepareStatement(sql);
			//Insert文中の「？」も使用する値を設定しSQLを完成
			pstmt.setString(1, worktime.getUserId());
			pstmt.setDate(2, worktime.getDate());
			pstmt.setTime(3, worktime.getStart_Time());
			pstmt.setTime(4, worktime.getEnd_Time());
			pstmt.setString(5, worktime.getWork_Contents());
			pstmt.setTime(6, worktime.getNomal_Time());
			pstmt.setTime(7, worktime.getMidnight_Time());
			pstmt.setTime(8, worktime.getHoliday_Time());
			pstmt.setTime(9, worktime.getHoliday_Midnight_Time());
			pstmt.setTime(10, worktime.getWorkTime_Sum());

			//resultには追加された行数が代入される
			int result = pstmt.executeUpdate();
			if (result != 1) {
				return false;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
