package Week10Again;

import java.text.NumberFormat;

public class HotelBooking extends UserDetails {
	 NumberFormat nf2 = NumberFormat.getInstance();

	protected String roomType;
	protected double roomCharges;
	int maxAdult, maxChildren;

	public HotelBooking() {
	}

	private int numberOfChildren = 0, numberOfAdults = 0;
	private String doYouWantAdditionalMeal = "";
	private double totalPrice = 0.0;

	private int checkNumberOfAdults() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 || numberOfAdults == 0 || numberOfAdults > maxAdult) {
			while (!((numberOfAdults > 0) && (numberOfAdults <= maxAdult))) {
				validateNumOfAdults(numberOfAdults);
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	private int checkNumberOfChildren() {
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		if (numberOfChildren < 0 || numberOfChildren > maxChildren) {
			while (!((numberOfChildren > 0) && (numberOfChildren <= maxChildren))) {
				maximumAttempts();
				System.out.println("Enter valid number of children.");
				numberOfChildren = sc.nextInt();
			}
		}
		return numberOfChildren;
	}

	private double calculateTotalPrice(String doYouWantAdditionalMeal, int numOfAdults, int numOfChildren,
			int numOfStayDays) {
		if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
			totalPrice = (numOfAdults * numOfStayDays * 25) + (numOfChildren * numOfStayDays * 5) + roomCharges;
		} else if (doYouWantAdditionalMeal.equalsIgnoreCase("N")) {
			totalPrice = roomCharges;
		}
		return totalPrice;
	}

	private double calculateFinalPrice() {
		return (totalPrice + (0.18 * totalPrice));
	}

	protected void displayHotelFinalPriceByAddingAllPrices(int numOfStayDays) {
		System.out.println(
				"All rooms come with free breakfast. Do you want to add lunch in your room as well at a discounted pre-booking rate of $25/ adult and $5/ child.(Y/N)");
		doYouWantAdditionalMeal = checkIfMealRequired();
		numberOfAdults = checkNumberOfAdults();
		numberOfChildren = checkNumberOfChildren();
		calculateTotalPrice(doYouWantAdditionalMeal, numberOfAdults, numberOfChildren, numOfStayDays);
		calculateFinalPrice();
		displayHotelPackageDetails(doYouWantAdditionalMeal, numberOfAdults, numberOfChildren, numOfStayDays);
	}

	private void displayHotelPackageDetails(String doYouWantAdditionalMeal, int numOfAdults, int numOfChildren,
			int numOfStayDays) {
		System.out.println("\nThe total amount you will be charged is:\n");
		System.out.println(
				roomType + " 	@ " + numOfStayDays + " nights				:$" + (numOfStayDays * roomCharges));
		if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
			System.out.println("Lunch Pre-Booked Special Rate Adults	@ " + numberOfAdults + "	:$"
					+ (numOfAdults * numOfStayDays * 25));
			System.out.println("Lunch Pre-Booked Special Rate Children	@ " + numberOfChildren + "	:$"
					+ (numOfChildren * numOfStayDays * 5));
		}
		System.out.println("Total Price				 	:$" + nf2.format(totalPrice));
		System.out.println("HST	@ 18%					:$" + nf2.format(0.18 * totalPrice));
		System.out.println("Final Price					:$" + nf2.format(totalPrice + (0.18 * totalPrice)));
	}

	@Override
	protected String checkIfMealRequired() {
		System.out.println("Meal is $200 per person");
		return null;
	}
}
