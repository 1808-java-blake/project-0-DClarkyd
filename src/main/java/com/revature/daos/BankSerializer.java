<<<<<<< HEAD
package com.revature.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;

public class BankSerializer implements BankDao {
	public static final BankSerializer us = new BankSerializer();

	private BankSerializer() {
		super();
	}
	
	public void createUser(BankUser u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
		System.out.println(f.getName());
		if (f.exists()) {
			return;
		}
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BankUser findByUsernameAndPassword(String username, String password) {
		// verify that what was passed in is not null
		if (username == null || password == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
			// verify that the password matches
			if (password.equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUser(BankUser u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(BankUser u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
//		System.out.println(f.getName());

		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BankUser findByUsername(String username) {
		// verify that what was passed in is not null
		if (username == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
			// verify that the password matches

			return u;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public double findIncome(BankUser u) {
//		// TODO Auto-generated method stub
//		BankUser u = (BankUser) ois.readObject();
//		return 0;
//	}

	@Override
	public void updateIncome(BankUser u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCurrency(String username, double newAmount) {
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can

			u.setCurrencyAmount(newAmount);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public double findCurrency(String username) {
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {// this makes a new one instead
																						// of finding old one

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can

			return u.getCurrencyAmount();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return 0;
	}

//	@Override
//	public Map<Double, Character> findHistory(String username) {
//		try (ObjectInputStream ois = new ObjectInputStream(
//				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {//this makes a new one instead of finding old one
//
//			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
//
////			return u.getHistory();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
//		return null;
//	}

}
=======
package com.revature.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.BankUser;

public class BankSerializer implements BankDao {
	public static final BankSerializer us = new BankSerializer();

	private BankSerializer() {
		super();
	}

	public void createUser(BankUser u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
		System.out.println(f.getName());
		if (f.exists()) {
			return;
		}
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BankUser findByUsernameAndPassword(String username, String password) {
		// verify that what was passed in is not null
		if (username == null || password == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
			// verify that the password matches
			if (password.equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUser(BankUser u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(BankUser u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
//		System.out.println(f.getName());

		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BankUser findByUsername(String username) {
		// verify that what was passed in is not null
		if (username == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
			// verify that the password matches

			return u;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public double findIncome(BankUser u) {
//		// TODO Auto-generated method stub
//		BankUser u = (BankUser) ois.readObject();
//		return 0;
//	}

	@Override
	public void updateIncome(BankUser u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCurrency(String username, double newAmount) {
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can
			
			u.setCurrencyAmount(newAmount);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public double findCurrency(String username) {
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {//this makes a new one instead of finding old one

			BankUser u = (BankUser) ois.readObject(); // retrieve the user if it can

			return u.getCurrencyAmount();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 300;
	}

}
>>>>>>> 566448aa7102f5d03746b326412b9d0b2d783a55
