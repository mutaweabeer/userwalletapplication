package com.assignment.walletproject;

import java.math.BigDecimal;

/**
 * This class represents user account
 * 
 * @author Abeer Abu Mutawee
 *
 */
public class Account {
	private int accountID;
	private BigDecimal balance;
	private String userID;

	public Account(BigDecimal balance, String userID) {
		this.balance = balance;
		this.userID = userID;
		this.accountID = (int) Math.random();
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void deposit(BigDecimal amount) {
		this.balance = balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		this.balance = balance.subtract(amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		return true;
	}
}