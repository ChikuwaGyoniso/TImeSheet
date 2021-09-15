package model;

import java.util.List;

import dao.ViewTimeSheetDAO;

public class ViewTimeSheetLogic {
	public List<WorkTime> execute(User user) {
		ViewTimeSheetDAO dao = new ViewTimeSheetDAO();
		List<WorkTime> worktimelist = dao.findAll(user);
		return worktimelist;
	}
}
