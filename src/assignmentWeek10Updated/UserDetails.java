package assignmentWeek10Updated;

import java.util.Scanner;
import java.util.regex.*;

public class UserDetails {

	private String userName, password, phoneNumber;
	public String fullName;
	private int infoYouWantToChange = 0;

	Scanner sc = new Scanner(System.in);

	String doYouWantToChangePersonalInfo;
	String regex;
	String regexPassword = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

	void userSignUp() {
		System.out.println("\nPlease SIGN UP to book a service.\n");
		System.out.println("Enter your email address.");
		userName = sc.nextLine();
		while (!validateInput(userName, "^(.+)@(.+)$")) {
			System.out.println("Valid email required.Enter again");
			userName = sc.nextLine();
		}
		System.out.println("Enter the password that you want to use.");
		password = sc.nextLine();
		while (!validateInput(password, regexPassword)) {
			System.out.println("A minimum 8 characters password with a combination of uppercase and lowercase"
					+ " letter and one special character with number are required.");
			password = sc.nextLine();
		}
		System.out.println("Enter you Full Name");
		fullName = sc.nextLine();
		while (fullName.equals("")) {
			System.out.println("FullName field cannot be empty.Please enter your Full Name.");
			fullName = sc.nextLine();
		}
		System.out.println("Enter your phone number");
		phoneNumber = sc.nextLine();
		while (!validateInput(phoneNumber, "^\\d{10}$")) {
			System.out.println("A phone number should be of 10 digits.Enter again ");
			phoneNumber = sc.nextLine();
		}
		System.out.println("Thank you for registering!\n");
	}

	private boolean validateInput(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		if (input.equals(null)) {
			return false;
		}
		Matcher m = p.matcher(input);
		return m.matches();
	}

	private boolean checkIsPasswordMatching(String existingPassword) {
		if (password.equals(existingPassword)) {
			return true;
		}
		return false;
	}

	void checkIfUserWantsToChangePersonalInfo() {
		do {
			System.out.println(
					"\nDo you want to change your personal information. Press Y to change. Press any other alphabet to exit.");
			doYouWantToChangePersonalInfo = sc.next();

			if (doYouWantToChangePersonalInfo.equalsIgnoreCase("Y")) {
				updatePersonalInformation();
			} else {
				break;
			}
		} while (doYouWantToChangePersonalInfo.equalsIgnoreCase("Y"));
	}

	private void updatePersonalInformation() {
		int numberOfPasswordAttempts = 0;
		System.out.println("Please enter the information you want to change.\n" + "1.	Password\n"
				+ "2.	Phone number\n" + "3.	Email\n" + "");
		infoYouWantToChange = sc.nextInt();
		System.out.println("Enter your existing password ");
		String existingPassword = sc.next();

		while (!checkIsPasswordMatching(existingPassword)) {
			numberOfPasswordAttempts++;
			if (numberOfPasswordAttempts > 2) {
				System.out.println("Attempts exceeded!");
				break;
			}
			System.out.println("Password doesn't match! Enter correct password");
			existingPassword = sc.next();
		}
		switch (infoYouWantToChange) {
		case 1:
			if (checkIsPasswordMatching(existingPassword)) {
				updateInfo("password");
			}
			break;
		case 2:
			if (checkIsPasswordMatching(existingPassword)) {
				updateInfo("phone Number");
			}
			break;
		case 3:
			if (checkIsPasswordMatching(existingPassword)) {
				updateInfo("email");
			}
			break;
		default:
			System.out.println("Invalid Input!");
			break;
		}
	}

	private void updateInfo(String inputToBeUpdated) {
		System.out.println("Enter your new " + inputToBeUpdated);
		String newInput = sc.next();
		if (inputToBeUpdated.equalsIgnoreCase("password")) {
			regex = regexPassword;
		} else if (inputToBeUpdated.equalsIgnoreCase("phone Number")) {
			regex = "^\\d{10}$";
		} else if (inputToBeUpdated.equalsIgnoreCase("email")) {
			regex = "^(.+)@(.+)$";
		}
		while (!validateInput(newInput, regex)) {
			System.out.println("Valid input required.Enter again");
			newInput = sc.next();
		}
		if (inputToBeUpdated.equalsIgnoreCase("password")) {
			password = newInput;
		} else if (inputToBeUpdated.equalsIgnoreCase("phone Number")) {
			phoneNumber = newInput;
		} else if (inputToBeUpdated.equalsIgnoreCase("email")) {
			userName = newInput;
		}
		System.out.println("Your " + inputToBeUpdated + " has been changed!");
	}

	protected void validateNumOfAdults(int numberOfAdults) {
		int adultAttempts = 0;
		adultAttempts++;
		if (adultAttempts > 2) {
			System.out.println("Attempts exceeded! Start again.");
			System.exit(0);
		}
		if (numberOfAdults == 0) {
			System.out.println("Enter atleast 1 adult.");
		}
		System.out.println("Enter valid number of adults.");
	}

	protected String checkIfMealRequired() {
		String doYouWantToPreBookMeal = sc.next();
		while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Y")) || (doYouWantToPreBookMeal.equalsIgnoreCase("N")))) {
			int numberOfMealAttempts = 0;
			numberOfMealAttempts++;
			if (numberOfMealAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookMeal = sc.next();
		}
		return doYouWantToPreBookMeal;
	}
}
