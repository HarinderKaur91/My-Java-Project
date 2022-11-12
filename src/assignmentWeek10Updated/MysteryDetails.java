package assignmentWeek10Updated;

public class MysteryDetails extends CruiseBooking {
	public MysteryDetails() {
		super("Mystery", 45.99, 12.99, 2, "CASINO entry fee");
	}

	protected String checkIfWantsToBookSpecialCruiseFeature() {
		System.out.println(
				"\nMystery Cruise provides CASINO with entry fee of $50 per person.Do you want to pre book for Casino. Press(Y/N)");
		return (sc.next());
	}

	public double calcualateSpecialCharges(int numberOfAdults) {
		return (numberOfAdults * 20);
	}
}
