package AssignmentWeek7;

import java.util.Scanner;

public class BankAccountDetails {

	int accNumber;
	int accPin;
	double accBalance;

	public BankAccountDetails(int accountNumber, int accountPin, double accountBalance) {
		accNumber = accountNumber;
		accPin = accountPin;
		accBalance = accountBalance;
	}

	Scanner sc = new Scanner(System.in);

	boolean isUserCredentialsCorrect = false;

	boolean checkAccountCredentials(int accountNumber, int accountPin) {
		if (accountNumber == accNumber && accountPin == accPin) {
			isUserCredentialsCorrect = true;
		}
		return isUserCredentialsCorrect;
	}

	void checkBalance() {
		System.out.println("\nAccount Balance = " + accBalance);
	}

	void depositMoney(double depositAmount) {
		if (depositAmount > 0.0) {
			accBalance = accBalance + depositAmount;
			System.out.println("\nBalance after the deposit of $" + depositAmount + " = $" + accBalance);
		} else {
			System.out.println("You cannot deposit negative amount. Start again.");
		}
	}

	void withdrawMoney(double withdrawAmount) {
		accBalance = accBalance - withdrawAmount;
		System.out.println("\nBalance after the withdraw of $" + withdrawAmount + " = $" + accBalance);
	}

	void checkIsBalanceInSufficient(boolean isBalanceInSufficient) {
		int numberOfWithdrawAttempts = 0;
		double withdrawAmount;
		while (isBalanceInSufficient) {
			numberOfWithdrawAttempts++;
			if (numberOfWithdrawAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("You cannot withdraw money. Your balance is lesser than withdraw amount.");
			System.out.println("Enter amount lesser or equal to the balance");
			withdrawAmount = sc.nextDouble();
			if (accBalance >= withdrawAmount) {
				withdrawMoney(withdrawAmount);
				isBalanceInSufficient = false;
				break;
			} else {
				isBalanceInSufficient = true;
			}
		}
	}
}
