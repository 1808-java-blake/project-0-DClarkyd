package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.BalanceHistory;
import com.revature.beans.BankUser;
import com.revature.util.ConnectionUtil;

public class HistoryDaoJdbc implements historyDao {
	private ConnectionUtil cu = ConnectionUtil.cu;
	private Logger log = Logger.getRootLogger();

	@Override
	public void updateHistory(BalanceHistory h, double newBalance) {
		String username = h.getUsername();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(

					"INSERT INTO bank_transactions (username, current_balance, change_amount) VALUES (?,?,?);");
			Double newAmount = h.getNewBalance();
			ps.setString(1, username);
			ps.setDouble(2, newBalance);
//			ps.setDouble(3, h.getOldBalance() - h.getNewBalance());
			ps.setDouble(3, 0);
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
//				h.setBalanceHistory(oldBalance, newBalance);
	}

	@Override
	public void createHistory(BalanceHistory h) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO bank_transactions (username, current_balance, change_amount) VALUES (?,?,?)");
//			ps.setDouble(1, u.getUserId());
			ps.setString(1, h.getUsername());
			ps.setDouble(2, h.getCurrentBalance());
			ps.setDouble(3, h.getBalanceChange());
//			ps.setTimestamp(4, h.get);

			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
	}

	@Override
	public void printHistory(String username) {
		try (Connection conn = cu.getConnection()) {

			PreparedStatement psCount = conn.prepareStatement("SELECT COUNT(username) FROM bank_transactions;");
			ResultSet rsCount = psCount.executeQuery();
			int count = 1;
			if (rsCount.next()) {
				count = rsCount.getInt("count");

//				System.out.println("QUery length" + count);
			}
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_transactions WHERE username=?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				for (int i = 1; i < count; i++) {
					if (rs.next()) {
						System.out.println(rs.getString("current_balance"));
						rs.next();
					}
				}
//				BalanceHistory h = new BalanceHistory();
//				h.setUsername(rs.getString("username"));
//				h.setBalanceChange(rs.getDouble("change_amount"));
//				h.setCurrencyAmount(rs.getDouble("current_balance"));
//				h.printBalanceHistory();
//				
			} else {
				log.warn("failed to find user with provided credentials from the db");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BalanceHistory findByUserName(String username) {
		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_transactions WHERE username=?;");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BalanceHistory h = new BalanceHistory();

				h.setUsername(rs.getString("username"));
				h.setBalanceChange(rs.getDouble("change_amount"));
				h.setCurrencyAmount(rs.getDouble("current_balance"));
				return h;
			} else {
				log.warn("failed to find user with provided credentials from the db");
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double findCurrency(String selectedUsername) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement psCount = conn.prepareStatement("SELECT COUNT(username) FROM bank_transactions;");
			ResultSet rsCount = psCount.executeQuery();
			int count = 1;
			if (rsCount.next()) {
				count = rsCount.getInt("count");

//				System.out.println("QUery length" + count);
			}
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_transactions WHERE username= ? AND historyid = ?;");
			ps.setString(1, selectedUsername);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getDouble("current_balance");
			}
			else {
				log.warn("failed to find user with provided credentials from the db");
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateCurrency(String selectedUsername, double d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(BankUser currentUser) {
		// TODO Auto-generated method stub

	}

}
