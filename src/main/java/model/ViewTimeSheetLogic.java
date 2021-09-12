package model;

import java.util.List;

import dao.ViewTimeSheetDAO;

public class ViewTimeSheetLogic {
	public List<WorkTime> execute(WorkTime worktime) {
		ViewTimeSheetDAO dao = new ViewTimeSheetDAO();
		List<WorkTime> worktimelist = dao.findAll(worktime);
		return worktimelist;
	}
}
