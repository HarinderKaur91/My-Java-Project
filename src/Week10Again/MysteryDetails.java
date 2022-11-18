package Week10Again;

public class MysteryDetails extends CruiseBooking {
	public MysteryDetails(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays,
			String specialFeature, double cruiseUniqueCharges) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
		specialCruiseFeature = specialFeature;
		cruiseSpecialCharges = cruiseUniqueCharges;
	}
}
