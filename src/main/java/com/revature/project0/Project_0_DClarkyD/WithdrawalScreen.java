package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class WithdrawalScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	private historyDao uh = historyDao.currentHistoryDao;
	
	@Override
	public Screen start() {
		System.out.println("How much currency would you like to withdraw?");
		String Selection = scan.nextLine();
		System.out.println("What username would you like to withdraw the currency from?");
		String selectedUsername = scan.nextLine();
		System.out.println("Please enter the password again for security purposes");
		String selectedPassword = scan.nextLine();
		BankUser currentUser = ud.findByUsernameAndPassword(selectedUsername, selectedPassword);
		BalanceHistory currentHistory = uh.findByUserName(selectedUsername);
		if (Selection != null) {
			try {
				Double d = Double.parseDouble(Selection);
				if (d > 0) {

					if (currentUser != null) {
						double currentCurrency = uh.findCurrency(selectedUsername);
						if (currentCurrency - d >= 0) {
//							currentUser.setCurrencyAmount(currentCurrency - d);
//							uh.updateCurrency(selectedUsername, currentCurrency - d );
//							uh.updateUser(currentUser);					double currentCurrency = uh.findCurrency(selectedUsername);
							 
//							currentHistory.setCurrencyAmount(currentCurrency - d);

//							uh.updateCurrency(selectedUsername, currentCurrency - d);
//							uh.createHistory(currentHistory);
							
							currentCurrency = uh.findCurrency(selectedUsername);
							uh.updateHistory(currentHistory, currentCurrency - d);
							System.out.println(Selection + " currency has been withdrawed from your account.");
//							currentCurrency = uh.findCurrency(selectedUsername);
//							uh.updateHistory(currentHistory,  currentCurrency);
							
//							HashMap<Double, Character> history = ud.findHistory(selectedUsername);
//							history.put(d, 'W');
//							currentUser.setHistory(history);
							
							BankScreen b = new BankScreen();
							return b;
						}
					}
					System.out.println("You entered an incorrect username/password combination");
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
