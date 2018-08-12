package com.revature.project0.Project_0_DClarkyD;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import com.revature.beans.BankUser;
import com.revature.daos.BankDao;
import com.revature.screens.Screen;

public class HistoryScreen implements Screen{
	
private Scanner scan = new Scanner (System.in);
private BankDao ud = BankDao.currentUserDao;

	@Override
	public Screen start() {
		System.out.println("What username would you like to see the history of?");
		String userName = scan.nextLine();
		System.out.println("Please enter the password for that username:");
		String password = scan.nextLine();
		BankUser currentUser = ud.findByUsernameAndPassword(userName, password);
		if(currentUser != null) {
			HashMap<Double, Character> history = currentUser.getHistory();
			
			Iterator it = history.entrySet().iterator();
			while (it.hasNext()) {
				Entry pairs = (Entry)it.next()	;
				System.out.println("key, " +pairs.getKey()+ " value" + pairs.getValue());
			}
//			for(Object entry : history.entrySet()) {
//				  String key = entry.getKey();
//				  Integer value = entry.getValue();
//
//				  System.out.println(key + " => " + value);
//				}
		}
		// TODO Auto-generated method stub
		return null;
	}

}
