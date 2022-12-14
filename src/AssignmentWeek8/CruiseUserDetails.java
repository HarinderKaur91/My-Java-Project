package AssignmentWeek8;

import java.util.regex.*;

public class CruiseUserDetails {

	private String userName;
	private String password;
	public String fullName;
	private String phoneNumber;

	void userSignUp(String userName, String password, String fullName, String phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}

	boolean userLogin(String loginUserName, String loginPassword) {
		if (loginUserName.equals(userName) && loginPassword.equals(password)) {
			System.out.println("LOGIN Successfully\n");
			return true;
		}
		return false;
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

	public void setUserName(String newEmail) {
		this.userName = newEmail;
		System.out.println("Your email has been changed!");
	}

	public void setPassword(String newPassword) {
		this.password = newPassword;
		System.out.println("Your password has been changed!");
	}

	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
		System.out.println("Your Phone Number has been changed!");
	}

}
