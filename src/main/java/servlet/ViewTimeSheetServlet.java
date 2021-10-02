package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.ViewTimeSheetLogic;
import model.WorkTime;
import model.YearAndMonth;

@WebServlet("/ViewTimeSheetServlet")
public class ViewTimeSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		YearAndMonth ymd = new YearAndMonth();

		ViewTimeSheetLogic viewlogic = new ViewTimeSheetLogic();
		List<WorkTime> worktimelist = viewlogic.execute(user, ymd);

		request.setAttribute("worktimelist", worktimelist);

		//ログインしているかの確認
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {//ログインしていない
			response.sendRedirect("/WEB-INF/jsp/timesheet.jsp");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewtimesheet.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));

		if (userid != null && userid.length() != 0) {
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginuser");
		} else {
			request.setAttribute("errorMsg", "ユーザーIDが異なります");
		}

		User user = new User(userid);

		YearAndMonth ymd = new YearAndMonth(year, month);

		ViewTimeSheetLogic viewlogic = new ViewTimeSheetLogic();
		List<WorkTime> worktimelist = viewlogic.execute(user, ymd);

		request.setAttribute("worktimelist", worktimelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewtimesheet.jsp");
		dispatcher.forward(request, response);

	}
}
