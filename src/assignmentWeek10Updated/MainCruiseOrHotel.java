package assignmentWeek10Updated;

import java.util.Scanner;

public class MainCruiseOrHotel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserDetails user = new UserDetails();
		ScenicDetails scenic = new ScenicDetails();
		SunsetDetails sunset = new SunsetDetails();
		DiscoveryDetails discovery = new DiscoveryDetails();
		MysteryDetails mystery = new MysteryDetails();
		CruiseBooking[] cruiseBooking = { scenic, sunset, discovery, mystery };

		DeluxeSuite deluxe = new DeluxeSuite();
		FamilySuite family = new FamilySuite();
		HotelBooking[] hotelBooking = { deluxe, family };

		String doYouWantToContinue, doYouWantToChooseAgain, userChoice, cruiseNameSelected;
		int i = 0, numberOfAdults, numberOfChildren, numberOfChildrenAbove5, numberOfServiceAttempts = 0;
		double cruiseSpecialCharges = 0, roomCharges = 0;
		user.userSignUp();
		do {
			System.out.println("Please enter the service you want to book Hotel / Cruise");
			userChoice = sc.next();
			while (!(userChoice.equalsIgnoreCase("Hotel") || userChoice.equalsIgnoreCase("Cruise"))) {
				numberOfServiceAttempts++;
				if (numberOfServiceAttempts > 2) {
					System.out.println("Attempts exceeded! Start again");
					System.exit(0);
				}
				System.out.println("You have entered INVALID service name. Please choose Hotel or Cruise");
				userChoice = sc.next();
			}
			if (userChoice.equalsIgnoreCase("Hotel")) {
				System.out.println("\nPlease enter the room you want to select");
				System.out.println("\nDeluxe: accommodates 2 adults and 2 children at the rate of $180/ night");
				System.out.println("Family: accommodates 4 adults and 4 children at $230/ night.");
				String roomSelected = sc.next();
				System.out.println("Enter the number of days of stay");
				int numOfStayDays = sc.nextInt();
				for (i = 0; i < hotelBooking.length; i++) {
					if (roomSelected.equalsIgnoreCase(hotelBooking[i].roomType)) {
						numberOfAdults = hotelBooking[i].checkNumberOfAdults();
						numberOfChildren = hotelBooking[i].checkNumberOfChildren();
						roomCharges = hotelBooking[i].calculateRoomRate(numOfStayDays);
						hotelBooking[i].displayHotelFinalPriceByAddingAllPrices(hotelBooking, roomSelected,
								numberOfAdults, numberOfChildren, roomCharges, numOfStayDays);
						break;
					}
				}
			} else if (userChoice.equalsIgnoreCase("Cruise")) {
				do {
					cruiseBooking[i].displayTypesOfCruise(cruiseBooking);
					System.out.println("Please enter the cruise that you want to select.");
					cruiseNameSelected = sc.next();
					cruiseBooking[i].validateCruiseName(cruiseBooking, cruiseNameSelected);
					System.out.println(
							"\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
					doYouWantToContinue = sc.next();
				} while (!doYouWantToContinue.equalsIgnoreCase("Y"));
				numberOfAdults = cruiseBooking[i].numberOfAdultCheck();
				System.out.println("Enter the number of children");
				numberOfChildren = sc.nextInt();
				numberOfChildrenAbove5 = cruiseBooking[i].ageCheck(numberOfChildren);
				for (i = 0; i < cruiseBooking.length; i++) {
					if (cruiseNameSelected.equalsIgnoreCase(cruiseBooking[i].cruiseName)) {
						if (cruiseBooking[i].checkIfWantsToBookSpecialCruiseFeature().equalsIgnoreCase("Y")) {
							cruiseSpecialCharges = cruiseBooking[i].calcualateSpecialCharges(numberOfAdults);
							break;
						}
						break;
					}
				}
				cruiseBooking[i].displayCruiseFinalPriceByAddingAllPrices(cruiseBooking, cruiseNameSelected,
						cruiseSpecialCharges, numberOfAdults, numberOfChildrenAbove5);
				user.checkIfUserWantsToChangePersonalInfo();
				System.out.println("\nThank you for using the service!");
			}
			System.out.println("\nDo you want to book another Hotel Room or Cruise.(Y/N)");
			doYouWantToChooseAgain = sc.next();
			if (!doYouWantToChooseAgain.equalsIgnoreCase("Y")) {
				System.out.println("Thank you for booking the service!");
			}
		} while (doYouWantToChooseAgain.equalsIgnoreCase("Y"));
	}
}
