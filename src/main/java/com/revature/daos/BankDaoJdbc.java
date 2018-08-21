package com.revature.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.beans.BankUser;
import com.revature.util.ConnectionUtil;

public class BankDaoJdbc implements BankDao{
	private ConnectionUtil cu = ConnectionUtil.cu;
	private Logger log = Logger.getRootLogger();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void createUser(BankUser u) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO bank_user ( username, lastname, firstname, income, password) VALUES (?,?,?,?,?)");
//			ps.setDouble(1, u.getUserId());
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getFirstName());
			ps.setDouble(4, u.getIncome());
			ps.setString(5, u.getPassword());
			int recordsCreated = ps.executeUpdate();
			
			PreparedStatement idps = conn.prepareStatement(
					"SELECT * FROM bank_user WHERE username=?");

			idps.setString(1,u.getUsername());
			ResultSet rs = idps.executeQuery();
			int userid = 0 ;
			
			if(rs.next()) {
				userid = rs.getInt("userid");
			} else {
				log.warn("failed to find user with provided credentials from the db");
			}
			
			PreparedStatement hps = conn.prepareStatement(
					"INSERT INTO bank_transactions(userid, username, current_balance) VALUES (?,?,?)");
			hps.setInt(1, userid);
			hps.setString(2, u.getUsername());
			hps.setDouble(3, 0.0);
			int recordsCreated3 = hps.executeUpdate();
			
			log.trace(recordsCreated + " records created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for(StackTraceElement ste: e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to create new user");
		}
	}

	@Override
	public BankUser findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM bank_user WHERE username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				BankUser u = new BankUser();
				u.setUserId(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setLastName(rs.getString("lastname"));
				u.setFirstName(rs.getString("firstname"));
				u.setIncome(rs.getInt("income"));
//				u.setCurrencyAmount(rs.getDouble("currency_amount"));
				return u;
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
	public BankUser findByUsername(String username) {
		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM bank_user WHERE username=?;");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				BankUser u = new BankUser();
				u.setUserId(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setLastName(rs.getString("lastname"));
				u.setFirstName(rs.getString("firstname"));
				u.setIncome(rs.getInt("income"));
//				u.setCurrencyAmount(rs.getDouble("currency_amount"));
				return u;
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
	public void updateIncome(BankUser u) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void updateCurrency(String username, double newAmount) {
//		try (Connection conn = cu.getConnection()) {
//			PreparedStatement ps = conn.prepareStatement(
//					"UPDATE bank_user SET currency_amount = ? WHERE username = ?");
////			ps.setDouble(1, u.getUserId());
//			BankUser u = findByUsername(username);
//			
//			ps.setDouble(1,newAmount);
//			ps.setString(2,username);
//
//
//			int recordsCreated = ps.executeUpdate();
//			log.trace(recordsCreated + " records created");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			log.error(e.getMessage());
//			for(StackTraceElement ste: e.getStackTrace()) {
//				log.error(ste);
//			}
//			log.warn("failed to create new user");
//		}
//	}

//	@Override
//	public double findCurrency(String username) {
//		try (Connection conn = cu.getConnection()) {
//
//			PreparedStatement ps = conn.prepareStatement(
//					"SELECT * FROM bank_user WHERE username=?;");
//			ps.setString(1, username);
//
//			ResultSet rs = ps.executeQuery();
//					
//			if(rs.next()) {
//
//				return rs.getDouble("currency_amount");
//			} else {
//				log.warn("failed to find user with provided credentials from the db");
//				return 0;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}

	@Override
	public void updateUser(BankUser u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(BankUser u) {
		// TODO Auto-generated method stub
		
	}

}
