package AssignmentWeek8;

import java.util.Scanner;

public class CruiseMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CruisePriceDetails scenicCruise = new CruisePriceDetails("Scenic Cruise", 43.99, 12.99, 3);
		CruisePriceDetails sunsetCruise = new CruisePriceDetails("Sunset Cruise", 52.99, 15.99, 1);
		CruisePriceDetails discoveryCruise = new CruisePriceDetails("Discovery Cruise", 39.99, 9.99, 4);
		CruisePriceDetails mysteryCruise = new CruisePriceDetails("Mystery Cruise", 45.99, 12.99, 2);

		CruisePriceDetails[] cruiseDetails = { scenicCruise, sunsetCruise, discoveryCruise, mysteryCruise };

		int i = 0;
		String cruiseNameSelected = " ";
		int numberOfCruiseAttempts = 0;
		String doYouWantToContinue = " ";
		String doYouWantToPreBookMeal = " ";
		int numberOfMealAttempts = 0;
		int numberOfChildrenAbove5 = 0;
		int age = 0;

		CruiseUserDetails user1 = new CruiseUserDetails();

		String email;
		String password = "";
		String fullName = "";
		String phoneNumber = "";
		String loginUserName = "";
		String loginPassword = "";
		boolean isLoginSuccessful = false;
		String doYouWantToChangePersonalInfo = "";
		int infoYouWantToChange = 0;
		boolean isPasswordMatching = false;
		int numberOfLoginAttempts = 0;
		System.out.println("Welcome to Cruise Booking \nPlease SIGN UP to book a cruise\n");

		System.out.println("Enter your email address.");
		email = sc.nextLine();
		while (email.equals("")) {
			System.out.println("email field cannot be empty.Please enter your email.");
			email = sc.nextLine();
		}
		System.out.println("Enter the password that you want to use.");
		password = sc.nextLine();
		boolean isPasswordValid = user1.checkIsPasswordValid(password);
		while (!isPasswordValid) {
			System.out.println("A minimum 8 characters password with a combination of uppercase and lowercase"
					+ " letter and one special character with number are required.");
			password = sc.nextLine();
			isPasswordValid = user1.checkIsPasswordValid(password);
		}
		System.out.println("Enter you Full Name");
		fullName = sc.nextLine();
		while (fullName.equals("")) {
			System.out.println("FullName field cannot be empty.Please enter your Full Name.");
			fullName = sc.nextLine();
		}
		System.out.println("Enter your phone number");
		phoneNumber = sc.nextLine();
		while (phoneNumber.equals("")) {
			System.out.println("Phone Number field cannot be empty.Please enter your phone number.");
			phoneNumber = sc.nextLine();
		}

		user1.userSignUp(email, password, fullName, phoneNumber);

		System.out.println("Thank you for registering!\n");
		System.out.println("Now you can LOGIN to select your cruise\n");
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

		isLoginSuccessful = user1.userLogin(loginUserName, loginPassword);
		while (!isLoginSuccessful) {
			numberOfLoginAttempts++;
			if (numberOfLoginAttempts > 1) {
				System.out.println("Attempts exceeded!Start again");
				break;
			}
			System.out.println("LOGIN failed! Enter correct credentials");
			System.out.println("Enter username");
			loginUserName = sc.nextLine();
			System.out.println("Enter password");
			loginPassword = sc.nextLine();
			isLoginSuccessful = user1.userLogin(loginUserName, loginPassword);
		}
		if (isLoginSuccessful) {
			do {
				System.out.println("We offer 4 different packages as displayed below.");
				for (i = 0; i < cruiseDetails.length; i++) {
					System.out.println(cruiseDetails[i].cruiseName);
				}
				System.out.println("Please enter the cruise that you want to select.");
				cruiseNameSelected = sc.nextLine();

				while (!(cruiseNameSelected.equalsIgnoreCase("Scenic Cruise")
						|| cruiseNameSelected.equalsIgnoreCase("Sunset Cruise")
						|| cruiseNameSelected.equalsIgnoreCase("Discovery Cruise")
						|| cruiseNameSelected.equalsIgnoreCase("Mystery Cruise"))) {// loop to handle invalid inputs
					numberOfCruiseAttempts++;
					if (numberOfCruiseAttempts > 2) {
						System.out.println("Attempts exceeded! Start again");
						System.exit(0);
					}
					System.out.println("You have entered INVALID cruise name. Please choose from valid names");
					cruiseNameSelected = sc.nextLine();
				}

				for (i = 0; i < cruiseDetails.length; i++) {
					if (cruiseNameSelected.equalsIgnoreCase(cruiseDetails[i].cruiseName)) {
						cruiseDetails[i].getDaysAndCruisePrice(cruiseNameSelected);
						break;
					}
				}
				System.out.println(
						"\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
				doYouWantToContinue = sc.nextLine();
			} while (!doYouWantToContinue.equalsIgnoreCase("Y"));

			System.out.println("Enter the number of adults");
			int numberOfAdults = sc.nextInt();
			if (numberOfAdults == 0) {
				numberOfAdults = cruiseDetails[i].numberOfAdultCheck(numberOfAdults);
			}

			System.out.println("Enter the number of children");
			int numberOfChildren = sc.nextInt();
			numberOfChildrenAbove5 = cruiseDetails[i].ageCheck(numberOfChildren, age);

			System.out.println("\nAll our cruises have food service on board.");
			System.out.println(
					"Do you want to pre-book for dinner buffet meals at 20.99 per day for adults and 4.99 per day for kids above 5?(Y/N)");

			doYouWantToPreBookMeal = sc.next();
			while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Y"))
					|| (doYouWantToPreBookMeal.equalsIgnoreCase("N")))) {
				numberOfMealAttempts++;
				if (numberOfMealAttempts > 2) {
					System.out.println("Attempts exceeded! Start again");
					System.exit(0);
				}
				System.out.println("INVALID INPUT! Enter Y or N");
				doYouWantToPreBookMeal = sc.next();
			}
			for (i = 0; i < cruiseDetails.length; i++) {
				if (cruiseNameSelected.equalsIgnoreCase(cruiseDetails[i].cruiseName)) {
					cruiseDetails[i].calculateCruisePriceForAdults(numberOfAdults);
					cruiseDetails[i].calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
					cruiseDetails[i].calculateBuffetPriceForAdults(numberOfAdults);
					cruiseDetails[i].calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
					cruiseDetails[i].calculateTotalPrice(doYouWantToPreBookMeal);
					cruiseDetails[i].calcualteHST();
					cruiseDetails[i].calculateFinalPrice();
					cruiseDetails[i].displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5,
							doYouWantToPreBookMeal);
					break;
				}
			}

			System.out.println(
					"\nDo you want to change your personal information. Press Y to change. Press any other alphabet to exit.");
			doYouWantToChangePersonalInfo = sc.next();
			do {
				int numberOfPasswordAttempts = 0;
				if (doYouWantToChangePersonalInfo.equalsIgnoreCase("Y")) {
					System.out.println("Please enter the information you want to change.\n" + "1.	Password\n"
							+ "2.	Phone number\n" + "3.	Email\n" + "");
					infoYouWantToChange = sc.nextInt();
					System.out.println("Enter your existing password ");
					String existingPassword = sc.next();
					isPasswordMatching = user1.checkIsPasswordMatching(existingPassword);
					while (!isPasswordMatching) {
						numberOfPasswordAttempts++;
						if (numberOfPasswordAttempts > 2) {
							System.out.println("Attempts exceeded!");
							break;
						}
						System.out.println("Password doesn't match! Enter correct password");
						existingPassword = sc.next();
						isPasswordMatching = user1.checkIsPasswordMatching(existingPassword);
					}
					switch (infoYouWantToChange) {
					case 1:
						if (isPasswordMatching) {
							System.out.println("Enter your new password");
							String newPassword = sc.next();
							user1.setPassword(newPassword);
						}
						break;
					case 2:
						if (isPasswordMatching) {
							System.out.println("Enter your new Phone number");
							String newPhoneNumber = sc.next();
							user1.setPhoneNumber(newPhoneNumber);
						}
						break;
					case 3:
						if (isPasswordMatching) {
							System.out.println("Enter your new email");
							String newEmail = sc.next();
							user1.setUserName(newEmail);
						}
						break;
					default:
						System.out.println("Invalid Input!");
						break;
					}
				} else {
					System.exit(0);
				}
				System.out.println(
						"\nDo you want to change your personal information. Press Y to change. Press any other alphabet to exit.");
				doYouWantToChangePersonalInfo = sc.next();
			} while (doYouWantToChangePersonalInfo.equalsIgnoreCase("Y"));
			System.out.println("\nThank you for using the service!");
		}
	}
}
