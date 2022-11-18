package assignmentWeek10Updated;

import java.text.NumberFormat;

public abstract class HotelBooking extends UserDetails {
	NumberFormat nf = NumberFormat.getInstance();
	String roomType;

	public HotelBooking(String typeOfRoom) {
		roomType = typeOfRoom;
	}

	int numberOfChildren = 0, numberOfAdults = 0, additionalMealAttempts = 0, adultAttempts = 0, numOfStayDays = 0,
			numOfStayDaysAttempts;
	private int childAttempts = 0;
	private String doYouWantAdditionalMeal = "";
	private double totalPrice = 0.0;

	protected abstract int checkNumberOfAdults();

	protected abstract int checkNumberOfChildren();

	protected abstract double calculateRoomRate(int numOfStayDays);

	protected void validateNumOfChildren() {
		childAttempts++;
		if (childAttempts > 2) {
			System.out.println("Attempts exceeded! Start again.");
			System.exit(0);
		}
		System.out.println("Enter valid number of children.");
	}

	private double calculateTotalPrice(String doYouWantAdditionalMeal, int numOfAdults, int numOfChildren,
			int numOfStayDays, double roomCharges) {
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

	protected void displayHotelFinalPriceByAddingAllPrices(HotelBooking[] hotelBooking, String roomSelected,
			int numberOfAdults, int numberOfChildren, double roomCharges, int numOfStayDays) {
		System.out.println(
				"All rooms come with free breakfast. Do you want to add lunch in your room as well at a discounted pre-booking rate of $25/ adult and $5/ child.(Y/N)");
		doYouWantAdditionalMeal = checkIfMealRequired();
		for (int i = 0; i < hotelBooking.length; i++) {
			if (roomSelected.equalsIgnoreCase(hotelBooking[i].roomType)) {
				hotelBooking[i].calculateTotalPrice(doYouWantAdditionalMeal, numberOfAdults, numberOfChildren,
						numOfStayDays, roomCharges);
				hotelBooking[i].calculateFinalPrice();
				hotelBooking[i].displayHotelPackageDetails(doYouWantAdditionalMeal, numberOfAdults, numberOfChildren,
						roomCharges, numOfStayDays);
				break;
			}
		}
	}

	private void displayHotelPackageDetails(String doYouWantAdditionalMeal, int numOfAdults, int numOfChildren,
			double roomCharges, int numOfStayDays) {
		System.out.println("\nThe total amount you will be charged is:\n");
		System.out.println(roomType + " 	@ " + numOfStayDays + " nights				:$" + roomCharges);
		if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
			System.out.println("Lunch Pre-Booked Special Rate Adults	@ " + numberOfAdults + "	:$"
					+ (numOfAdults * numOfStayDays * 25));
			System.out.println("Lunch Pre-Booked Special Rate Children	@ " + numberOfChildren + "	:$"
					+ (numOfChildren * numOfStayDays * 5));
		}
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 18%					:$" + nf.format(0.18 * totalPrice));
		System.out.println("Final Price					:$" + nf.format(totalPrice + (0.18 * totalPrice)));
	}
}
