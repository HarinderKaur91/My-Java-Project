package assignmentWeek10Updated;

public class ScenicDetails extends CruiseBooking {
	public ScenicDetails() {
		super("Scenic", 43.99, 12.99, 3, "SPA charges");
	}

	protected String checkIfWantsToBookSpecialCruiseFeature() {
		System.out.println("\nScenic Cruise provides SPA for $50 per person.Do you want to pre book for SPA. Press(Y/N)");
		return (sc.next());
	}

	protected double calcualateSpecialCharges(int numberOfAdults) {
		return (numberOfAdults * 50);
	}
}
