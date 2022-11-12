package assignmentWeek10Updated;

public class DiscoveryDetails extends CruiseBooking {
	public DiscoveryDetails() {
		super("Discovery", 39.99, 9.99, 4, "ADVENTURE GAMES entry fee");
	}

	protected String checkIfWantsToBookSpecialCruiseFeature() {
		System.out.println(
				"\nDiscovery Cruise provides ADVENTURE GAMES with entry fee of $50 per person.Do you want to pre book for adventure games. Press(Y/N)");
		return (sc.next());
	}

	public double calcualateSpecialCharges(int numberOfAdults) {
		return (numberOfAdults * 50);
	}
}
