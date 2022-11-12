package assignmentWeek10Updated;

public class FamilySuite extends HotelBooking {

	public FamilySuite() {
		super("Family");
	}

	protected double calculateRoomRate(int numOfStayDays) {
		return (numOfStayDays * 230);
	}

	protected int checkNumberOfAdults() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 || numberOfAdults == 0 || numberOfAdults > 4) {
			while (!((numberOfAdults > 0) && (numberOfAdults < 5))) {
				validateNumOfAdults(numberOfAdults);
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	protected int checkNumberOfChildren() {
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		if (numberOfChildren < 0 || numberOfChildren > 4) {
			while (!((numberOfChildren > 0) && (numberOfChildren < 5))) {
				validateNumOfChildren();
				numberOfChildren = sc.nextInt();
			}
		}
		return numberOfChildren;
	}
}
