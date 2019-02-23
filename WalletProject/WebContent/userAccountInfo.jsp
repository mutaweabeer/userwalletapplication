<%@ page import="com.assignment.walletproject.UserInfo" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Account Information</title>
</head>
<body>
	<form action="/WalletProject/WithdrawOperation" method="post">

		<h1>
			<b><br /> Welcome To Your Information </b><br />
		</h1>
		<hr>

		<p style="color: red">
			<%
				if (session.getAttribute("WithdrawErrorMessage") != null) {
					out.println(session.getAttribute("WithdrawErrorMessage"));
				}
			%>
		</p>
		<p style="color: Green">
			<%
				if (session.getAttribute("WithdrawSuccessfulMessage") != null) {
					out.println(session.getAttribute("WithdrawSuccessfulMessage"));
				}
			%>
		</p>
		<br />

		<%
			UserInfo userInfo = (UserInfo) request.getAttribute("currentLoggedInUserInfo");//return object that has been set by the request.
			out.println(" <b><br/>Your Full Name:<br/></b>");
			out.print(userInfo.getFullName());
			out.println("<BR>");
			out.println(" <b><br/>Your Age:<br/> </b>");
			out.print(userInfo.getAge());
			out.println("<BR>");
			out.println(" <b><br/>Your Wallet Balance:<br/></b>");
			out.print(userInfo.getWalletAccount().getBalance());
			out.println("<BR>");
			out.println(" <b><br/>Your Bank Balance:<br/></b>");
			out.print(userInfo.getBankAccount().getBalance());

			session.setAttribute("currentLoggedInUserInfo", userInfo);
		%>



		<p>
			<b>Enter the money amount:</b>
		</p>
		<input type="text" name="moneyAmount"
			onkeypress="return event.keyCode != 13;">
		<button name="withdraw"
			onClick="this.disabled=true; this.form.submit(); ">Withdraw</button>
	</form>

</body>
</html>
