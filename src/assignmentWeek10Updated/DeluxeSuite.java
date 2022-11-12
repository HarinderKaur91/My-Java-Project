package assignmentWeek10Updated;

public class DeluxeSuite extends HotelBooking {

	public DeluxeSuite() {
		super("Deluxe");
	}

	protected double calculateRoomRate(int numOfStayDays) {
		return (numOfStayDays * 180);
	}

	protected int checkNumberOfAdults() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 || numberOfAdults == 0 || numberOfAdults > 2) {
			while (!((numberOfAdults > 0) && (numberOfAdults < 3))) {
				validateNumOfAdults(numberOfAdults);
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	protected int checkNumberOfChildren() {
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		if (numberOfChildren < 0 || numberOfChildren > 2) {
			while (!((numberOfChildren > 0) && (numberOfChildren < 3))) {
				validateNumOfChildren();
				numberOfChildren = sc.nextInt();
			}
		}
		return numberOfChildren;
	}
}
