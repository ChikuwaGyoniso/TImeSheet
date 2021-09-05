package model;

public class Time {
	private String Date;
	private String Start_Time;
	private String End_Time;
	private String Work_Contents;
	private String Nomal_Time;
	private String Midnight_Time;
	private String Holiday_Time;
	private String Holiday_Midnight_Time;
	private String Sum_WorkTime;

	public Time(String Date, String Start_Time, String End_Time, String Work_Contents, String Nomal_Time, String Midnight_Time,
			String Holiday_Time, String Holiday_Midnight_Time, String Sum_WorkTime) {
		this.Date = Date;
		this.Start_Time = Start_Time;
		this.End_Time = End_Time;
		this.Work_Contents = Work_Contents;
		this.Nomal_Time = Nomal_Time;
		this.Midnight_Time = Midnight_Time;
		this.Holiday_Time = Holiday_Time;
		this.Holiday_Midnight_Time = Holiday_Midnight_Time;
		this.Sum_WorkTime = Sum_WorkTime;
	}
   //日付
	public String getDate() {
		return Date;
	}
  //業務開始時間
	public String getStart_Time() {
		return Start_Time;

	}
  //業務終了時間
	public String getEnd_Time() {
		return End_Time;
	}
  //仕事内容
	public String getWork_Contents() {
		return Work_Contents;
	}
  //通常（休日および深夜の業務時間を除いた）時間
	public String getNomal_Time() {
		return Nomal_Time;
	}
  //深夜の労働時間
	public String getMidnight_Time() {
		return Midnight_Time;
	}
  //休日の労働時間
	public String getHoliday_Time() {
		return Holiday_Time;
	}
  //休日深夜の労働時間
	public String getHoliday_Midnight_Time() {
		return Holiday_Midnight_Time;
	}
  //労働時間の合計
	public String getSum_WorkTime() {
		return Sum_WorkTime;
	}

}