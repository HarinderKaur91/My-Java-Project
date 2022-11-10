package assignmentWeek10;

public class DeluxeSuite extends HotelBooking {

	public DeluxeSuite() {
		super("Deluxe Suite");
	}

	int childAttempts = 0;
	double deluxeRoomRate = 0.0;

	double calculateDeluxeRoomRate(int numOfStayDays) {
		deluxeRoomRate = numOfStayDays * 180;
		return deluxeRoomRate;
	}

	int checkNumberOfAdults() {
		System.out.println("Enter the number of adults");
		numberOfAdults = sc.nextInt();
		if (numberOfAdults < 0 || numberOfAdults == 0 || numberOfAdults > 2) {
			while (!((numberOfAdults > 0) && (numberOfAdults < 3))) {
				adultAttempts++;
				if (adultAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				if (numberOfAdults == 0) {
					System.out.println("There should be atleast 1 adult to book the room");
				}
				System.out.println("Enter valid number of adults.Deluxe suite can accommodate 2 adults");
				numberOfAdults = sc.nextInt();
			}
		}
		return numberOfAdults;
	}

	int checkNumberOfChildren() {
		System.out.println("Enter the number of children");
		numberOfChildren = sc.nextInt();
		if (numberOfChildren < 0 || numberOfChildren > 2) {
			while (!((numberOfChildren > 0) && (numberOfChildren < 3))) {
				childAttempts++;
				if (childAttempts > 2) {
					System.out.println("Attempts exceeded! Start again.");
					System.exit(0);
				}
				System.out.println("Enter valid number of children.Deluxe suite can accommodate 2 children");
				numberOfChildren = sc.nextInt();
			}
		}
		return numberOfChildren;
	}
}
