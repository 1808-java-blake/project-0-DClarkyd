package com.revature.daos;

import java.util.ArrayList;

import com.revature.beans.BalanceHistory;

public interface historyDao {
	public static final historyDao currentHistoryDao = HistorySerializer.us;
	void updateHistory(BalanceHistory h, double oldBalance, double newBalance);
	void createHistory(BalanceHistory h);
	void printHistory(String username);
//	void setHistory(String username, Double d, String s);
//	public ArrayList<String> findStringHistory(String username);
	BalanceHistory findByUserName(String username);
}
