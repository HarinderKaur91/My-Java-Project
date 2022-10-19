package AssignmentWeek7;

import java.text.NumberFormat;

public class CruiseDetails {
	String cruiseName;
	double adultCruisePrice;
	double kidsAbove5CruisePrice;
	int daysOfCruise;

	NumberFormat nf = NumberFormat.getInstance();

	public CruiseDetails(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
	}

	void getDaysAndCruisePrice(String cruiseName) {
		System.out.println("\nThe cruise that you have selected is " + cruiseName + " which is a " + daysOfCruise + " day cruise");
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
	
	double calculateTotalPriceWithoutMeal() {
		totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice;
		return totalPrice;
	}

	double calculateTotalPriceWithMeal() {
		totalPrice = totalAdultCruisePrice + totalKidsAbove5CruisePrice + totalAdultMealPrice + totalKidsAbove5MealPrice;
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

	void displayCruisePackageDetails(int numberOfAdults, int numberOfChildrenAbove5) {
		System.out.println("\nYour Package includes:\n");
		System.out.println(cruiseName + " Adults 		@	" + numberOfAdults + "	:$" + totalAdultCruisePrice);
		System.out.println(cruiseName + " Children above 5	@	" + numberOfChildrenAbove5 + "	:$" + totalKidsAbove5CruisePrice);
		System.out.println("Buffet Special Price Adults	@	" + numberOfAdults + "	:$" + totalAdultMealPrice);
		System.out.println("Buffet Special Price Children above 5 @	" + numberOfChildrenAbove5 + "	:$" + totalKidsAbove5MealPrice);
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 15%					:$" + nf.format(hst));
		System.out.println("Final Price					:$" + nf.format(finalPrice));
	}
}
