package AssignmentWeek6;

import java.util.Scanner;

public class CellPhone {

	Scanner sc = new Scanner(System.in);

	String modelSelection(String brandOfPhone) { //method returning model of the phone based on the brand
		String modelOfPhone;
		switch (brandOfPhone) {
		case "Apple":
			System.out.println("Please enter the model that you want to buy from below\n" + "IPhone 14\n"
					+ "IPhone 14 pro\n" + "IPhone 14 pro max\n" + "IPhone 14 mini");
			modelOfPhone = sc.nextLine();
			break;
		case "Samsung":
			System.out.println("Please enter the model that you want to buy from below\n" + "S22\n" + "S22+\n"
					+ "S22 Ultra\n" + "S22FE");
			modelOfPhone = sc.nextLine();
			break;
		default:
			modelOfPhone = "Invalid Input";
			break;
		}
		return modelOfPhone;
	}

	int phoneCost(String brandOfPhone, String modelOfPhone) {// method returning monthly cost of the phone based on brand and model
		int costOfPhone = 0;
		switch (brandOfPhone) {
		case "Samsung":
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
			default:
				break;
			}
		case "Apple":
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
			default:
				break;
			}
		default:
			break;
		}
		return costOfPhone;
	}

	int planCost(String planOfPhone) { // method returning monthly cost of the plan based on plan
		int costOfPlan;
		if (planOfPhone.equals("Rogers")) {
			costOfPlan = 70;
		} else if (planOfPhone.equals("Bell")) {
			costOfPlan = 80;
		} else {
			costOfPlan = 75;
		}
		return costOfPlan;
	}

	void outputBasedOnSelection(String modelOfPhone, String planOfPhone, int costOfPlan, int costOfPhone) {//method calculating total monthly amount based on model and plan
		System.out.println("You have Selected " + modelOfPhone + " with " + planOfPhone + " Plan");
		System.out.println("Your Phone Tab will be		:$" + costOfPhone);
		System.out.println("Your Monthly Plan will be 	:$" + costOfPlan);
		System.out.println("Total Monthly Amount		:$" + (costOfPhone + costOfPlan));
	}

}
