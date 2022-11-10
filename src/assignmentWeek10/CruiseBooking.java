package assignmentWeek10;

import java.text.NumberFormat;
import java.util.Scanner;

public class CruiseBooking extends UserDetails {

	String cruiseName;
	double adultCruisePrice;
	double kidsAbove5CruisePrice;
	int daysOfCruise;

	NumberFormat nf = NumberFormat.getInstance();
	Scanner sc = new Scanner(System.in);

	public CruiseBooking(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays) {
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
	int numberOfChildren = 0;
	int numberOfChildrenAbove5 = 0;

	int numberOfAdults = 0;
	int adultAttempts = 0;
	String doYouWantToPreBookMeal = "";
	int numberOfMealAttempts = 0;

	void displayTypesOfCruise(CruiseBooking[] cruiseBooking) {
		int numberOfCruiseAttempts = 0;
		System.out.println("We offer 4 different packages as displayed below.");
		for (int i = 0; i < cruiseBooking.length; i++) {
			System.out.println(cruiseBooking[i].cruiseName);
		}
		System.out.println("Please enter the cruise that you want to select.");
		cruiseNameSelected = sc.next();
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

	private void getDaysAndCruisePrice(String cruiseName) {
		System.out.println(
				"\nThe cruise that you have selected is " + cruiseName + " which is a " + daysOfCruise + " day cruise");
		System.out.println("\nPrice for Adults (greater than 12)		:" + adultCruisePrice + " per day");
		System.out.println("Price for kids above 5				:" + kidsAbove5CruisePrice + " per day");
	}

	private String checkIfMealRequired() {
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
		return doYouWantToPreBookMeal;
	}

	private double calculateCruisePriceForAdults(int numberOfAdults) {
		totalAdultCruisePrice = numberOfAdults * daysOfCruise * adultCruisePrice;
		return totalAdultCruisePrice;
	}

	private double calculateCruisePriceForChildrenAbove5(int numberOfChildrenAbove5) {
		totalKidsAbove5CruisePrice = numberOfChildrenAbove5 * daysOfCruise * kidsAbove5CruisePrice;
		return totalKidsAbove5CruisePrice;
	}

	private double calculateBuffetPriceForAdults(int numberOfAdults) {
		totalAdultMealPrice = numberOfAdults * 20.99;
		return totalAdultMealPrice;
	}

	private double calculateBuffetPriceForChildrenAbove5(int numberOfChildrenAbove5) {
		totalKidsAbove5MealPrice = numberOfChildrenAbove5 * 4.99;
		return totalKidsAbove5MealPrice;
	}

	int numberOfAdultCheck() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 ||numberOfAdults == 0) {
			while (!(numberOfAdults > 0)) {
				adultAttempts++;
				if (adultAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				System.out.println("Enter atleast 1 adult.");
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	int ageCheck() {
		numberOfChildrenAbove5 = 0;
		int age = 0;
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
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

	private double calculateTotalPrice(String cruiseNameSelected, String doYouWantToPreBookMeal, String doYouWantToPreBookSpa,
			double spaCharges, String doYouWantCandleLightDinner, double candleLightDinnerCharges,
			String doYouWantToPreBookGames, double adventureGamesFee, String doYouWantToPreBookCasino,
			double casinoFee) {
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice + totalAdultMealPrice
					+ totalKidsAbove5MealPrice;
		} else if (doYouWantToPreBookMeal.equalsIgnoreCase("N")) {
			totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice;
		}
		switch (cruiseNameSelected) {
		case "Scenic":
			if (doYouWantToPreBookSpa.equalsIgnoreCase("Y")) {
				totalPrice = totalPrice + spaCharges;
			}
			break;
		case "Sunset":
			if (doYouWantCandleLightDinner.equalsIgnoreCase("Y")) {
				totalPrice = totalPrice + candleLightDinnerCharges;
			}
			break;
		case "Discovery":
			if (doYouWantToPreBookGames.equalsIgnoreCase("Y")) {
				totalPrice = totalPrice + adventureGamesFee;
			}
			break;
		case "Mystery":
			if (doYouWantToPreBookCasino.equalsIgnoreCase("Y")) {
				totalPrice = totalPrice + casinoFee;
			}
			break;

		default:
			break;
		}
		return totalPrice;
	}

	private double calcualteHST() {
		hst = 0.15 * totalPrice;
		return hst;
	}

	private	double calculateFinalPrice() {
		finalPrice = totalPrice + hst;
		return finalPrice;
	}

	void displayCruiseFinalPriceByAddingAllPrices(CruiseBooking[] cruiseDetails, String doYouWantToPreBookSpa,
			double spaCharges, String doYouWantCandleLightDinner, double candleLightDinnerCharges,
			String doYouWantToPreBookGames, double adventureGamesFee, String doYouWantToPreBookCasino, double casinoFee,
			int numberOfAdults, int numberOfChildrenAbove5) {
		doYouWantToPreBookMeal = checkIfMealRequired();
		for (int i = 0; i < cruiseDetails.length; i++) {
			if (cruiseNameSelected.equalsIgnoreCase(cruiseDetails[i].cruiseName)) {
				cruiseDetails[i].calculateCruisePriceForAdults(numberOfAdults);
				cruiseDetails[i].calculateCruisePriceForChildrenAbove5(numberOfChildrenAbove5);
				cruiseDetails[i].calculateBuffetPriceForAdults(numberOfAdults);
				cruiseDetails[i].calculateBuffetPriceForChildrenAbove5(numberOfChildrenAbove5);
				cruiseDetails[i].calculateTotalPrice(cruiseNameSelected, doYouWantToPreBookMeal, doYouWantToPreBookSpa,
						spaCharges, doYouWantCandleLightDinner, candleLightDinnerCharges, doYouWantToPreBookGames,
						adventureGamesFee, doYouWantToPreBookCasino, casinoFee);
				cruiseDetails[i].calcualteHST();
				cruiseDetails[i].calculateFinalPrice();
				cruiseDetails[i].displayCruisePackageDetails(numberOfAdults, numberOfChildrenAbove5,
						doYouWantToPreBookMeal, doYouWantToPreBookSpa, doYouWantCandleLightDinner,
						doYouWantToPreBookGames, doYouWantToPreBookCasino, spaCharges, candleLightDinnerCharges,
						adventureGamesFee, casinoFee);
				break;
			}
		}
	}

	private	void displayCruisePackageDetails(int numberOfAdults, int numberOfChildrenAbove5, String doYouWantToPreBookMeal,
			String doYouWantToPreBookSpa, String doYouWantCandleLightDinner, String doYouWantToPreBookGames,
			String doYouWantToPreBookCasino, double spaCharges, double candleLightDinnerCharges,
			double adventureGamesFee, double casinoFee) {

		System.out.println("\nYour Package includes:\n");
		System.out.println(cruiseName + " Adults 		@	" + numberOfAdults + "	:$" + totalAdultCruisePrice);
		System.out.println(
				cruiseName + " Children above 5	@	" + numberOfChildrenAbove5 + "	:$" + totalKidsAbove5CruisePrice);
		if (doYouWantToPreBookMeal.equalsIgnoreCase("Y")) {
			System.out.println("Buffet Special Price Adults	@	" + numberOfAdults + "	:$" + totalAdultMealPrice);
			System.out.println("Buffet Special Price Children above 5 @	" + numberOfChildrenAbove5 + "	:$"
					+ totalKidsAbove5MealPrice);
		}
		if (doYouWantToPreBookSpa.equalsIgnoreCase("Y")) {
			System.out.println("Spa charges 					@ " + numberOfAdults + " :$" + spaCharges);
		}
		if (doYouWantCandleLightDinner.equalsIgnoreCase("Y")) {
			System.out.println(
					"Candle light dinner charges 			@ " + numberOfAdults + " :$" + candleLightDinnerCharges);
		}
		if (doYouWantToPreBookGames.equalsIgnoreCase("Y")) {
			System.out.println("Adventure Games entry fee 			@ " + numberOfAdults + " :$" + adventureGamesFee);
		}
		if (doYouWantToPreBookCasino.equalsIgnoreCase("Y")) {
			System.out.println("Casino entry fee 				@ " + numberOfAdults + " :$" + casinoFee);
		}
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 15%					:$" + nf.format(hst));
		System.out.println("Final Price					:$" + nf.format(finalPrice));
	}

}
