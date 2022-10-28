package Week8UpdatedAssignment;

import java.util.Scanner;
import java.util.regex.*;

public class CruiseUser {
	private String userName;
	private String password;
	public String fullName;
	private String phoneNumber;
	Scanner sc = new Scanner(System.in);
	String loginUserName;
	String loginPassword;

	void userSignUp() {
		System.out.println("Welcome to Cruise Booking \nPlease SIGN UP to book a cruise\n");

		System.out.println("Enter your email address.");
		userName = sc.nextLine();
		while (!checkIsEmailValid(userName)) {
			System.out.println("Valid email required.Enter again");
			userName = sc.nextLine();
		}

		System.out.println("Enter the password that you want to use.");
		password = sc.nextLine();
		while (!checkIsPasswordValid(password)) {
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
		while (!checkIsPhoneNumberValid(phoneNumber)) {
			System.out.println("A phone number should be of 10 digits.Enter again ");
			phoneNumber = sc.nextLine();
		}
		System.out.println("Thank you for registering!\n");
		System.out.println("Now you can LOGIN to select your cruise\n");
	}

	void userLogin() {
		System.out.println("Enter username");
		loginUserName = sc.nextLine();
		while (loginUserName.equals("")) {
			System.out.println("You cannot login without username.Enter username");
			loginUserName = sc.nextLine();
		}
		System.out.println("Enter password");
		loginPassword = sc.nextLine();
		while (loginPassword.equals("")) {
			System.out.println("You cannot login without password.Enter password");
			loginPassword = sc.nextLine();
		}
	}

	boolean checkIsLoginSuccessful() {
		if (loginUserName.equals(userName) && loginPassword.equals(password)) {
			System.out.println("LOGIN Successfully\n");
			return true;
		}
		return false;
	}

	int numberOfLoginAttempts = 0;

	boolean checkNumberOfLoginAttempts() {
		numberOfLoginAttempts++;
		if (numberOfLoginAttempts > 2) {
			System.out.println("Attempts exceeded!Start again");
			System.exit(0);
			;
		}
		System.out.println("LOGIN failed! Enter correct credentials");
		userLogin();
		return (checkIsLoginSuccessful());

	}

	public boolean checkIsEmailValid(String emailAddress) {
		String regexPattern = "^(.+)@(.+)$";
		Pattern p = Pattern.compile(regexPattern); // Compile the ReGex
		if (emailAddress.equals(null)) { // If the email is empty, return false
			return false;
		}
		Matcher m = p.matcher(emailAddress); // Pattern class contains matcher() method to find matching between given
												// emailAddress and regular expression.
		return m.matches();// Return if the emailAddress matched the regexPattern
	}

	public boolean checkIsPasswordValid(String password) {
		String regex = "^(?=.*[0-9])" // Regular expression to check valid password.
				+ "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		if (password.equals(null)) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public boolean checkIsPhoneNumberValid(String phoneNumber) {
		Pattern p = Pattern.compile("^\\d{10}$");
		if (phoneNumber.equals(null)) {
			return false;
		}
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

	boolean checkIsPasswordMatching(String existingPassword) {
		if (this.password.equals(existingPassword)) {
			return true;
		}
		return false;
	}

	int infoYouWantToChange = 0;

	void updatePersonalInformation() {

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
				updatePassword();
			}
			break;
		case 2:
			if (checkIsPasswordMatching(existingPassword)) {
				updatePhoneNumber();
			}
			break;
		case 3:
			if (checkIsPasswordMatching(existingPassword)) {
				updateUserName();
			}
			break;
		default:
			System.out.println("Invalid Input!");
			break;
		}
	}

	private void updatePassword() {
		System.out.println("Enter your new password");
		String newPassword = sc.next();
		while (!checkIsPasswordValid(newPassword)) {
			System.out.println(
					"A minimum 8 characters password with a combination of uppercase and lowercase letter and one special character with number are required.");
			newPassword = sc.next();
		}
		this.password = newPassword;
		System.out.println("Your password has been changed!");
	}

	private void updatePhoneNumber() {
		System.out.println("Enter your new Phone number");
		String newPhoneNumber = sc.next();
		while (!checkIsPhoneNumberValid(newPhoneNumber)) {
			System.out.println("A phone number should be of 10 digits.Enter again");
			newPhoneNumber = sc.next();
		}
		this.phoneNumber = newPhoneNumber;
		System.out.println("Your Phone Number has been changed!");
	}

	private void updateUserName() {
		System.out.println("Enter your new email");
		String newEmail = sc.next();
		while (!checkIsEmailValid(newEmail)) {
			System.out.println("Valid email required.Enter again");
			newEmail = sc.next();
		}
		this.userName = newEmail;
		System.out.println("Your email has been changed!");
	}
}
