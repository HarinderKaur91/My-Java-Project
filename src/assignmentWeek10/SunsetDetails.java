package assignmentWeek10;

public class SunsetDetails extends CruiseBooking {

	double candleLightDinnerCharges;
	String doYouWantToPreBookDinner = " ";
	int dinnerAttempts = 0;

	public SunsetDetails() {
		super("Sunset", 52.99, 15.99, 1);
	}

	String checkIfCandleLightDinnerRequired() {
		System.out.println("\nSunset Cruise provides CANDLE LIGHT DINNER for $45 per person.");
		System.out.println("Do you want to pre book for candle light dinner. Press(Y/N)");
		doYouWantToPreBookDinner = sc.next();
		while (!((doYouWantToPreBookDinner.equalsIgnoreCase("Y"))
				|| (doYouWantToPreBookDinner.equalsIgnoreCase("N")))) {
			dinnerAttempts++;
			if (dinnerAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookDinner = sc.next();
		}
		return doYouWantToPreBookDinner;
	}

	public double calculateCandleLightDinnerCharges(int numberOfAdults) {
		candleLightDinnerCharges = numberOfAdults * 45;
		return candleLightDinnerCharges;
	}
}
