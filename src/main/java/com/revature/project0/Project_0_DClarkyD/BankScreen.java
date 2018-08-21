package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.screens.Screen;

public class BankScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	public Screen start() {
		System.out.println("________              /\\         __________                __   .__                    _____                 ");
		System.out.println("\\______ \\ _____    ___)/  ______ \\______   \\_____    ____ |  | _|__| ____    ____     /  _  \\ ______ ______  "		);
		System.out.println(" |    |  \\\\__  \\  /    \\ /  ___/  |    |  _/\\__  \\  /    \\|  |/ /  |/    \\  / ___\\   /  /_\\  \\\\____ \\\\____ \\ ");
		System.out.println(" |    `   \\/ __ \\|   |  \\\\___ \\   |    |   \\ / __ \\|   |  \\    <|  |   |  \\/ /_/  > /    |    \\  |_> >  |_> >");
		System.out.println("/_______  (____  /___|  /____  >  |______  /(____  /___|  /__|_ \\__|___|  /\\___  /  \\____|__  /   __/|   __/ ");
		System.out.println("        \\/     \\/     \\/     \\/          \\/      \\/     \\/     \\/       \\//_____/           \\/|__|   |__|    ");
		System.out.println("Please choose from following options:");
		System.out.println("Enter 1 to Deposit currency");
		System.out.println("Enter 2 to withdraw currency");
		System.out.println("Enter 3 to view Balance");
		System.out.println("Enter 4 to view transaction history");
		// if (ifAdmin)
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
		default:
			break;
		}

		return this;
	}

}
