package servlet;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChangeStringTime;
import model.TimeRegisterLogic;
import model.WorkTime;

@WebServlet("/RegisterTimeServlet")
public class RegisterTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timesheet.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ChangeStringTime changetime = new ChangeStringTime();

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String date = request.getParameter("date");
		Time start_time = changetime.ChangeTime(request.getParameter("start_time"));
		Time end_time = changetime.ChangeTime(request.getParameter("end_time"));
		String work_contents = request.getParameter("work_contents");
		Time nomal_time = changetime.ChangeTime(request.getParameter("nomal_time"));
		Time midnight_time = changetime.ChangeTime(request.getParameter("midnight_time"));
		Time holiday_time = changetime.ChangeTime(request.getParameter("holiday_time"));
		Time holiday_midnight_time = changetime.ChangeTime(request.getParameter("holiday_midnight_time"));
		Time worktime_sum = changetime.ChangeTime(request.getParameter("worktime_sum"));

		//入力値チェック
		if (userid.length() == 0 || userid == null || date.length() == 0 || date == null || start_time == null
				|| end_time == null ||
				work_contents.length() == 0 || work_contents == null || nomal_time == null || midnight_time == null
				|| holiday_time == null ||
				holiday_midnight_time == null || worktime_sum == null) {
			request.setAttribute("errorMsg", "労働時間登録に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/timesheet.jsp");
			dispatcher.forward(request, response);
		} else {
			WorkTime worktime = new WorkTime(userid, date, start_time, end_time, work_contents, nomal_time,
					midnight_time, holiday_time, holiday_midnight_time, worktime_sum);
			TimeRegisterLogic trl = new TimeRegisterLogic();
			trl.execute(worktime);
			request.setAttribute("successMsg", "労働時間登録に成功しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/timesheet.jsp");
			dispatcher.forward(request, response);
		}
	}

}
