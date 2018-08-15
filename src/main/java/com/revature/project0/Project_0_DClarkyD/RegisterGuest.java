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
		
		try {
			u.setIncome(Integer.valueOf(income));
			ud.createUser(u);
			hd.createHistory(h);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}
		
		return new LoginScreen();
	}

}
