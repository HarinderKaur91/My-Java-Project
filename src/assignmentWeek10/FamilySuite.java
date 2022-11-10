package assignmentWeek10;

public class FamilySuite extends HotelBooking {

	public FamilySuite() {
		super("Family Suite");
	}

	int childAttempts = 0;
	double familyRoomRate = 0.0;

	double calculateFamilyRoomRate(int numOfStayDays) {
		familyRoomRate = numOfStayDays * 230;
		return familyRoomRate;
	}

	int checkNumberOfAdults() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 || numberOfAdults == 0 || numberOfAdults > 4) {
			while (!((numberOfAdults > 0) && (numberOfAdults < 5))) {
				adultAttempts++;
				if (adultAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				if (numberOfAdults == 0) {
					System.out.println("There should be atleast 1 adult to book the room");
				}
				System.out.println("Enter valid number of adults.Family suite can accommodate 4 adults");
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	int checkNumberOfChildren() {
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		if (numberOfChildren < 0 || numberOfChildren > 4) {
			while (!((numberOfChildren > 0) && (numberOfChildren < 5))) {
				childAttempts++;
				if (childAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				System.out.println("Enter valid number of children.Family suite can accommodate 4 children");
				numberOfChildren = sc.nextInt();
			}
		}
		return numberOfChildren;
	}
}
