package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.WorkTime;
import model.YearAndMonth;

public class ViewTimeSheetDAO extends DataSourceManager {

	public List<WorkTime> findAll(User user, YearAndMonth ymd) {
		List<WorkTime> list = new ArrayList<>();
		try {

			String sql = "SELECT * FROM timesheet WHERE USER_ID = ? AND DATE_FORMAT(Date,'%Y')=? AND DATE_FORMAT(Date,'%m')= ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, user.getUserId());

			pstmt.setInt(2, ymd.getYear());

			pstmt.setInt(3, ymd.getMonth());
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
		}
		return list;
	}
}
