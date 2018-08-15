package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class BalanceHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6246566863364007260L;

	private static ArrayList<Double> balanceHistory = new ArrayList<Double>();
	private String username;

//	public BalanceHistory() {
//		super();
//	}
	
	public  BalanceHistory(String username){

		balanceHistory.add((double) 0);
		this.username = username;
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

	public ArrayList<Double> getBalanceHistory() {
		return balanceHistory;
	}

	public void setBalanceHistory(double oldBalance, double newBalance) {
//		if(balanceHistory == null) {
//			ArrayList<Double> balanceHistory = new ArrayList<>();
//			balanceHistory.add(newBalance);
//			return;
//		}
		balanceHistory.add(newBalance);
	}

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
		for(int i = 0; i < balanceHistory.size(); i++) {
			System.out.println(balanceHistory.get(i));
		}
	}

	public void createHistory(BalanceHistory h) {
		// TODO Auto-generated method stub
		
	}

	public void setUsername(String d) {
		username = d;
	}
	
	public String getUsername() {
		return username;
	}
}
