package com.revature.daos;

import java.util.ArrayList;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;

public interface historyDao {
	public static final historyDao currentHistoryDao = new HistoryDaoJdbc();
	void updateHistory(BalanceHistory h, double newBalance);
	void createHistory(BalanceHistory h);
	void printHistory(String username);
//	void setHistory(String username, Double d, String s);
//	public ArrayList<String> findStringHistory(String username);
	BalanceHistory findByUserName(String username);
	double findCurrency(String selectedUsername);
	void updateCurrency(String selectedUsername, double d);
	void updateUser(BankUser currentUser);
	
}
