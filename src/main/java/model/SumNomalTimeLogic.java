package model;

import dao.NomalTimeSumDAO;

public class SumNomalTimeLogic {
	public WorkTime execute(User user) {
		NomalTimeSumDAO NTSdao = new NomalTimeSumDAO();
		WorkTime worktime = NTSdao.ShowNomalTimeSum(user);
		return worktime;
	}
}
