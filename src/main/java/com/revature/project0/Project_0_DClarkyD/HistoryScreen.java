package com.revature.project0.Project_0_DClarkyD;

import java.util.Scanner;

import com.revature.beans.BalanceHistory;
import com.revature.daos.BankDao;
import com.revature.daos.historyDao;
import com.revature.screens.Screen;

public class HistoryScreen implements Screen{
	
private Scanner scan = new Scanner (System.in);
private historyDao uh = historyDao.currentHistoryDao;

	@Override
	public Screen start() {
		System.out.println("  ___ ___ .___  ____________________________ _______________.___.");
		System.out.println(" /   |   \\|   |/   _____/\\__    ___/\\_____  \\\\______   \\__  |   |");
		System.out.println("/    ~    \\   |\\_____  \\   |    |    /   |   \\|       _//   |   |");
		System.out.println("\\    Y    /   |/        \\  |    |   /    |    \\    |   \\\\____   |");
		System.out.println(" \\___|_  /|___/_______  /  |____|   \\_______  /____|_  // ______|");
		System.out.println("       \\/             \\/                    \\/       \\/ \\/       ");
		System.out.println("What username would you like to see the history of?");
		String userName = scan.nextLine();
		System.out.println("Please enter the password for that username:");
		String password = scan.nextLine();
		uh.printHistory(userName);
		BalanceHistory currentHistory = uh.findByUserName(userName);
		if(currentHistory != null) {

			currentHistory.printBalanceHistory();
//			ArrayList<Double> historyOfValues = ud.findValueHistory(userName);
//			ArrayList<String> historyOfStrings = ud.findStringHistory(userName);
//			
//			for(int i = 0; i < historyOfValues.size(); i++) {
//				System.out.println(historyOfValues.get(i));
//				System.out.println(historyOfStrings.get(i));
//			}
//			Map<Double, Character> history = currentUser.getHistory();
			
//			Iterator it = history.entrySet().iterator();
//			while (it.hasNext()) {
//				Entry pairs = (Entry)it.next()	;
//				System.out.println("key, " +pairs.getKey()+ " value" + pairs.getValue());
//			}
//			for(Object entry : history.entrySet()) {
//				  String key = entry.getKey();
//				  Integer value = entry.getValue();
//
//				  System.out.println(key + " => " + value);
//				}
			System.out.println("  _____________ ____________ _________ ___________ _________ _________");
			System.out.println(" /   _____/    |   \\_   ___ \\\\_   ___ \\\\_   _____//   _____//   _____/");
			System.out.println(" \\_____  \\|    |   /    \\  \\//    \\  \\/ |    __)_ \\_____  \\ \\_____  \\ ");
			System.out.println(" /        \\    |  /\\     \\___\\     \\____|        \\/        \\/        \\");
			System.out.println("/_______  /______/  \\______  /\\______  /_______  /_______  /_______  /");
			System.out.println("        \\/                 \\/        \\/        \\/        \\/        \\/ ");
			BankScreen b = new BankScreen();
			return b;
		}
		// TODO Auto-generated method stub
		return null;
	}

}
