package Week10Again;

public class DeluxeSuite extends HotelBooking {

	public DeluxeSuite(String typeOfRoom, double roomRate, int maxNumOfAdults, int maxNumOfChildren) {
		roomType = typeOfRoom;
		roomCharges = roomRate;
		maxAdult = maxNumOfAdults;
		maxChildren = maxNumOfChildren;
	}
}
