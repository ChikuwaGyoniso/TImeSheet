package model;

public class WorkTime {
	private String Date;
	private WorkTime Start_Time;
	private WorkTime End_Time;
	private String Work_Contents;
	private WorkTime Nomal_Time;
	private WorkTime Midnight_Time;
	private WorkTime Holiday_Time;
	private WorkTime Holiday_Midnight_Time;
	private WorkTime Sum_WorkTime;

	public WorkTime(String Date, WorkTime Start_Time, WorkTime End_Time, String Work_Contents, WorkTime Nomal_Time, WorkTime Midnight_Time,
			WorkTime Holiday_Time, WorkTime Holiday_Midnight_Time, WorkTime Sum_WorkTime) {
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
	public WorkTime getStart_Time() {
		return Start_Time;

	}
  //業務終了時間
	public WorkTime getEnd_Time() {
		return End_Time;
	}
  //仕事内容
	public String getWork_Contents() {
		return Work_Contents;
	}
  //通常（休日および深夜の業務時間を除いた）時間
	public WorkTime getNomal_Time() {
		return Nomal_Time;
	}
  //深夜の労働時間
	public WorkTime getMidnight_Time() {
		return Midnight_Time;
	}
  //休日の労働時間
	public WorkTime getHoliday_Time() {
		return Holiday_Time;
	}
  //休日深夜の労働時間
	public WorkTime getHoliday_Midnight_Time() {
		return Holiday_Midnight_Time;
	}
  //労働時間の合計
	public WorkTime getSum_WorkTime() {
		return Sum_WorkTime;
	}

}