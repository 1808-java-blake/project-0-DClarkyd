package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;

public class RegisterGuest implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;

	@Override
	public Screen start() {
		BankUser u = new BankUser();
		System.out.println("Enter new username");
		u.setUsername(scan.nextLine());
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
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}
		
		return new LoginScreen();
	}

}
