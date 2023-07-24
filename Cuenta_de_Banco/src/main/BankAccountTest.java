package main;

import classes.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount cuenta1 = new BankAccount(200,600);
		BankAccount cuenta2 = new BankAccount(600,900);
		BankAccount cuenta3 = new BankAccount(100,300);
		
		cuenta1.Balances("cuenta1");
		cuenta2.Balances("cuenta2");
		cuenta3.Balances("cuenta3");
		
		System.out.println("\nBalance total de cuentas: "+BankAccount.getTotalBalance());
		
		cuenta2.deposit("cuenta2","corriente",330);
		cuenta1.deposit("cuenta1","ahorro",350);
		
		System.out.println("\nBalance total de cuentas: "+BankAccount.getTotalBalance());
		
		cuenta2.withdraw("cuenta2", "corriente", 500);
		cuenta3.withdraw("cuenta3", "corriente", 300);
		
		System.out.println("\nBalance total de cuentas: "+BankAccount.getTotalBalance());
		
	}

}
