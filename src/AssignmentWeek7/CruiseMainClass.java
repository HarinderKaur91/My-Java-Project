package AssignmentWeek7;

import java.util.Scanner;

public class CruiseMainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CruiseDetailsClass scenicCruise = new CruiseDetailsClass("Scenic Cruise", 43.99, 12.99, 3);
		CruiseDetailsClass sunsetCruise = new CruiseDetailsClass("Sunset Cruise", 52.99, 15.99, 1);
		CruiseDetailsClass discoveryCruise = new CruiseDetailsClass("Discovery Cruise", 39.99, 9.99, 4);
		CruiseDetailsClass mysteryCruise = new CruiseDetailsClass("Mystery Cruise", 45.99, 12.99, 2);

		CruiseDetailsClass[] cruiseDetails = { scenicCruise, sunsetCruise, discoveryCruise, mysteryCruise };

		int i = 0;
		String cruiseNameSelected = " ";
		int numberOfCruiseAttempts = 0;
		String doYouWantToContinue = " ";
		String doYouWantToPreBookMeal = " ";
		int numberOfMealAttempts = 0;
		int numberOfChildrenAbove5 = 0;
		int age = 0;

		do {
			System.out.println(
					"We offer 4 different packages as displayed below. Please enter the cruise that you want to select.");
			for (i = 0; i < cruiseDetails.length; i++) {
				System.out.println(cruiseDetails[i].cruiseName);
			}
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
			System.out.println("\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
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
		System.out.println("Do you want to pre-book for dinner buffet meals at 20.99 per day for adults and 4.99 per day for kids above 5?(Yes/No)");

		doYouWantToPreBookMeal = sc.next();
		while (!((doYouWantToPreBookMeal.equalsIgnoreCase("Yes")) || (doYouWantToPreBookMeal.equalsIgnoreCase("No")))) {
			numberOfMealAttempts++;
			if (numberOfMealAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter yes or no");
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
	}
}
