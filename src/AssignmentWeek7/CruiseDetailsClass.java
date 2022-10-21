package AssignmentWeek7;

import java.text.NumberFormat;
import java.util.Scanner;

public class CruiseDetailsClass {
	String cruiseName;
	double adultCruisePrice;
	double kidsAbove5CruisePrice;
	int daysOfCruise;

	NumberFormat nf = NumberFormat.getInstance();
	Scanner sc = new Scanner(System.in);

	public CruiseDetailsClass(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
	}

	void getDaysAndCruisePrice(String cruiseName) {
		System.out.println(
				"\nThe cruise that you have selected is " + cruiseName + " which is a " + daysOfCruise + " day cruise");
		System.out.println("\nPrice for Adults (greater than 12)		:" + adultCruisePrice + " per day");
		System.out.println("Price for kids above 5				:" + kidsAbove5CruisePrice + " per day");
	}

	double totalAdultCruisePrice;
	double totalKidsAbove5CruisePrice;
	double totalAdultMealPrice;
	double totalKidsAbove5MealPrice;
	double hst;
	double totalPrice;
	double finalPrice;
	int numberOfChildrenAbove5 = 0;
	int adultAttempts = 0;

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
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Yes")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice + totalAdultMealPrice
					+ totalKidsAbove5MealPrice;
		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("No")) {
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
		if (doYouWantToPreBookMeal.equalsIgnoreCase("yes")) {
			System.out.println("\nYour Package includes:\n");
			System.out.println(cruiseName + " Adults 		@	" + numberOfAdults + "	:$" + totalAdultCruisePrice);
			System.out.println(cruiseName + " Children above 5	@	" + numberOfChildrenAbove5 + "	:$"
					+ totalKidsAbove5CruisePrice);
			System.out.println("Buffet Special Price Adults	@	" + numberOfAdults + "	:$" + totalAdultMealPrice);
			System.out.println("Buffet Special Price Children above 5 @	" + numberOfChildrenAbove5 + "	:$"
					+ totalKidsAbove5MealPrice);
			System.out.println("Total Price				 	:$" + nf.format(totalPrice));
			System.out.println("HST	@ 15%					:$" + nf.format(hst));
			System.out.println("Final Price					:$" + nf.format(finalPrice));
		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("no")) {
			System.out.println("\nYour Package includes:\n");
			System.out.println(cruiseName + " Adults 		@	" + numberOfAdults + "	:$" + totalAdultCruisePrice);
			System.out.println(cruiseName + " Children above 5	@	" + numberOfChildrenAbove5 + "	:$"
					+ totalKidsAbove5CruisePrice);
			System.out.println("Total Price				 	:$" + nf.format(totalPrice));
			System.out.println("HST	@ 15%					:$" + nf.format(hst));
			System.out.println("Final Price					:$" + nf.format(finalPrice));
		}
	}
}
