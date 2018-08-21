package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.screens.Screen;

public class AdminMainScreen implements Screen {

	
	private Scanner scan = new Scanner(System.in);

	public Screen start() {
		System.out.println("   _____  ________      _____  .___ _______   ");
		System.out.println("  /  _  \\ \\______ \\    /     \\ |   |\\      \\  ");
		System.out.println(" /  /_\\  \\ |    |  \\  /  \\ /  \\|   |/   |   \\ ");
		System.out.println("/    |    \\|    `   \\/    Y    \\   /    |    \\");
		System.out.println("\\____|__  /_______  /\\____|__  /___\\____|__  /");
		System.out.println("        \\/        \\/         \\/            \\/ ");
		System.out.println("Please choose from following options:");
		System.out.println("Enter 1 to Deposit currency");
		System.out.println("Enter 2 to withdraw currency");
		System.out.println("Enter 3 to view Balance History");
		System.out.println("Enter 4 to view transaction history");
		// if (ifAdmin)
		System.out.println("Enter 5 to view users' accounts/transaction history ");
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			DepositScreen d = new DepositScreen();
			return d;
		case "2":
			WithdrawalScreen w = new WithdrawalScreen();
			return w;
		case "3":
			BalanceScreen b = new BalanceScreen();
			return b;

		case "4":
			HistoryScreen h = new HistoryScreen();
			return h;
		case "5":
			AdminScreen a = new AdminScreen();
			return a;
		default:
			break;
		}

		return this;
	}

}
