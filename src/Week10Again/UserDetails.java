package Week10Again;

import java.util.Scanner;
import java.util.regex.*;

public class UserDetails {

	private String email, password, phoneNumber, fullName;
	private int infoYouWantToChange = 0;
	private int count = 0;
	Scanner sc = new Scanner(System.in);
	private String doYouWantToChangePersonalInfo, regex;
	String regexPassword = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

	void userSignUp(String email, String password, String fullName, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}

	boolean userLogin(String loginUserName, String loginPassword) {
		if (loginUserName.equals(email) && loginPassword.equals(password)) {
			System.out.println("LOGIN Successfully\n");
			return true;
		} else {
			System.out.println("LOGIN failed!");
			maximumAttempts();
			return false;
		}
	}

	boolean validateInput(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		if (input.equals(null)) {
			return false;
		}
		Matcher m = p.matcher(input);
		return m.matches();
	}

	void maximumAttempts() {
		count++;
		if (count > 2) {
			System.out.println("Attempts exceeded! Start again");
			System.exit(0);
		}
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
		System.out.println("Please enter the information you want to change.\n" + "1.	Password\n"
				+ "2.	Phone number\n" + "3.	Email\n" + "");
		infoYouWantToChange = sc.nextInt();
		System.out.println("Enter your existing password ");
		String existingPassword = sc.next();
		while (!checkIsPasswordMatching(existingPassword)) {
			maximumAttempts();
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
			email = newInput;
		}
		System.out.println("Your " + inputToBeUpdated + " has been changed!");
	}

	protected void validateNumOfAdults(int numberOfAdults) {
		maximumAttempts();
		if (numberOfAdults == 0) {
			System.out.println("Enter atleast 1 adult.");
		}
		System.out.println("Enter valid number of adults.");
	}

	protected String checkIfMealRequired() {
		String doYouWantToPreBookMeal = sc.next();
		while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Y")) || (doYouWantToPreBookMeal.equalsIgnoreCase("N")))) {
			maximumAttempts();
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookMeal = sc.next();
		}
		return doYouWantToPreBookMeal;
	}
}
