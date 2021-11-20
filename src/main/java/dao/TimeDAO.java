package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.WorkTime;

public class TimeDAO extends DataSourceManager {

	public boolean RegisterTime(WorkTime worktime) {
		Connection conn = null;
		try {

			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");

			// データベースへ接続
			conn = ds.getConnection();

			String sql = "INSERT INTO TIMESHEET (USER_ID,DATE, START_TIME, END_TIME, WORK_CONTENTS,NOMAL_TIME,"
					+ " MIDNIGHT_TIME, HOLIDAY_TIME, HOLIDAY_MIDNIGHT_TIME, WORKTIME_SUM) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
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

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (NamingException e) {
			return false;
		}
		return true;
	}
}
