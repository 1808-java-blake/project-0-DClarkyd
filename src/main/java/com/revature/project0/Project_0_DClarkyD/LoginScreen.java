package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;



public class LoginScreen implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	private BankDao ud = BankDao.currentUserDao;
	
	@Override
	public Screen start() {
		System.out.println(" __      __       .__                               ");
		System.out.println("/  \\    /  \\ ____ |  |   ____  ____   _____   ____  ");
		System.out.println("\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ ");
		System.out.println(" \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ ");
		System.out.println("  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >");
		System.out.println("       \\/       \\/          \\/            \\/     \\/ ");
		System.out.println("Enter Username or type Register to sign up: ");
		String username = scan.nextLine();
		if ("register".equalsIgnoreCase(username)) {
			return new RegisterGuest();
		}
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		BankUser currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			if(username.equals("admin")){
				return new AdminMainScreen();
			}
			return new BankScreen();
		}

		System.out.println("unable to login");
		return this;
	}

}
