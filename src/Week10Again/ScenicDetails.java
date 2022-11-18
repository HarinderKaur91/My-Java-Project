package Week10Again;
public class ScenicDetails extends CruiseBooking {
	public ScenicDetails(String nameOfCruise, double priceOfAdults, double priceOfKidsAbove5, int numOfDays,
			String specialFeature, double cruiseUniqueCharges) {
		cruiseName = nameOfCruise;
		adultCruisePrice = priceOfAdults;
		kidsAbove5CruisePrice = priceOfKidsAbove5;
		daysOfCruise = numOfDays;
		specialCruiseFeature = specialFeature;
		cruiseSpecialCharges = cruiseUniqueCharges;
	}
}
