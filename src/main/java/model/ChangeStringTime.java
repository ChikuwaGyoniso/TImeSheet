package model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChangeStringTime {
	//requestでString型になった入力値をTime型に変更する
	public Time ChangeTime(String timeString) {

		//DateTimeFormatterで入力された時間の書式を設定
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("kk:mm");

		//入力された時間の書式を変更
		String[] timearr = timeString.split(":");

		if(timearr[0].length() == 1) {
			timearr[0] = "0" + timearr[0];
		}

		if(timearr[1].length() == 1) {
			timearr[1] = "0" + timearr[1];
		}

		//String型をLocalTime型に変更
		LocalTime lt = LocalTime.parse(timearr[0] + ":" + timearr[1], dtf);

		//LocalTime型をTime型に変更
		Time time = Time.valueOf(lt);
		return time;
	}

}
