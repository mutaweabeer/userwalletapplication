package com.assignment.walletproject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents Users-Info Getter Manager<br>
 * This class contains already register users, please start the application using one of theses users names :user1, user2 and user4
 * 
 * @author Abeer Abu Mutawee
 *
 */
public class UsersInfoGetterManager {
	private static UsersInfoGetterManager instance = null;

	private UsersInfoGetterManager() {
	}

	// We can make this synchronized but in our case we do not need
	public static UsersInfoGetterManager getInstance() {
		if (instance == null) {
			instance = new UsersInfoGetterManager();
		}

		return instance;
	}

	/**
	 * 
	 * @return The manually registered users supposing this wallet application needs a register before can access the land page for wallet info
	 */
	public Collection<UserInfo> getRegisteredUsersInfos() {
		Collection<UserInfo> registeredUsersInfos = new ArrayList<>();

		Account walletAccount1 = new Account(new BigDecimal("50"), "user1");
		Account bankAccount1 = new Account(new BigDecimal("0"), "user1");
		UserInfo userInfo1 = new UserInfo("Ahmad Ali", "34", walletAccount1, bankAccount1);
		registeredUsersInfos.add(userInfo1);

		Account walletAccount2 = new Account(new BigDecimal("50"), "user2");
		Account bankAccount2 = new Account(new BigDecimal("0"), "user2");
		UserInfo userInfo2 = new UserInfo("Mahmoud Sameer", "34", walletAccount2, bankAccount2);
		registeredUsersInfos.add(userInfo2);

		Account walletAccount3 = new Account(new BigDecimal("50"), "user3");
		Account bankAccount3 = new Account(new BigDecimal("0"), "user3");
		UserInfo userInfo3 = new UserInfo("Weal Ghanim", "34", walletAccount3, bankAccount3);
		registeredUsersInfos.add(userInfo3);

		return registeredUsersInfos;
	}

	/**
	 * @param userName
	 * @return Current LoggedIn User Info according to the passed user-name parameter since this value linked to the account and we consider the wallet as account
	 */
	public UserInfo getCurrentLoggedInUserInfo(String userName) {
		for (UserInfo userInfo : getRegisteredUsersInfos()) {
			if (userInfo.getBankAccount().getUserID().equals(userName) && userInfo.getWalletAccount().getUserID().equals(userName)) {
				return userInfo;
			}
		}

		return null;
	}
}