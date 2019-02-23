package com.assignment.walletproject;

import java.math.BigDecimal;

/**
 * This class represents bank transactions operations like: withdraw, deposit..
 * 
 * @author Abeer Abu Mutawee
 *
 */
public class BankTransactionsUtil {
	synchronized public static void transfer(Account fromAcount, Account toAcount, BigDecimal amount) {
		fromAcount.withdraw(amount);
		toAcount.deposit(amount);
	}
}