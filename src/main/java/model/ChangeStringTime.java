package model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChangeStringTime {
	//requestでString型になった入力値をTime型に変更する
	public Time ChangeTime(String timeString) {

		//DateTimeFormatterで入力された時間の書式を設定
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

		//String型をLocalTime型に変更
		LocalTime lt = LocalTime.parse(timeString, dtf);

		//LocalTime型をTime型に変更
		Time time = Time.valueOf(lt);
		return time;
	}

}
