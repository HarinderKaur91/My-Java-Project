package assignmentWeek10;

public class DiscoveryDetails extends CruiseBooking {
	double adventureGamesFee;
	String doYouWantToPreBookGames = " ";
	int gamesAttempts = 0;

	public DiscoveryDetails() {
		super("Discovery", 39.99, 9.99, 4);
	}

	String checkIfWantsToPreBookGames() {
		System.out.println("\nDiscovery Cruise provides ADVENTURE GAMES with entry fee of $50 per person.");
		System.out.println("Do you want to pre book for adventure games. Press(Y/N)");
		doYouWantToPreBookGames = sc.next();
		while (!((doYouWantToPreBookGames.equalsIgnoreCase("Y")) || (doYouWantToPreBookGames.equalsIgnoreCase("N")))) {
			gamesAttempts++;
			if (gamesAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID INPUT! Enter Y or N");
			doYouWantToPreBookGames = sc.next();
		}
		return doYouWantToPreBookGames;
	}

	public double calculateAdventureGamesFee(int numberOfAdults) {
		adventureGamesFee = numberOfAdults * 50;
		return adventureGamesFee;
	}
}
