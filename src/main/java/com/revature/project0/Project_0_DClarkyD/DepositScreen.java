<<<<<<< HEAD
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
		BankUser currentUser = ud.findByUsername(selectedUsername);
		BalanceHistory currentHistory = uh.findByUserName(selectedUsername);
		if (Selection != null) {
			try {
				Double d = Double.parseDouble(Selection);
				if (d > 0) {
					double currentCurrency = ud.findCurrency(selectedUsername);
					 
					currentUser.setCurrencyAmount(currentCurrency + d);

					ud.updateCurrency(selectedUsername, currentCurrency + d);
					ud.updateUser(currentUser);
					System.out.println(Selection + " currency has been inserted into your account.");
					
					currentCurrency = ud.findCurrency(selectedUsername);
					uh.updateHistory(currentHistory, 0, currentCurrency);

//					Map<Double, Character> history = new HashMap<>() ;
//					history = ud.findHistory(selectedUsername);
//					ud.setHistory(selectedUsername, d, "D");
//					System.out.println(	ud.findHistory(selectedUsername));
//					history.put(d, 'D'); 
//					currentUser.setHistory(history);

//					for(Map.Entry<Double, Character> entry : history.entrySet()) {
//						System.out.println(entry.getKey() + " : " + entry.getValue());
//					}

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
=======
package com.revature.project0.Project_0_DClarkyD;

import java.util.HashMap;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;

public class DepositScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;

	@Override
	public Screen start() {
		System.out.println("How much currency would you like to deposit?");
		String Selection = scan.nextLine();
		System.out.println("What username would you like to send the currency to?");
		String selectedUsername = scan.nextLine();
		BankUser currentUser = ud.findByUsername(selectedUsername);
		if (Selection != null) {
			try {
				Double d = Double.parseDouble(Selection);
				if (d > 0) {
					double currentCurrency = ud.findCurrency(selectedUsername);

//					System.out.println("monies: "+ currentUser.getCurrencyAmount());
//					System.out.println("currency:" + currentCurrency);
					currentUser.setCurrencyAmount(currentCurrency + d);
					System.out.println(Selection + " currency has been inserted into your account.");
//					System.out.println("currency:" + currentUser.getCurrencyAmount());
					ud.updateCurrency(selectedUsername, currentCurrency + d );

//					System.out.println("monies: "+ currentUser.getCurrencyAmount());

					ud.updateUser(currentUser);
					 currentCurrency = ud.findCurrency(selectedUsername);
//					 System.out.println("monies after update user: "+ currentUser.getCurrencyAmount());
//					System.out.println("currency:" + currentCurrency);
//					HashMap<Double, Character> history = new HashMap<Double,Character>();
//					history = currentUser.getHistory();
//					history.put(d, 'W'); 
//					currentUser.setHistory(history);

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
>>>>>>> 566448aa7102f5d03746b326412b9d0b2d783a55
