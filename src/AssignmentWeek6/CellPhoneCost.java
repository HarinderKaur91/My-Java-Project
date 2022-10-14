// This code is handling invalid inputs also

package AssignmentWeek6;

import java.util.Scanner;

public class CellPhoneCost {

	Scanner sc = new Scanner(System.in);

	String modelSelection(String brandOfPhone) { // method returning model of the phone based on the brand

		String modelOfPhone = "";
		int numberOfModelAttempts = 0;

		if (brandOfPhone.equalsIgnoreCase("Apple")) {
			System.out.println("Please enter the model that you want to buy from below\n" + "IPhone 14\n"
					+ "IPhone 14 pro\n" + "IPhone 14 pro max\n" + "IPhone 14 mini");
			modelOfPhone = sc.nextLine();
			
			while (!(modelOfPhone.equalsIgnoreCase("IPhone 14") || modelOfPhone.equalsIgnoreCase("IPhone 14 pro")
					|| modelOfPhone.equalsIgnoreCase("IPhone 14 pro max")
					|| modelOfPhone.equalsIgnoreCase("IPhone 14 mini"))) {
				numberOfModelAttempts++;
				if (numberOfModelAttempts > 2) {
					System.out.println("Attempts exceeded!. Start again");
					System.exit(0);
				}
				System.out.println("You have entered INVALID model name. Please enter valid model name");
				modelOfPhone = sc.nextLine();
			}
		} else if (brandOfPhone.equalsIgnoreCase("Samsung")) {
			System.out.println("Please enter the model that you want to buy from below\n" + "S22\n" + "S22+\n"
					+ "S22 Ultra\n" + "S22FE");
			modelOfPhone = sc.nextLine();
			
			while (!(modelOfPhone.equalsIgnoreCase("S22") || modelOfPhone.equalsIgnoreCase("S22+")
					|| modelOfPhone.equalsIgnoreCase("S22 Ultra") || modelOfPhone.equalsIgnoreCase("S22FE"))) {
				numberOfModelAttempts++;
				if (numberOfModelAttempts > 2) {
					System.out.println("Attempts exceeded!. Start again");
					System.exit(0);
				}
				System.out.println("You have entered INVALID model name. Please enter valid model name from the list");
				modelOfPhone = sc.nextLine();
			}
		}
		return modelOfPhone;
	}

	int calculatePhoneCost(String brandOfPhone, String modelOfPhone) {// method returning monthly cost of the phone
																		// based on brand and model
		int costOfPhone = 0;
		if (brandOfPhone.equalsIgnoreCase("Samsung")) {
			switch (modelOfPhone) {
			case "S22":
				costOfPhone = 25;
				break;
			case "S22+":
				costOfPhone = 35;
				break;
			case "S22 Ultra":
				costOfPhone = 55;
				break;
			case "S22FE":
				costOfPhone = 20;
				break;
			}
		} else if (brandOfPhone.equalsIgnoreCase("Apple")) {
			switch (modelOfPhone) {
			case "IPhone 14":
				costOfPhone = 30;
				break;
			case "IPhone 14 pro":
				costOfPhone = 40;
				break;
			case "IPhone 14 pro max":
				costOfPhone = 65;
				break;
			case "IPhone 14 mini":
				costOfPhone = 25;
				break;
			}
		}
		return costOfPhone;
	}

	int calculatePlanCost(String planOfPhone) { // method returning monthly cost of the plan based on plan
		int costOfPlan = 0;
		if (planOfPhone.equalsIgnoreCase("Rogers")) {
			costOfPlan = 70;
		} else if (planOfPhone.equalsIgnoreCase("Bell")) {
			costOfPlan = 80;
		} else if (planOfPhone.equalsIgnoreCase("Telus")) {
			costOfPlan = 75;
		}
		return costOfPlan;
	}

	void calculateTotalCost(String modelOfPhone, String planOfPhone, int costOfPlan, int costOfPhone) {
		System.out.println("\nYou have Selected " + modelOfPhone + " with " + planOfPhone + " Plan");
		System.out.println("\nYour Phone Tab will be		: $" + costOfPhone);
		System.out.println("Your Monthly Plan will be 	: $" + costOfPlan);
		System.out.println("Total Monthly Amount		: $" + (costOfPhone + costOfPlan));
	}
}
