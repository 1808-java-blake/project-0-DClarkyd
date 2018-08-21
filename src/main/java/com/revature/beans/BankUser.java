

	package com.revature.beans;

	import java.util.ArrayList;

	public class BankUser  {

		/**
		 * 
		 */
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private double currencyAmount;
		private double income;
//		private boolean ifAdmin;

		public BankUser() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BankUser(String username, String password, String firstName, String lastName, double currencyAmount, double income) {
//			this.history = new HashMap();
			super()	;
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.income = income;
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
			long temp;
			temp = Double.doubleToLongBits(currencyAmount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			temp = Double.doubleToLongBits(income);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
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
			if (Double.doubleToLongBits(currencyAmount) != Double.doubleToLongBits(other.currencyAmount))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (Double.doubleToLongBits(income) != Double.doubleToLongBits(other.income))
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


//		public boolean isIfAdmin() {
//			return ifAdmin;
//		}
//
//		public void setIfAdmin(boolean ifAdmin) {
//			this.ifAdmin = ifAdmin;
//		}

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
					+ ", lastName=" + lastName + ", currencyAmount=" + currencyAmount
					+ ", income=" + income + ", history=" +  "]";
		}

		public void setIncome(double income) {
			this.income = income;
		}



		public double getUserId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setUserId(int id) {
			// TODO Auto-generated method stub
			
		}
	}


