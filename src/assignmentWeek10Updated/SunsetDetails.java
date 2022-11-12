package assignmentWeek10Updated;

public class SunsetDetails extends CruiseBooking {

	public SunsetDetails() {
		super("Sunset", 52.99, 15.99, 1, "CANDLE LIGHT DINNER Charges");
	}

	protected String checkIfWantsToBookSpecialCruiseFeature() {
		System.out.println(
				"\nSunset Cruise provides CANDLE LIGHT DINNER for $45 per person.Do you want to pre book for candle light dinner. Press(Y/N)");
		return (sc.next());
	}

	public double calcualateSpecialCharges(int numberOfAdults) {
		return (numberOfAdults * 45);
	}
}
