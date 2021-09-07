package model;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChangeStringTime {
	public Time ChangeTime(String timeString) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime lt = LocalTime.parse(timeString, dtf);
		Time time = Time.valueOf(lt);
		return time;
	}

}
