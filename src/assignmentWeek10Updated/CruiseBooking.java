package assignmentWeek10Updated;

import java.text.NumberFormat;

public abstract class CruiseBooking extends UserDetails {

	String cruiseName, specialCruiseFeature;
	private double adultCruisePrice, kidsAbove5CruisePrice;
	int daysOfCruise;
	NumberFormat nf = NumberFormat.getInstance();

	public CruiseBooking(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays,
			String specialFeature) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
		specialCruiseFeature = specialFeature;
	}

	private double totalAdultCruisePrice, totalKidsAbove5CruisePrice, totalPrice;
	private int numberOfChildrenAbove5 = 0, numberOfAdults = 0, numberOfCruiseAttempts = 0;
	private String doYouWantToPreBookMeal = "";

	protected abstract double calcualateSpecialCharges(int numberOfAdults);
	protected abstract String checkIfWantsToBookSpecialCruiseFeature();

	protected void displayTypesOfCruise(CruiseBooking[] cruiseBooking) {
		System.out.println("We offer 4 different packages as displayed below.");
		for (int i = 0; i < cruiseBooking.length; i++) {
			System.out.println(cruiseBooking[i].cruiseName);
		}
	}

	protected void validateCruiseName(CruiseBooking[] cruiseBooking, String cruiseNameSelected) {
		while (!(cruiseNameSelected.equalsIgnoreCase("Scenic") || cruiseNameSelected.equalsIgnoreCase("Sunset")
				|| cruiseNameSelected.equalsIgnoreCase("Discovery")
				|| cruiseNameSelected.equalsIgnoreCase("Mystery"))) {// loop to handle invalid inputs
			numberOfCruiseAttempts++;
			if (numberOfCruiseAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("You have entered INVALID cruise name. Please choose from valid names");
			cruiseNameSelected = sc.next();
		}
		for (int i = 0; i < cruiseBooking.length; i++) {
			if (cruiseNameSelected.equalsIgnoreCase(cruiseBooking[i].cruiseName)) {
				cruiseBooking[i].getDaysAndCruisePrice(cruiseNameSelected);
				break;
			}
		}
	}

	protected void getDaysAndCruisePrice(String cruiseName) {
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
		totalPrice = totalPrice + cruiseSpecialCharges;
		return totalPrice;
	}

	private double calculateFinalPrice() {
		return (totalPrice + (0.15 * totalPrice));
	}

	protected int numberOfAdultCheck() {
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

	protected int ageCheck(int numberOfChildren) {
		int age = 0, ageAttempts = 0;
		for (int i = 0; i < numberOfChildren; i++) {
			if (numberOfChildren > 0) {
				System.out.println("Enter the age of child " + (i + 1));
				age = sc.nextInt();
				while (!(age < 13)) {
					ageAttempts++;
					if (ageAttempts > 2) {
						System.out.println("Attempts exceeded! Start again.");
						System.exit(0);
					}
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

	void displayCruiseFinalPriceByAddingAllPrices(CruiseBooking[] cruiseDetails, String cruiseNameSelected,
			double cruiseSpecialCharges, int numberOfAdults, int numberOfChildrenAbove5) {
		System.out.println("Do you want to pre-book for DINNER BUFFET MEALS at 20.99 per day for adults and 4.99 per day for kids above 5?(Y/N)");
		doYouWantToPreBookMeal = checkIfMealRequired();
		for (int i = 0; i < cruiseDetails.length; i++) {
			if (cruiseNameSelected.equalsIgnoreCase(cruiseDetails[i].cruiseName)) {
				cruiseDetails[i].calculateTotalPrice(doYouWantToPreBookMeal, numberOfAdults, cruiseSpecialCharges);
				cruiseDetails[i].calculateFinalPrice();
				cruiseDetails[i].displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5,
						doYouWantToPreBookMeal, cruiseSpecialCharges);
				break;
			}
		}
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
		System.out.println(specialCruiseFeature + "  			@ " + numberOfAdults + " :$" + cruiseSpecialCharges);
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 15%					:$" + nf.format(0.15 * totalPrice));
		System.out.println("Final Price					:$" + nf.format(totalPrice + (0.15 * totalPrice)));
	}
}
