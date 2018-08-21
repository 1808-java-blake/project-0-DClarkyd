package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class RegisterGuest implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	private historyDao hd = historyDao.currentHistoryDao;

	@Override
	public Screen start() {
		System.out.println("_____________________ ________.___  _________________________________________ ");
		System.out.println("\\______   \\_   _____//  _____/|   |/   _____/\\__    ___/\\_   _____/\\______   \\");
		System.out.println(" |       _/|    __)_/   \\  ___|   |\\_____  \\   |    |    |    __)_  |       _/");
		System.out.println(" |    |   \\|        \\    \\_\\  \\   |/        \\  |    |    |        \\ |    |   \\");
		System.out.println(" |____|_  /_______  /\\______  /___/_______  /  |____|   /_______  / |____|_  /");
		System.out.println("        \\/        \\/        \\/            \\/                    \\/         \\/ ");
		BankUser u = new BankUser();
		BalanceHistory h = new BalanceHistory();
		System.out.println("Enter new username");
		String d =scan.nextLine();
		u.setUsername(d);
		h.setUsername(d );
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());
		System.out.println("Enter estimated yearly income");
		String income = scan.nextLine();
		h.setBalanceChange(0.0);
//		h.setChangeTime(0.0);
		h.setCurrencyAmount(0.0);
		
		try {
			u.setIncome(Integer.valueOf(income));
			ud.createUser(u);
//			hd.createHistory(h);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}
		System.out.println("  _____________ ____________ _________ ___________ _________ _________");
		System.out.println(" /   _____/    |   \\_   ___ \\\\_   ___ \\\\_   _____//   _____//   _____/");
		System.out.println(" \\_____  \\|    |   /    \\  \\//    \\  \\/ |    __)_ \\_____  \\ \\_____  \\ ");
		System.out.println(" /        \\    |  /\\     \\___\\     \\____|        \\/        \\/        \\");
		System.out.println("/_______  /______/  \\______  /\\______  /_______  /_______  /_______  /");
		System.out.println("        \\/                 \\/        \\/        \\/        \\/        \\/ ");
		return new LoginScreen();
	}

}
