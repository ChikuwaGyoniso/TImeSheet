package test;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import dao.RegisterTestDAO;
import dao.TimeDAO;
import model.WorkTime;

public class TimeDAOTest {
	public static void main(String[] args) {
		testRegisterTime();
	}

	public static void testRegisterTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime lt_time = LocalTime.parse("08:40", dtf);
		Time time = Time.valueOf(lt_time);
		WorkTime worktime = new WorkTime("testUser", "1日", time, time, "テスト", time, time, time, time, time);
		RegisterTestDAO dao = new RegisterTestDAO();
		TimeDAO timedao = new TimeDAO();
		//テストTimeを仮登録
		timedao.RegisterTime(worktime);
		WorkTime result = dao.testFindByTime(worktime);

		if (result != null && result.getUserId().equals("testUser")){
			System.out.println("testRegisterTime:成功しました");
			dao.DeleteTimeData(worktime);

		} else {
			System.out.println("testRegisterTime:失敗しました");
			dao.DeleteTimeData(worktime);
		}
	}
}
