package model;

import java.io.Serializable;
import java.sql.Time;

public class WorkTime implements Serializable {
	private String UserId;
	private String Date;
	private Time Start_Time;
	private Time End_Time;
	private String Work_Contents;
	private Time Nomal_Time;
	private Time Midnight_Time;
	private Time Holiday_Time;
	private Time Holiday_Midnight_Time;
	private Time WorkTime_Sum;

	public WorkTime() {

	}

	public WorkTime(String UserId, String Date, Time Start_Time, Time End_Time, String Work_Contents, Time Nomal_Time,
			Time Midnight_Time,
			Time Holiday_Time, Time Holiday_Midnight_Time, Time WorkTime_Sum) {
		this.UserId = UserId;
		this.Date = Date;
		this.Start_Time = Start_Time;
		this.End_Time = End_Time;
		this.Work_Contents = Work_Contents;
		this.Nomal_Time = Nomal_Time;
		this.Midnight_Time = Midnight_Time;
		this.Holiday_Time = Holiday_Time;
		this.Holiday_Midnight_Time = Holiday_Midnight_Time;
		this.WorkTime_Sum = WorkTime_Sum;
	}

	public String getUserId() {
		return UserId;
	}

	//日付
	public String getDate() {
		return Date;
	}

	//業務開始時間
	public Time getStart_Time() {
		return Start_Time;

	}

	//業務終了時間
	public Time getEnd_Time() {
		return End_Time;
	}

	//仕事内容
	public String getWork_Contents() {
		return Work_Contents;
	}

	//通常（休日および深夜の業務時間を除いた）時間
	public Time getNomal_Time() {
		return Nomal_Time;
	}

	//深夜の労働時間
	public Time getMidnight_Time() {
		return Midnight_Time;
	}

	//休日の労働時間
	public Time getHoliday_Time() {
		return Holiday_Time;
	}

	//休日深夜の労働時間
	public Time getHoliday_Midnight_Time() {
		return Holiday_Midnight_Time;
	}

	//労働時間の合計
	public Time getWorkTime_Sum() {
		return WorkTime_Sum;
	}

}