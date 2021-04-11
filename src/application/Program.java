package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = scan.nextInt();
		System.out.print("Holder: ");
		scan.nextLine();
		String holder = scan.nextLine();
		System.out.print("Initial balance: ");
		Double balance = scan.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = scan.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = scan.nextDouble();
		try {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n", account.getBalance());

		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		scan.close();
	}

}
