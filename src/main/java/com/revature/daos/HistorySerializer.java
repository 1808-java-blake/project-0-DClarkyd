//package com.revature.daos;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//import com.revature.beans.BalanceHistory;
////import com.revature.beans.BankUser;
//
//public class HistorySerializer implements historyDao {
//	public static final HistorySerializer us = new HistorySerializer();
//	
//	private HistorySerializer() {
//		super();
//	}
//	
//	@Override
//	public void updateHistory(BalanceHistory h, double oldBalance, double newBalance) {
//		String username = h.getUsername();
//		try (ObjectInputStream ois = new ObjectInputStream(
//				new FileInputStream("src/main/resources/users/" + username + "History.txt"))) {
//
//			BalanceHistory b =  (BalanceHistory) ois.readObject(); // retrieve balance history if it can
//			b.setBalanceHistory(oldBalance, newBalance);
////			return (u.getStringsHistory());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
////		e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
////		e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void createHistory(BalanceHistory b) {
//		if (b == null) {
//			return;
//		}
//		File f = new File("src/main/resources/users/" + b.getUsername() + "History.txt");
//		System.out.println(f.getName());
//		if (f.exists()) {
//			return;
//		}
//		try {
//			f.createNewFile();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			return;
//		}
//		try (ObjectOutputStream oos = new ObjectOutputStream(
//				new FileOutputStream("src/main/resources/users/" + b.getUsername() + "History.txt"))) {
//
//			oos.writeObject(b);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void printHistory(String username) {
//		try (ObjectInputStream ois = new ObjectInputStream(
//				new FileInputStream("src/main/resources/users/" + username + "History.txt"))) {// this makes a new one
//																								// instead
//			// of finding old one
//
//			BalanceHistory b = (BalanceHistory) ois.readObject(); // retrieve the user if it can
//			b.printBalanceHistory();
////			return (u.getStringsHistory());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
////		e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
////		e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
////		e.printStackTrace();
//		}
//	}
//
//	
//
//	@Override
//	public BalanceHistory findByUserName(String username) {
//		// verify that what was passed in is not null
//				if (username == null) {
//					return null;
//				}
//				try (ObjectInputStream ois = new ObjectInputStream(
//						new FileInputStream("src/main/resources/users/" + username + "History.txt"))) {
//
//					BalanceHistory b = (BalanceHistory) ois.readObject(); // retrieve the user if it can
//
//					return b;
//
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
////					e.printStackTrace();
//				}
//				return null;
//	}
//
//
//
//}
