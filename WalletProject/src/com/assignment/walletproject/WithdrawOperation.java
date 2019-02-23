package com.assignment.walletproject;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WithdrawOperation
 */
@WebServlet("/WithdrawOperation")
public class WithdrawOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WithdrawOperation() {
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

		HttpSession session = request.getSession();
		UserInfo currentLoggedInUserInfo = (UserInfo) session.getAttribute("currentLoggedInUserInfo");
		request.setAttribute("currentLoggedInUserInfo", currentLoggedInUserInfo);

		String moneyAmount = request.getParameter("moneyAmount");
		if (!isNumeric(moneyAmount) || isEmpty(moneyAmount)) {
			session.setAttribute("WithdrawSuccessfulMessage", "");
			session.setAttribute("WithdrawErrorMessage", "Invalid amount to withdraw, Please try again");
			request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
			return;
		}

		BigDecimal moneyAmountDecimal = new BigDecimal(moneyAmount);
		if (moneyAmountDecimal.compareTo(currentLoggedInUserInfo.getWalletAccount().getBalance()) >= 1) {
			session.setAttribute("WithdrawSuccessfulMessage", "");
			session.setAttribute("WithdrawErrorMessage", "You doesn't have enough money for withdraw operation");
			request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
			return;
		}

		BankTransactionsUtil.transfer(currentLoggedInUserInfo.getWalletAccount(), currentLoggedInUserInfo.getBankAccount(), moneyAmountDecimal);

		session.setAttribute("WithdrawErrorMessage", "");
		session.setAttribute("WithdrawSuccessfulMessage", "Withdraw operation compeleted successfully");
		request.setAttribute("currentLoggedInUserInfo", currentLoggedInUserInfo);

		request.getRequestDispatcher("userAccountInfo.jsp").forward(request, response);
	}

	private boolean isNumeric(String parameter) {
		String tempParamter = parameter;
		if (parameter.contains(".")) {
			tempParamter = parameter.replace(".", "");
			if (tempParamter.contains(".")) {
				return false;
			}
		}

		return tempParamter.chars().allMatch(Character::isDigit);

	}

	private boolean isEmpty(String parameter) {
		return parameter == null || parameter == "" || BigDecimal.ZERO.equals(new BigDecimal(parameter));

	}
}
