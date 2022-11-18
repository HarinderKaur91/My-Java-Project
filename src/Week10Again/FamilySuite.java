package Week10Again;

public class FamilySuite extends HotelBooking {

	public FamilySuite(String typeOfRoom, double roomRate,int maxNumOfAdults, int maxNumOfChildren) {
		roomType = typeOfRoom;
		roomCharges = roomRate;
		maxAdult = maxNumOfAdults;
		maxChildren = maxNumOfChildren;
	}
}
