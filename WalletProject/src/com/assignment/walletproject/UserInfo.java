package com.assignment.walletproject;

/**
 * This class presents user information to be shown
 * 
 * @author Abeer Abu Mutawee
 *
 */
public class UserInfo {
	private String fullName;
	private String age;
	private Account walletAccount;
	private Account bankAccount;

	public UserInfo(String fullName, String age, Account walletAccount, Account bankAccount) {
		this.fullName = fullName;
		this.age = age;
		this.walletAccount = walletAccount;
		this.bankAccount = bankAccount;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Account getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(Account walletAccount) {
		this.walletAccount = walletAccount;
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((walletAccount == null) ? 0 : walletAccount.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (walletAccount == null) {
			if (other.walletAccount != null)
				return false;
		} else if (!walletAccount.equals(other.walletAccount))
			return false;
		return true;
	}
}
