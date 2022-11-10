package assignmentWeek10;

import java.text.NumberFormat;

public class HotelBooking extends UserDetails {
	NumberFormat nf = NumberFormat.getInstance();
	String typeOfRoom;

	public HotelBooking(String typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}

	int numberOfChildren = 0;
	int numberOfAdults = 0;
	String doYouWantAdditionalMeal = "";
	int additionalMealAttempts = 0;
	double adultAdditionalMealPrice = 0.0;
	double childAdditionalMealPrice = 0.0;
	int adultAttempts = 0;
	private double hst = 0.0;
	private double totalPrice = 0.0;
	private double finalPrice = 0.0;
	int numOfStayDays = 0;

	void hotelStay(HotelBooking[] hotelBooking) {
		int roomAttempts = 0;
		int numOfStayDaysAttempts = 0;

		System.out.println("\nPlease enter the room you want to select");
		System.out.println("\nDeluxe: accommodates 2 adults and 2 children at the rate of $180/ night");
		System.out.println("Family: accommodates 4 adults and 4 children at $230/ night.");
		typeOfRoom = sc.next();

		while (!(typeOfRoom.equalsIgnoreCase("Deluxe") || typeOfRoom.equalsIgnoreCase("Family"))) {
			roomAttempts++;
			if (roomAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("You have entered INVALID room name. Please choose from valid names");
			typeOfRoom = sc.next();
		}

		System.out.println("Enter the number of days of stay");
		numOfStayDays = sc.nextInt();
		if (numOfStayDays == 0) {
			while (!(numOfStayDays > 0)) {
				numOfStayDaysAttempts++;
				if (numOfStayDaysAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				System.out.println("Number of stay days should be greater than 0.Enter again ");
				numOfStayDays = sc.nextInt();
			}
		}
	}

	private String checkIfAdditionalMealRequired() {
		System.out.println(
				"All rooms come with free breakfast. Do you want to add lunch in your room as well at a discounted pre-booking rate of $25/ adult and $5/ child.(Y/N)");
		doYouWantAdditionalMeal = sc.next();
		while (!((doYouWantAdditionalMeal.equalsIgnoreCase("Y")) || (doYouWantAdditionalMeal.equalsIgnoreCase("N")))) {
			additionalMealAttempts++;
			if (additionalMealAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantAdditionalMeal = sc.next();
		}
		return doYouWantAdditionalMeal;
	}

	private double calculateAdultAdditionalMealPrice(int numOfAdults) {
		adultAdditionalMealPrice = numOfAdults * 25;
		return adultAdditionalMealPrice;
	}

	private double calculateChildAdditionalMealPrice(int numOfChildren) {
		childAdditionalMealPrice = numOfChildren * 5;
		return childAdditionalMealPrice;
	}

	private double calculateTotalPrice(String typeOfRoom, String doYouWantAdditionalMeal, double deluxeRoomRate,
			double familyRoomRate) {
		if (typeOfRoom.equalsIgnoreCase("Deluxe")) {
			if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
				totalPrice = deluxeRoomRate + adultAdditionalMealPrice + childAdditionalMealPrice;
			} else {
				totalPrice = deluxeRoomRate;
			}
		} else if (typeOfRoom.equalsIgnoreCase("Family")) {
			if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
				totalPrice = familyRoomRate + adultAdditionalMealPrice + childAdditionalMealPrice;
			} else {
				totalPrice = familyRoomRate;
			}
		}
		return totalPrice;
	}

	private double calcualteHST() {
		hst = 0.18 * totalPrice;
		return hst;
	}

	private double calculateFinalPrice() {
		finalPrice = totalPrice + hst;
		return finalPrice;
	}

	 void displayHotelFinalPriceByAddingAllPrices(HotelBooking[] hotelBooking, int numOfStayDays, double deluxeRoomRate,
			double familyRoomRate, int numberOfAdults, int numberOfChildren) {

		doYouWantAdditionalMeal = checkIfAdditionalMealRequired();
		for (int i = 0; i < hotelBooking.length; i++) {
			if (typeOfRoom.equalsIgnoreCase(hotelBooking[i].typeOfRoom)) {
				hotelBooking[i].calculateAdultAdditionalMealPrice(numberOfAdults);
				hotelBooking[i].calculateChildAdditionalMealPrice(numberOfChildren);
				hotelBooking[i].calculateTotalPrice(typeOfRoom, doYouWantAdditionalMeal, deluxeRoomRate,
						familyRoomRate);
				hotelBooking[i].calcualteHST();
				hotelBooking[i].calculateFinalPrice();
				hotelBooking[i].displayHotelPackageDetails(typeOfRoom, doYouWantAdditionalMeal, numOfStayDays,
						deluxeRoomRate, familyRoomRate, numberOfAdults, numberOfChildren);
				break;
			}
		}
	}

	private void displayHotelPackageDetails(String typeOfRoom, String doYouWantAdditionalMeal, int numOfStayDays,
			double deluxeRoomRate, double familyRoomRate, int numberOfAdults, int numberOfChildren) {

		System.out.println("\nThe total amount you will be charged is:\n");
		if (typeOfRoom.equalsIgnoreCase("Deluxe"))
			System.out.println(typeOfRoom + " 	@ " + numOfStayDays + " nights				:$" + deluxeRoomRate);
		if (typeOfRoom.equalsIgnoreCase("Family"))
			System.out.println(typeOfRoom + " 	@ " + numOfStayDays + " nights				:$" + familyRoomRate);
		if (doYouWantAdditionalMeal.equalsIgnoreCase("Y")) {
			System.out.println(
					"Lunch Pre-Booked Special Rate Adults	@ " + numberOfAdults + "	:$" + adultAdditionalMealPrice);
			System.out.println(
					"Lunch Pre-Booked Special Rate Children	@ " + numberOfChildren + "	:$" + childAdditionalMealPrice);
		}
		System.out.println("Total Price				 	:$" + nf.format(totalPrice));
		System.out.println("HST	@ 18%					:$" + nf.format(hst));
		System.out.println("Final Price					:$" + nf.format(finalPrice));
	}
}
