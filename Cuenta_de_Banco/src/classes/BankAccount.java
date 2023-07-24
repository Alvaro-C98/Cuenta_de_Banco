package classes;

import java.util.Random;

public class BankAccount {
	private String numbac;
	private double current;
	private double savings;
	private static int accounts=0;
	private static double balance=0;
	
	Random ran = new Random();

	public BankAccount(double current, double savings) {
		this.numbac = numb_account();
		this.current = current;
		this.savings = savings;
		accounts++;
		balance+=current+savings;
	}
	
	
	public String numbAccount() {
		return this.numbac;
	}
	
	public static double getTotalBalance() {
		return balance;
	}
	
	public double getCurrent() {
		return this.current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public double getSavings() {
		return this.savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	
	private String numb_account() {
		String num="";
		int ale;
		for(int i=0; i<10; i++) {
			ale=ran.nextInt(10);
			num+=String.valueOf(ale);
		}
		return num;
	}
	
	
	public void deposit(String account, String type, double amount) {
		if(type.equalsIgnoreCase("ahorro")) {
			setSavings(getSavings()+amount);
			System.out.println("\nSe deposito "+amount+"$ en la cuenta de ahorros de "+account+" - Nuevo saldo:");	
		}else if(type.equalsIgnoreCase("corriente")){
			setCurrent(getCurrent()+amount);
			System.out.println("\nSe deposito "+amount+"$ en la cuenta corriente de "+account+" - Nuevo saldo:");
		}
		Balances(account);
		balance+=amount;
	}
	
	public void withdraw(String account, String type, double amount) {
		if(type.equalsIgnoreCase("ahorro")) {
			if(getSavings()>=amount) {
				setSavings(getSavings()-amount);
				System.out.println("\nSe retiro "+amount+"$ en la cuenta de ahorros de "+account+" - Nuevo saldo:");	
				Balances(account);
				balance-=amount;
			}else {
				System.out.println("\nNo es posible retirar "+amount+"$ de la cuenta de ahorros de "+account+" - Saldo actual:");
				Balances(account);
			}
			
		}else if(type.equalsIgnoreCase("corriente")){
			if(getCurrent()>=amount) {
				setCurrent(getCurrent()-amount);
				System.out.println("\nSe retiro "+amount+"$ en la cuenta corriente de "+account+" - Nuevo saldo:");
				Balances(account);
				balance-=amount;
			}else {
				System.out.println("\nNo es posible retirar "+amount+"$ de la cuenta corriente de "+account+" - Saldo actual:");
				Balances(account);
			}
		}
	}
	
	 public void Balances(String account) {
		 System.out.println("Numero de "+account+": "+numbAccount()+" - Saldo corriente: "+getCurrent()+"$ - Saldo ahorro: "+getSavings()+"$");
	 }
	
}
