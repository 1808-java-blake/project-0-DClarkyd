package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class DepositScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	private historyDao uh = historyDao.currentHistoryDao;
	
	@Override
	public Screen start() {
		System.out.println("How much currency would you like to deposit?");
		String Selection = scan.nextLine();
		System.out.println("What username would you like to send the currency to?");
		String selectedUsername = scan.nextLine();
		BalanceHistory currentHistory = uh.findByUserName(selectedUsername);
		if (Selection != null) {
			try {
				Double d = Double.parseDouble(Selection);
				if (d > 0) {
					double currentCurrency = uh.findCurrency(selectedUsername) +d;
					 
//					currentHistory.setCurrencyAmount(currentCurrency + d);

//					uh.updateCurrency(selectedUsername, currentCurrency + d);
//					uh.createHistory(currentHistory);
					System.out.println(Selection + " currency has been inserted into your account.");
					
//					currentCurrency = uh.findCurrency(selectedUsername) + d;
					uh.updateHistory(currentHistory, currentCurrency);

					BankScreen b = new BankScreen();
					return b;
				} else {
					System.out.println("Please do not enter negative numbers");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please only enter numbers.");
			}
		}
		System.out.println("Please try again");
		return this;
	}
}
