import java.util.Date;

public class AccountTest {
	public static void main(String[] args) {
		// new account
		Account account = new Account(1122, 20000);
		
		// setting initial annual interest rate to 4.5
		account.setAnnualInterestRate(4.5);
		
		// withdraw and deposit money
		account.withdraw(2500);
		account.deposit(3000);
		
		// printing out balance, monthly interest, date created
		System.out.println("Balance: " + account.getBalance());
		System.out.println("Monthly interest: " + account.getMonthlyInterest());
		System.out.println("Date Created: " + account.getDateCreated());
	}
}

class Account {
	private int id;
	private double balance, annualInterestRate;
	private Date dateCreated;
	
	// constructs an account with default values
	Account() {
		this(0, 0);
	}
	
	// constructs account with an id and starting balance
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	// sets balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// sets id
	public void setId(int id) {
		this.id = id;
	}
	
	// sets annual interest rate
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	// gets current balance
	public double getBalance() {
		return balance;
	}
	
	// gets id
	public int getId() {
		return id;
	}
	
	// get annual interest rate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	// get date create
	public Date getDateCreated() {
		return dateCreated;
	}
	
	// get monthly interest rate
	public double getMonthlyInterestRate() {
		return annualInterestRate / 100 / 12;
	}
	
	// get monthly interest
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	// withdraws money from balance
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	// deposits money into account
	public void deposit(double amount) {
		balance += amount;
	}
}