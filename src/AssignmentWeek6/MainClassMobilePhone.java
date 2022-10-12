//This code is handling invalid inputs also

package AssignmentWeek6;

import java.util.Scanner;

public class MainClassMobilePhone {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MobilePhone mp = new MobilePhone(); // creating instance of MobilePhone class

		System.out.println("Please enter the Brand that you want to choose from: Apple/ Samsung");

		String brandOfPhone = sc.nextLine();

		while (!(brandOfPhone.equalsIgnoreCase("Apple") || brandOfPhone.equalsIgnoreCase("Samsung"))) {// loop to handle
																										// invalid input
			System.out.println("You have entered INVALID brand. Please choose from Apple or Samsung");
			brandOfPhone = sc.nextLine();
		}

		String modelOfPhone = mp.modelSelection(brandOfPhone);// Invoking modelSelection method from the CellPhone class

		System.out.println("\nPlease select the plan that you want to opt for: Rogers/ Telus/ Bell");

		String planOfPhone = sc.nextLine();

		while (!(planOfPhone.equalsIgnoreCase("Rogers") || planOfPhone.equalsIgnoreCase("Bell")
				|| planOfPhone.equalsIgnoreCase("Telus"))) {
			System.out.println("INVALID plan. Please enter valid plan name");
			planOfPhone = sc.nextLine();
		}

		int costOfPlan = mp.planCost(planOfPhone);
		int costOfPhone = mp.phoneCost(brandOfPhone, modelOfPhone);
		mp.outputBasedOnSelection(modelOfPhone, planOfPhone, costOfPlan, costOfPhone);
	}
}
