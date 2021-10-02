package model;

import java.util.List;

import dao.ViewTimeSheetDAO;

public class ViewTimeSheetLogic {
	public List<WorkTime> execute(User user, YearAndMonth ymd) {
		ViewTimeSheetDAO dao = new ViewTimeSheetDAO();
		List<WorkTime> worktimelist = dao.findAll(user, ymd);
		return worktimelist;
	}
}
