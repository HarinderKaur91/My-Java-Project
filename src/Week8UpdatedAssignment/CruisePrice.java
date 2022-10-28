package Week8UpdatedAssignment;

import java.text.NumberFormat;
import java.util.Scanner;

public class CruisePrice {
	String cruiseName;
	double adultCruisePrice;
	double kidsAbove5CruisePrice;
	int daysOfCruise;

	NumberFormat nf = NumberFormat.getInstance();
	Scanner sc = new Scanner(System.in);

	public CruisePrice(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
	}

	String cruiseNameSelected = "";
	double totalAdultCruisePrice;
	double totalKidsAbove5CruisePrice;
	double totalAdultMealPrice;
	double totalKidsAbove5MealPrice;
	double hst;
	double totalPrice;
	double finalPrice;
	int numberOfChildrenAbove5 = 0;
	int adultAttempts = 0;

	void displayTypesOfCruise(CruisePrice[] cruiseDetails) {
		int numberOfCruiseAttempts = 0;
		System.out.println("We offer 4 different packages as displayed below.");
		for (int i = 0; i < cruiseDetails.length; i++) {
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

		for (int i = 0; i < cruiseDetails.length; i++) {
			if (cruiseNameSelected.equalsIgnoreCase(cruiseDetails[i].cruiseName)) {
				cruiseDetails[i].getDaysAndCruisePrice(cruiseNameSelected);
				break;
			}
		}
	}

	void getDaysAndCruisePrice(String cruiseName) {
		System.out.println(
				"\nThe cruise that you have selected is " + cruiseName + " which is a " + daysOfCruise + " day cruise");
		System.out.println("\nPrice for Adults (greater than 12)		:" + adultCruisePrice + " per day");
		System.out.println("Price for kids above 5				:" + kidsAbove5CruisePrice + " per day");
	}

	double calculateCruisePriceForAdults(int numberOfAdults) {
		totalAdultCruisePrice = numberOfAdults * daysOfCruise * adultCruisePrice;
		return totalAdultCruisePrice;
	}

	double calculateCruisePriceForChildrenAbove5(int numberOfChildrenAbove5) {
		totalKidsAbove5CruisePrice = numberOfChildrenAbove5 * daysOfCruise * kidsAbove5CruisePrice;
		return totalKidsAbove5CruisePrice;
	}

	double calculateBuffetPriceForAdults(int numberOfAdults) {
		totalAdultMealPrice = numberOfAdults * 20.99;
		return totalAdultMealPrice;
	}

	double calculateBuffetPriceForChildrenAbove5(int numberOfChildrenAbove5) {
		totalKidsAbove5MealPrice = numberOfChildrenAbove5 * 4.99;
		return totalKidsAbove5MealPrice;
	}

	int numberOfAdultCheck(int numberOfAdults) {
		while (!(numberOfAdults > 0)) {
			adultAttempts++;
			if (adultAttempts > 2) {
				System.out.println("Attempts exceeded! Start again.");
				System.exit(0);
			}
			System.out.println("Enter atleast 1 adult.");
			numberOfAdults = sc.nextInt();
		}
		return numberOfAdults;
	}

	int ageCheck(int numberOfChildren, int age) {
		for (int i = 0; i < numberOfChildren; i++) {
			if (numberOfChildren > 0) {
				System.out.println("Enter the age of child " + (i + 1));
				age = sc.nextInt();
				int ageAttempts = 0;
				if (age > 5 && age <= 12) {
					numberOfChildrenAbove5++;
				} else if (age > 12) {
					while (!(age < 13)) {
						ageAttempts++;
						if (ageAttempts > 2) {
							System.out.println("Attempts exceeded! Start again.");
							System.exit(0);
						}
						System.out.println("Child age should be less than 13.Enter again");
						age = sc.nextInt();
						if (age > 5 && age <= 12) {
							numberOfChildrenAbove5++;
						}
					}
				}
			}
		}
		return numberOfChildrenAbove5;
	}

	double calculateTotalPrice(String doYouWantToPreBookMeal) {
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice + totalAdultMealPrice
					+ totalKidsAbove5MealPrice;
		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("N")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice;
		}
		return totalPrice;
	}

	double calcualteHST() {
		hst = 0.15 * totalPrice;
		return hst;
	}

	double calculateFinalPrice() {
		finalPrice = totalPrice + hst;
		return finalPrice;
	}

	void displayCruisePackageDetails(int numberOfAdults, int numberOfChildrenAbove5, String doYouWantToPreBookMeal) {
		System.out.println("\nYour Package includes:\n");
		System.out.println(cruiseName + " Adults 		@	" + numberOfAdults + "	:$" + totalAdultCruisePrice);
		System.out.println(
				cruiseName + " Children above 5	@	" + numberOfChildrenAbove5 + "	:$" + totalKidsAbove5CruisePrice);
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {

			System.out.println("Buffet Special Price Adults	@	" + numberOfAdults + "	:$" + totalAdultMealPrice);
			System.out.println("Buffet Special Price Children above 5 @	" + numberOfChildrenAbove5 + "	:$"
					+ totalKidsAbove5MealPrice);
		}
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 15%					:$" + nf.format(hst));
		System.out.println("Final Price					:$" + nf.format(finalPrice));
	}

	void displayCruiseFinalPriceByAddingAllPrices(CruisePrice[] cruiseDetails, int numberOfAdults, int numberOfChildrenAbove5,
			String doYouWantToPreBookMeal) {
		for (int i = 0; i < cruiseDetails.length; i++) {

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
