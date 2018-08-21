package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class BalanceScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	private historyDao uh = historyDao.currentHistoryDao;
	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("For security purposes, please enter your username again: ");
		String username = scan.nextLine();
		System.out.println("Please enter the password:");
		String password = scan.nextLine();
		BalanceHistory currentHistory = uh.findByUserName(username);
		if (currentHistory != null) {
			double currentCurrency = uh.findCurrency(username);
				System.out.println("You currently have " + currentCurrency + " currency");
				BankScreen b = new BankScreen();
				return b;
		}
		System.out.println("You entered an incorrect username/password combination");
		System.out.println("Please try again.");
		return this;
	}

}
