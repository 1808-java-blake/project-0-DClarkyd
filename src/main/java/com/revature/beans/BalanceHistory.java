package com.revature.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.Date;

public class BalanceHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6246566863364007260L;

	private static ArrayList<Double> balanceHistory = new ArrayList<Double>();
	private String username;
	private Double balanceChange;
//	java.util.Date dt = new java.util.Date();
//
//	java.text.SimpleDateFormat sdf = 
//	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//	String currentTime = sdf.format(dt);
//	private Timestamp timestamp = new Timestamp(Date.getTime());
	private Double currentBalance;
//	public BalanceHistory() {
//		super();
//	}
	
	public  BalanceHistory(String username,  Double balanceChange, Double currentBalance){

//		balanceHistory.add((double) 0);//
		this.username = username;
		this.balanceChange = balanceChange;
//		this.currentTime = new java.util.Date();
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "BalanceHistory [balanceHistory=" + balanceHistory + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BalanceHistory other = (BalanceHistory) obj;
		if (balanceHistory == null) {
			if (other.balanceHistory != null)
				return false;
		} else if (!balanceHistory.equals(other.balanceHistory))
			return false;
		return true;
	}

//	public ArrayList<Double> getBalanceHistory() {
//		return balanceHistory;
//	}

//	public void setBalanceHistory(double oldBalance, double newBalance) {
////		if(balanceHistory == null) {
////			ArrayList<Double> balanceHistory = new ArrayList<>();
////			balanceHistory.add(newBalance);
////			return;
////		}
//		balanceHistory.add(newBalance);
//	}

	public BalanceHistory() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balanceHistory == null) ? 0 : balanceHistory.hashCode());
		return result;
	}

	public void printBalanceHistory() {
		// TODO Auto-generated method stub

	}

	public void createHistory(BalanceHistory h) {
		// TODO Auto-generated method stub
		
	}
	
	public void setOldBalance(Double newBalance) {
		return;
	}
	
	public double getNewBalance() {
		return this.currentBalance;
	}
	
	public double getOldBalance() {
		if(balanceHistory.size() > 0) {
		return(balanceHistory.get(balanceHistory.size()-1));
		}
		return(balanceHistory.get(0));
	}

	public void setUsername(String d) {
		username = d;
	}
	
	public String getUsername() {
		return username;
	}

	public double getCurrentBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Double getBalanceChange() {
		return balanceChange;
	}

	public void setBalanceChange(Double balanceChange) {
		this.balanceChange = balanceChange;
	}

//	public TimeZone getChangeTime() {
//		return currentTime;
//	}
//
//	public void setCurrentTime(TimeZone currentTime) {
//		this.currentTime = currentTime;
//	}

	public void setCurrencyAmount(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
}
