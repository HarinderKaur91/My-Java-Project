package AssignmentWeek7;

import java.util.Scanner;

public class MainClassBankAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankAccountDetails user1 = new BankAccountDetails(1111, 1616, 100.00);
		BankAccountDetails user2 = new BankAccountDetails(2222, 2626, 200.00);
		BankAccountDetails user3 = new BankAccountDetails(3333, 3636, 300.00);
		BankAccountDetails user4 = new BankAccountDetails(4444, 4646, 400.00);
		BankAccountDetails user5 = new BankAccountDetails(5555, 5656, 500.00);

		BankAccountDetails[] bankAccountDetails = { user1, user2, user3, user4, user5 };

		int i;
		int accountNumber = 0;
		int accountPin = 0;
		boolean isUserCredentialsCorrect = false;
		int choiceOfDepositOrWithdraw = 0;
		double depositAmount = 0.0;
		double withdrawAmount = 0.0;
		int numberOfLoginAttempts = 0;
		int numberOfChoiceAttempts = 0;
		boolean isBalanceInSufficient = false;

		System.out.println("Enter the account number");
		accountNumber = sc.nextInt();
		System.out.println("Enter the pin");
		accountPin = sc.nextInt();

		for (i = 0; i < bankAccountDetails.length; i++) {
			isUserCredentialsCorrect = bankAccountDetails[i].checkAccountCredentials(accountNumber, accountPin);
			if (isUserCredentialsCorrect) {
				bankAccountDetails[i].checkBalance();
				break;
			}
		}
		
		while (!isUserCredentialsCorrect) {
			numberOfLoginAttempts++;
			if (numberOfLoginAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID username or pin.Enter valid credentials");
			System.out.println("\nEnter the account number");
			accountNumber = sc.nextInt();
			System.out.println("Enter the pin");
			accountPin = sc.nextInt();
			for (i = 0; i < bankAccountDetails.length; i++) {
				isUserCredentialsCorrect = bankAccountDetails[i].checkAccountCredentials(accountNumber, accountPin);
				if (isUserCredentialsCorrect) {
					bankAccountDetails[i].checkBalance();
					break;
				} else {
					isUserCredentialsCorrect = false;
				}
			}
		}

		System.out.println("\nPress1 : Deposit Money");
		System.out.println("Press2 : Withdraw Money");
		choiceOfDepositOrWithdraw = sc.nextInt();

		while (!(choiceOfDepositOrWithdraw == 1 || choiceOfDepositOrWithdraw == 2)) {
			numberOfChoiceAttempts++;
			if (numberOfChoiceAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter 1 or 2");
			choiceOfDepositOrWithdraw = sc.nextInt();
		}

		if (choiceOfDepositOrWithdraw == 1) {
			System.out.println("Enter amount to be deposited");
			depositAmount = sc.nextDouble();
			for (i = 0; i < bankAccountDetails.length; i++) {
				if ((accountNumber == bankAccountDetails[i].accNumber)
						&& (accountPin == bankAccountDetails[i].accPin)) {
					bankAccountDetails[i].depositMoney(depositAmount);
					break;
				}
			}
		} else if (choiceOfDepositOrWithdraw == 2) {
			System.out.println("Enter amount to be withdrawn");
			withdrawAmount = sc.nextDouble();
			for (i = 0; i < bankAccountDetails.length; i++) {
				if ((accountNumber == bankAccountDetails[i].accNumber)
						&& (accountPin == bankAccountDetails[i].accPin)) {
					if (bankAccountDetails[i].accBalance >= withdrawAmount) {
						bankAccountDetails[i].withdrawMoney(withdrawAmount);
						break;
					} else {
						isBalanceInSufficient = true;
						bankAccountDetails[i].checkIsBalanceInSufficient(isBalanceInSufficient);
					}
				}
			}
		}
	}
}