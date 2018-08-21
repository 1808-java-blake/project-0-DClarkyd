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
		System.out.println("__________    _____  .____       _____    _______  _________ ___________");
		System.out.println("\\______   \\  /  _  \\ |    |     /  _  \\   \\      \\ \\_   ___ \\\\_   _____/");
		System.out.println(" |    |  _/ /  /_\\  \\|    |    /  /_\\  \\  /   |   \\/    \\  \\/ |    __)_ ");
		System.out.println(" |    |   \\/    |    \\    |___/    |    \\/    |    \\     \\____|        \\");
		System.out.println(" |______  /\\____|__  /_______ \\____|__  /\\____|__  /\\______  /_______  /");
		System.out.println("        \\/         \\/        \\/       \\/         \\/        \\/        \\/ ");
		System.out.println("For security purposes, please enter your username again: ");
		String username = scan.nextLine();
		System.out.println("Please enter the password:");
		String password = scan.nextLine();
		BalanceHistory currentHistory = uh.findByUserName(username);
		if (currentHistory != null) {
			double currentCurrency = uh.findCurrency(username);
			System.out.println("  _____________ ____________ _________ ___________ _________ _________");
			System.out.println(" /   _____/    |   \\_   ___ \\\\_   ___ \\\\_   _____//   _____//   _____/");
			System.out.println(" \\_____  \\|    |   /    \\  \\//    \\  \\/ |    __)_ \\_____  \\ \\_____  \\ ");
			System.out.println(" /        \\    |  /\\     \\___\\     \\____|        \\/        \\/        \\");
			System.out.println("/_______  /______/  \\______  /\\______  /_______  /_______  /_______  /");
			System.out.println("        \\/                 \\/        \\/        \\/        \\/        \\/ ");
				System.out.println("You currently have " + currentCurrency + " currency");
				
				BankScreen b = new BankScreen();
				return b;
				
		}
		System.out.println("You entered an incorrect username/password combination");
		System.out.println("Please try again.");
		return this;
	}

}
