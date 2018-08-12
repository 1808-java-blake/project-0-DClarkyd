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
