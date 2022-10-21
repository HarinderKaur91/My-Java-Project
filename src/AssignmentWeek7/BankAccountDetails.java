package AssignmentWeek7;

public class BankAccountDetails {

	int accNumber;
	int accPin;
	double accBalance;

	public BankAccountDetails(int accountNumber, int accountPin, double accountBalance) {
		accNumber = accountNumber;
		accPin = accountPin;
		accBalance = accountBalance;
	}

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
}
