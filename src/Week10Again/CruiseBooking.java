package Week10Again;

import java.text.NumberFormat;

public class CruiseBooking extends UserDetails {

	NumberFormat nf1 = NumberFormat.getInstance();

	protected String cruiseName, specialCruiseFeature;
	protected double adultCruisePrice, kidsAbove5CruisePrice, cruiseSpecialCharges;
	protected int daysOfCruise, numberOfChildren;

	public CruiseBooking() {
	}

	private double totalAdultCruisePrice, totalKidsAbove5CruisePrice, totalPrice;
	private int numberOfChildrenAbove5 = 0, numberOfAdults = 0;
	private String doYouWantToPreBookMeal = "";

	protected void validateCruiseName(String cruiseNameSelected) {
		while (!(cruiseNameSelected.equalsIgnoreCase("Scenic") || cruiseNameSelected.equalsIgnoreCase("Sunset")
				|| cruiseNameSelected.equalsIgnoreCase("Discovery")
				|| cruiseNameSelected.equalsIgnoreCase("Mystery"))) {// loop to handle invalid inputs
			maximumAttempts();
			System.out.println("You have entered INVALID cruise name. Please choose from valid names");
			cruiseNameSelected = sc.next();
		}
		if (cruiseNameSelected.equalsIgnoreCase(cruiseName)) {
			getDaysAndCruisePrice(cruiseNameSelected);
		}
	}

	private void getDaysAndCruisePrice(String cruiseName) {
		System.out.println(
				"\nThe cruise that you have selected is " + cruiseName + " which is a " + daysOfCruise + " day cruise");
		System.out.println("\nPrice for Adults (greater than 12)		:" + adultCruisePrice + " per day");
		System.out.println("Price for kids above 5				:" + kidsAbove5CruisePrice + " per day");
	}

	private double calculateTotalPrice(String doYouWantToPreBookMeal, int numberOfAdults, double cruiseSpecialCharges) {
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {
			totalPrice = (numberOfAdults * daysOfCruise * adultCruisePrice)
					+ (numberOfChildrenAbove5 * daysOfCruise * kidsAbove5CruisePrice) + (numberOfAdults * 20.99)
					+ (numberOfChildrenAbove5 * 4.99);
		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("N")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice;
		}
		if (checkIfWantsToBookSpecialCruiseFeature().equalsIgnoreCase("Y"))
			totalPrice = totalPrice + cruiseSpecialCharges;
		return totalPrice;
	}

	private double calculateFinalPrice() {
		return (totalPrice + (0.15 * totalPrice));
	}

	private int numberOfAdultCheck() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults == 0) {
			while (!(numberOfAdults > 0)) {
				validateNumOfAdults(numberOfAdults);
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	private int ageCheck(int numberOfChildren) {
		int age = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (numberOfChildren > 0) {
				System.out.println("Enter the age of child " + (i + 1));
				age = sc.nextInt();
				while (!(age < 13)) {
					maximumAttempts();
					System.out.println("Child age should be less than 13.Enter again");
					age = sc.nextInt();
				}
				if (age > 5 && age <= 12) {
					numberOfChildrenAbove5++;
				}
			}
		}
		return numberOfChildrenAbove5;
	}

	private String checkIfWantsToBookSpecialCruiseFeature() {
		System.out.println("\n" + cruiseName + " provides " + specialCruiseFeature + " for $" + cruiseSpecialCharges
				+ " per person.Do you want to pre book for " + specialCruiseFeature + ". Press(Y/N)");
		return (sc.next());
	}

	void displayCruiseFinalPriceByAddingAllPrices() {
		System.out.println(
				"Do you want to pre-book for DINNER BUFFET MEALS at 20.99 per day for adults and 4.99 per day for kids above 5?(Y/N)");
		doYouWantToPreBookMeal = checkIfMealRequired();
		numberOfAdults = numberOfAdultCheck();
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		numberOfChildrenAbove5 = ageCheck(numberOfChildren);
		calculateTotalPrice(doYouWantToPreBookMeal, numberOfAdults, cruiseSpecialCharges);
		calculateFinalPrice();
		displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5, doYouWantToPreBookMeal,
				cruiseSpecialCharges);
	}

	private void displayCruisePackageDetails(int numberOfAdults, int numberOfChildrenAbove5,
			String doYouWantToPreBookMeal, double cruiseSpecialCharges) {
		System.out.println("\nYour Package includes:\n");
		System.out.println(cruiseName + " Adults 		@ " + numberOfAdults + "	:$"
				+ (numberOfAdults * daysOfCruise * adultCruisePrice));
		System.out.println(cruiseName + " Children above 5	@ " + numberOfChildrenAbove5 + "	:$"
				+ (numberOfChildrenAbove5 * daysOfCruise * kidsAbove5CruisePrice));
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {
			System.out.println("Buffet Special Price Adults	@ " + numberOfAdults + "	:$" + (numberOfAdults * 20.99));
			System.out.println("Buffet Special Price Children above 5 @	" + numberOfChildrenAbove5 + "	:$"
					+ (numberOfChildrenAbove5 * 4.99));
		}
		System.out.println(specialCruiseFeature + "charges  			@ " + numberOfAdults + " :$"
				+ (numberOfAdults * cruiseSpecialCharges));
		System.out.println("Total Price				 	:$" + nf1.format(totalPrice));
		System.out.println("HST	@ 15%					:$" + nf1.format(0.15 * totalPrice));
		System.out.println("Final Price					:$" + nf1.format(totalPrice + (0.15 * totalPrice)));
	}
}
