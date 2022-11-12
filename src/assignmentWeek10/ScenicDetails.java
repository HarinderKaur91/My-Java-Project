package assignmentWeek10;

public class ScenicDetails extends CruiseBooking {

	double spaCharges;
	String doYouWantToPreBookSpa = "";
	int spaAttempts = 0;

	public ScenicDetails() {
		super("Scenic", 43.99, 12.99, 3);
	}

	 String checkIfSpaRequired() {
		System.out.println("\nScenic Cruise provides SPA for $50 per person.Do you want to pre book for SPA. Press(Y/N)");
		doYouWantToPreBookSpa = sc.next();
		while (!((doYouWantToPreBookSpa.equalsIgnoreCase("Y")) || (doYouWantToPreBookSpa.equalsIgnoreCase("N")))) {
			spaAttempts++;
			if (spaAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookSpa = sc.next();
		}
		return doYouWantToPreBookSpa;

	}
	double calculateSpaCharges(int numberOfAdults) {
 		spaCharges = numberOfAdults * 50;
		return spaCharges;
	}
}
