package assignmentWeek10;

public class MysteryDetails extends CruiseBooking {
	double casinoFee;
	String doYouWantToPreBookCasino = " ";
	int CasinoAttempts = 0;

	public MysteryDetails() {
		super("Mystery", 45.99, 12.99, 2);
	}

	String checkIfWantsToPreBookCasino() {
		System.out.println("\nMystery Cruise provides CASINO with entry fee of $50 per person.");
		System.out.println("Do you want to pre book for Casino. Press(Y/N)");
		doYouWantToPreBookCasino = sc.next();
		while (!((doYouWantToPreBookCasino.equalsIgnoreCase("Y"))
				|| (doYouWantToPreBookCasino.equalsIgnoreCase("N")))) {
			CasinoAttempts++;
			if (CasinoAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookCasino = sc.next();
		}
		return doYouWantToPreBookCasino;
	}

	public double calculateCasinoFee(int numberOfAdults) {
		casinoFee = numberOfAdults * 20;
		return casinoFee;
	}
}
