package model;

import dao.TimeDAO;

public class TimeRegisterLogic {
	public void execute(WorkTime worktime) {
		TimeDAO dao = new TimeDAO();
		dao.RegisterTime(worktime);
	}
}
