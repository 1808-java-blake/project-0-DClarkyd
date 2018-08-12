package com.revature.project0.Project_0_DClarkyD;

import java.util.HashMap;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;

public class WithdrawalScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;

	@Override
	public Screen start() {
		System.out.println("How much currency would you like to withdraw?");
		String Selection = scan.nextLine();
		System.out.println("What username would you like to withdraw the currency from?");
		String selectedUsername = scan.nextLine();
		System.out.println("Please enter the password again for security purposes");
		String selectedPassword = scan.nextLine();
		BankUser currentUser = ud.findByUsernameAndPassword(selectedUsername, selectedPassword);
		if (Selection != null) {
			try {
				Double d = Double.parseDouble(Selection);
				if (d > 0) {

					if (currentUser != null) {
						double currentCurrency = ud.findIncome(currentUser);
						if (currentCurrency - d >= 0) {
							currentUser.setCurrencyAmount(currentCurrency - d);
							System.out.println(Selection + " currency has been withdrawed your account.");
							
							HashMap<Double, Character> history = currentUser.getHistory();
							history.put(d, 'W');
							currentUser.setHistory(history);
							
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
