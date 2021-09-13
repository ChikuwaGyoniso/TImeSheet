package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ViewTimeSheetLogic;
import model.WorkTime;

@WebServlet("/ViewTimeSheetServlet")
public class ViewTimeSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WorkTime worktime = new WorkTime();

		ViewTimeSheetLogic viewlogic = new ViewTimeSheetLogic();
		List<WorkTime> worktimelist = viewlogic.execute(worktime);

		request.setAttribute("worktimelist", worktimelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewtimesheet.jsp");
		dispatcher.forward(request, response);
	}

}
