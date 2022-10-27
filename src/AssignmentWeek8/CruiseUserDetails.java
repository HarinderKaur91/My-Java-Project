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

	public boolean checkIsPasswordValid(String password) {
		String regex = "^(?=.*[0-9])"			// Regular expression to check valid password.
		+"(?=.*[a-z])(?=.*[A-Z])" 
		+ "(?=.*[@#$%^&+=])"
		+ "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex); // Compile the ReGex
		if (password.equals(null)) { // If the password is empty, return false
			return false;
		}
		Matcher m = p.matcher(password); // Pattern class contains matcher() method to find matching between given
											// password and regular expression.
		return m.matches();// Return if the password matched the ReGex
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
