package com.revature.daos;

import com.revature.beans.BankUser;

public interface BankDao {
public static final BankDao currentUserDao = new BankDaoJdbc();
	/**
	 * Takes in a user object and will persist that user
	 * 
	 * @param u
	 */
	void createUser(BankUser u);
	BankUser findByUsernameAndPassword(String username, String password);
	BankUser findByUsername(String username);
	void updateIncome(BankUser u);
//	void updateCurrency(String username, double newAmount);
//	double findCurrency(String username);
//	Map<Double, Character> findHistory(String userName);

	void updateUser(BankUser u);
	void deleteUser(BankUser u);
//	void updateCurrency(String selectedUsername, double d);

}
