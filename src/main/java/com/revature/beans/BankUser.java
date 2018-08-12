

	package com.revature.beans;

	import java.io.Serializable;
import java.util.HashMap;

	public class BankUser implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2878891003003024330L;
		
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private boolean ifAdmin;
		private double currencyAmount;
		private double income;
		
		private HashMap<Double, Character> history = new HashMap<Double,Character>(); 

		public BankUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BankUser(String username, String password, String firstName, String lastName, double income, HashMap<Double, Character> history, Double currencyAmount) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.income = income;
			this.history = history;
			this.currencyAmount = currencyAmount;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (int) (prime * result + income);
			result = (int)(prime * result + currencyAmount);
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			result = prime * result + ((history == null) ? 0 : history.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BankUser other = (BankUser) obj;
			if (income != other.income)
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}


		public boolean isIfAdmin() {
			return ifAdmin;
		}

		public void setIfAdmin(boolean ifAdmin) {
			this.ifAdmin = ifAdmin;
		}

		public double getCurrencyAmount() {
			return currencyAmount;
		}

		public void setCurrencyAmount(double currencyAmount) {
			this.currencyAmount = currencyAmount;
		}

		public double getIncome() {
			return income;
		}
		
		@Override
		public String toString() {
			return "BankUser [username=" + username + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", ifAdmin=" + ifAdmin + ", currencyAmount=" + currencyAmount
					+ ", income=" + income + ", history=" + history + "]";
		}

		public void setIncome(double income) {
			this.income = income;
		}

		public HashMap<Double, Character> getHistory() {
			return history;
		}

		public void setHistory(HashMap<Double, Character> history) {
			this.history = history;
		}

	}


