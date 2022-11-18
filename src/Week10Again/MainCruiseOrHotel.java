package Week10Again;

import java.util.Scanner;

public class MainCruiseOrHotel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userChoice, doYouWantToContinue, doYouWantToChooseAgain;
		String email, password, fullName, phoneNumber, loginUserName, loginPassword;
		boolean isLoginSuccessful = false;
		UserDetails user = new UserDetails();
		System.out.println("\nPlease SIGN UP to book a service\n");
		System.out.println("Enter your email address.");
		email = sc.nextLine();
		while (!(user.validateInput(email, "^(.+)@(.+)$"))) {
			System.out.println("Valid email required.Enter again");
			email = sc.nextLine();
		}
		System.out.println("Enter the password that you want to use.");
		password = sc.nextLine();
		while (!(user.validateInput(password, user.regexPassword))) {
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
		while (!(user.validateInput(phoneNumber, "^\\d{10}$"))) {
			System.out.println("A phone number should be of 10 digits.Enter again ");
			phoneNumber = sc.nextLine();
		}
		user.userSignUp(email, password, fullName, phoneNumber);
		System.out.println("Thank you for registering!\n");
		System.out.println("Now you can LOGIN to select your cruise\n");
		do {
			System.out.println("Enter username");
			loginUserName = sc.nextLine();
			System.out.println("Enter password");
			loginPassword = sc.nextLine();
			isLoginSuccessful = user.userLogin(loginUserName, loginPassword);
		} while (!isLoginSuccessful);
		CruiseBooking cruiseBooking = null;
		HotelBooking hotelBooking = null;
		do {
			System.out.println("Please enter the service you want to book Hotel / Cruise");
			userChoice = sc.next();
			while (!(userChoice.equalsIgnoreCase("Hotel") || userChoice.equalsIgnoreCase("Cruise"))) {
				user.maximumAttempts();
				System.out.println("You have entered INVALID service name. Please choose Hotel or Cruise");
				userChoice = sc.next();
			}
			if (userChoice.equalsIgnoreCase("Hotel")) {
				System.out.println("\nPlease enter the room you want to select");
				System.out.println("\nDeluxe: accommodates 2 adults and 2 children at the rate of $180/ night");
				System.out.println("Family: accommodates 4 adults and 4 children at $230/ night.");
				String roomSelected = sc.next();
				System.out.println("Enter the number of days of stay");
				int numOfStayDays = sc.nextInt();
				switch (roomSelected) {
				case "Deluxe":
					hotelBooking = new DeluxeSuite("Deluxe", 180, 2, 2);
					break;
				case "Family":
					hotelBooking = new FamilySuite("Family", 230, 4, 4);
					break;
				}
				hotelBooking.displayHotelFinalPriceByAddingAllPrices(numOfStayDays);
			} else if (userChoice.equalsIgnoreCase("Cruise")) {
				do {
					System.out.println("We offer 4 different packages as displayed below.");
					System.out.println("Scenic \nSunset \nDiscovery \nMystery");
					System.out.println("Enter the cruise you want to select.");
					String cruiseNameSelected = sc.next();
					
					switch (cruiseNameSelected) {
					case "Scenic":
						cruiseBooking = new ScenicDetails("Scenic", 43.99, 12.99, 3, "SPA", 50);
						break;
					case "Sunset":
						cruiseBooking = new SunsetDetails("Sunset", 52.99, 15.99, 1, "CANDLE LIGHT DINNER", 45);
						break;
					case "Discovery":
						cruiseBooking = new DiscoveryDetails("Discovery", 39.99, 9.99, 4, "ADVENTURE GAMES", 50);
						break;
					case "Mystery":
						cruiseBooking = new MysteryDetails("Mystery", 45.99, 12.99, 2, "CASINO", 20);
						break;
					}
					cruiseBooking.validateCruiseName(cruiseNameSelected);
					System.out.println("\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
					doYouWantToContinue = sc.next();
				} while (!doYouWantToContinue.equalsIgnoreCase("Y"));
				cruiseBooking.displayCruiseFinalPriceByAddingAllPrices();
				user.checkIfUserWantsToChangePersonalInfo();
				System.out.println("\nThank you for using the service!");
			}
			System.out.println("\nDo you want to book another Hotel Room or Cruise.(Y/N)");
			doYouWantToChooseAgain = sc.next();
			if (!doYouWantToChooseAgain.equalsIgnoreCase("Y")) {
				System.out.println("Thank you for booking the service!");
			}
		} while (doYouWantToChooseAgain.equalsIgnoreCase("Y"));
		sc.close();
	}
}
