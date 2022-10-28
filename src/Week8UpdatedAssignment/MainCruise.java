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
		String doYouWantToPreBookMeal = " ";
		String doYouWantToChangePersonalInfo = "";
		int numberOfMealAttempts = 0;
		int numberOfChildrenAbove5 = 0;
		int age = 0;

		user1.userSignUp();
		user1.userLogin();

		boolean isLoginSuccessful = user1.checkIsLoginSuccessful();

		while (!isLoginSuccessful) {
			isLoginSuccessful = user1.checkNumberOfLoginAttempts();
		}
		if (isLoginSuccessful) {
			do {
				cruiseDetails[i].displayTypesOfCruise(cruiseDetails);
				System.out.println("\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
				doYouWantToContinue = sc.nextLine();
			} while (!doYouWantToContinue.equalsIgnoreCase("Y"));
		}

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
		while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Y")) || (doYouWantToPreBookMeal.equalsIgnoreCase("N")))) {
			numberOfMealAttempts++;
			if (numberOfMealAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookMeal = sc.next();
		}

		for (i = 0; i < cruiseDetails.length; i++) {
			cruiseDetails[i].displayCruiseFinalPriceByAddingAllPrices(cruiseDetails, numberOfAdults,
					numberOfChildrenAbove5, doYouWantToPreBookMeal);
		}

		System.out.println(
				"\nDo you want to change your personal information. Press Y to change. Press any other alphabet to exit.");
		doYouWantToChangePersonalInfo = sc.next();
		do {
			if (doYouWantToChangePersonalInfo.equalsIgnoreCase("Y")) {
				user1.updatePersonalInformation();
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
