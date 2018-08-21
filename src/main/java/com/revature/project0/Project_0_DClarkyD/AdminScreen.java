package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class AdminScreen implements Screen{
	
	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	private historyDao uh = historyDao.currentHistoryDao;
	
	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("What username would you like to access?");
		String selectedUsername = scan.nextLine();
		BalanceHistory currentHistory = uh.findByUserName(selectedUsername);
		if (selectedUsername != null) {
			double currentCurrency = uh.findCurrency(selectedUsername);
				System.out.println(selectedUsername + " currently has " + currentCurrency + " currency");
				System.out.println("History:");
				currentHistory.printBalanceHistory();
				BankScreen b = new BankScreen();
				return b;
		}
		System.out.println("You entered an incorrect username");
		System.out.println("Please try again.");
		return this;
	}
}
