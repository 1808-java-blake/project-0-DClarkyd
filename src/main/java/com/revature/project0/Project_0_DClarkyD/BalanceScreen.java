package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;

public class BalanceScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("For security purposes, please enter your username again: ");
		String username = scan.nextLine();
		System.out.println("Please enter the password:");
		String password = scan.nextLine();
		BankUser currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			double currentCurrency = ud.findCurrency(username);
				System.out.println("You currently have " + currentCurrency + " currency");
				BankScreen b = new BankScreen();
				return b;
		}
		System.out.println("You entered an incorrect username/password combination");
		System.out.println("Please try again.");
		return this;
	}

}
