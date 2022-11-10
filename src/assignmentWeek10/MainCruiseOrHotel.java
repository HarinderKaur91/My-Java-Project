package assignmentWeek10;

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

		int numberOfServiceAttempts = 0;
		double spaCharges = 0.0;
		double candleLightDinnerCharges = 0.0;
		double adventureGamesFee = 0.0;
		double casinoFee = 0.0;
		String doYouWantToContinue = "";

		int i = 0;
		int numberOfAdults = 0;
		int numberOfChildren = 0;
		int numberOfChildrenAbove5 = 0;
		double deluxeRoomRate = 0.0;
		double familyRoomRate = 0.0;
		String doYouWantToChooseAgain;
		String userChoice = "";
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
				hotelBooking[i].hotelStay(hotelBooking);
				if (hotelBooking[i].typeOfRoom.equalsIgnoreCase("Deluxe")) {
					numberOfAdults = deluxe.checkNumberOfAdults();
					numberOfChildren = deluxe.checkNumberOfChildren();
					deluxeRoomRate = deluxe.calculateDeluxeRoomRate(hotelBooking[i].numOfStayDays);
				} else if (hotelBooking[i].typeOfRoom.equalsIgnoreCase("Family")) {
					numberOfAdults = family.checkNumberOfAdults();
					numberOfChildren = family.checkNumberOfChildren();
					familyRoomRate = family.calculateFamilyRoomRate(hotelBooking[i].numOfStayDays);
				}
				hotelBooking[i].displayHotelFinalPriceByAddingAllPrices(hotelBooking, hotelBooking[i].numOfStayDays,
						deluxeRoomRate, familyRoomRate, numberOfAdults, numberOfChildren);
			} else if (userChoice.equalsIgnoreCase("Cruise")) {
				String doYouWantToPreBookSpa = "";
				String doYouWantCandleLightDinner = "";
				String doYouWantToPreBookGames = "";
				String doYouWantToPreBookCasino = "";
				do {
					cruiseBooking[i].displayTypesOfCruise(cruiseBooking);
					System.out.println(
							"\nPlease press Y if you want to continue with the selection or press any other alphabet to select another.");
					doYouWantToContinue = sc.next();
				} while (!doYouWantToContinue.equalsIgnoreCase("Y"));

				numberOfAdults = cruiseBooking[i].numberOfAdultCheck();
				numberOfChildrenAbove5 = cruiseBooking[i].ageCheck();

				switch (cruiseBooking[i].cruiseNameSelected) {
				case "Scenic":
					doYouWantToPreBookSpa = scenic.checkIfSpaRequired();
					spaCharges = scenic.calculateSpaCharges(numberOfAdults);
					break;
				case "Sunset":
					doYouWantCandleLightDinner = sunset.checkIfCandleLightDinnerRequired();
					candleLightDinnerCharges = sunset.calculateCandleLightDinnerCharges(numberOfAdults);
					break;
				case "Discovery":
					doYouWantToPreBookGames = discovery.checkIfWantsToPreBookGames();
					adventureGamesFee = discovery.calculateAdventureGamesFee(numberOfAdults);
					break;
				case "Mystery":
					doYouWantToPreBookCasino = mystery.checkIfWantsToPreBookCasino();
					casinoFee = mystery.calculateCasinoFee(numberOfAdults);
					break;
				default:
					System.out.println("Invalid Input!");
					break;
				}
				cruiseBooking[i].displayCruiseFinalPriceByAddingAllPrices(cruiseBooking, doYouWantToPreBookSpa,
						spaCharges, doYouWantCandleLightDinner, candleLightDinnerCharges, doYouWantToPreBookGames,
						adventureGamesFee, doYouWantToPreBookCasino, casinoFee, numberOfAdults, numberOfChildrenAbove5);

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
