package com.assignment.walletproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WalletProject(Land Page)
 */
@WebServlet("/WalletProject")
public class WalletProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WalletProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		String loggedInUserName = request.getParameter("userID");
		if (isEmpty(loggedInUserName)) {
			HttpSession session = request.getSession();
			session.setAttribute("ErrorMessage", "Cannot login with empty user name, Please press'Go Back' to try again");
			response.sendRedirect("loginError.jsp");
			return;
		}

		UserInfo currentLoggedInUserInfo = UsersInfoGetterManager.getInstance().getCurrentLoggedInUserInfo(loggedInUserName);
		request.setAttribute("currentLoggedInUserInfo", currentLoggedInUserInfo);

		UserInfo userInfo = (UserInfo) request.getAttribute("currentLoggedInUserInfo");
		if (userInfo == null) {
			HttpSession session = request.getSession();
			session.setAttribute("ErrorMessage", "No account has been specified for user - " + loggedInUserName + ", Please press'Go Back' to try again");
			response.sendRedirect("loginError.jsp");
			return;
		}

		request.setAttribute("Name", userInfo.getFullName());
		request.setAttribute("Age", userInfo.getAge());
		request.setAttribute("Wallet Account", userInfo.getWalletAccount());
		request.setAttribute("Wallet Account", userInfo.getWalletAccount());

		HttpSession session = request.getSession();
		session.setAttribute("userID", loggedInUserName);

		request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
	}

	private boolean isEmpty(String loggedInUserName) {
		return loggedInUserName == null || loggedInUserName == "";
	}

}
