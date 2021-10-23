package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");

		//入力値チェック
		if (userId.length() == 0 || userId == null || pass.length() == 0 || pass == null ||
				mail.length() == 0 || mail == null ||
				name.length() == 0 || name == null) {
			request.setAttribute("errorMsg", "ユーザー登録に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		} else {

			User user = new User(userId, pass, mail, name);
			RegisterLogic rl = new RegisterLogic();

			if (rl.execute(user)) {
				request.setAttribute("userId", userId);
				request.setAttribute("successMsg", "ユーザー登録に成功しました");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMsg", "ユーザー登録に失敗しました。ユーザーIDが既に使われています。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
