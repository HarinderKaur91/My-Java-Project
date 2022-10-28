package Week8UpdatedAssignment;

import java.util.Scanner;

public class MainCruise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CruisePrice scenicCruise = new CruisePrice("Scenic Cruise", 43.99, 12.99, 3);
		CruisePrice sunsetCruise = new CruisePrice("Sunset Cruise", 52.99, 15.99, 1);
		CruisePrice discoveryCruise = new CruisePrice("Discovery Cruise", 39.99, 9.99, 4);
		CruisePrice mysteryCruise = new CruisePrice("Mystery Cruise", 45.99, 12.99, 2);

		CruisePrice[] cruiseDetails = { scenicCruise, sunsetCruise, discoveryCruise, mysteryCruise };
		CruiseUser user1 = new CruiseUser();

		int i = 0;
		String doYouWantToContinue = " ";

		user1.userSignUp();
		user1.userLogin();

		boolean isLoginSuccessful = user1.checkIsLoginSuccessful();

		while (!isLoginSuccessful) {
			isLoginSuccessful = user1.checkNumberOfLoginAttempts();
		}
		if (isLoginSuccessful) {
			do {
				cruiseDetails[i].displayTypesOfCruise(cruiseDetails);
				System.out.println(
						"\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
				doYouWantToContinue = sc.nextLine();
			} while (!doYouWantToContinue.equalsIgnoreCase("Y"));
		}

		int numberOfAdults = cruiseDetails[i].numberOfAdultCheck();
		int numberOfChildrenAbove5 = cruiseDetails[i].ageCheck();
		String doYouWantToPreBookMeal = cruiseDetails[i].checkIfMealRequired();

		for (i = 0; i < cruiseDetails.length; i++) {
			cruiseDetails[i].displayCruiseFinalPriceByAddingAllPrices(cruiseDetails, numberOfAdults,
					numberOfChildrenAbove5, doYouWantToPreBookMeal);
		}

		user1.checkIfUserWantsToChangePersonalInfo();

		System.out.println("\nThank you for using the service!");
	}
}
