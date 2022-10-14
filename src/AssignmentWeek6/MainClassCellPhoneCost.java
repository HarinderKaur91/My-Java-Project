//This code is handling invalid inputs also

package AssignmentWeek6;

import java.util.Scanner;

public class MainClassCellPhoneCost {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CellPhoneCost cpc = new CellPhoneCost(); // creating instance of MobilePhone class

		int numberOfBrandAttempts = 0;
		int numberOfPlanAttempts = 0;
		String brandOfPhone = "";

		System.out.println("Please enter the Brand that you want to choose from: Apple/ Samsung");
		brandOfPhone = sc.nextLine();

		while (!(brandOfPhone.equalsIgnoreCase("Apple") || brandOfPhone.equalsIgnoreCase("Samsung"))) {// loop to handle invalid inputs
			
			numberOfBrandAttempts++;
			if (numberOfBrandAttempts > 2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("You have entered INVALID brand. Please choose from Apple or Samsung");
			brandOfPhone = sc.nextLine();
		}

		String modelOfPhone = cpc.modelSelection(brandOfPhone);// Invoking modelSelection method from the MobilePhone class

		System.out.println("\nPlease select the plan that you want to opt for: Rogers/ Telus/ Bell");
		String planOfPhone = sc.nextLine();

		while (!(planOfPhone.equalsIgnoreCase("Rogers") || planOfPhone.equalsIgnoreCase("Bell")|| planOfPhone.equalsIgnoreCase("Telus"))) {// loop to handle invalid input
			numberOfPlanAttempts++;
			if(numberOfPlanAttempts>2) {
				System.out.println("Attempts exceeded! Start again");
				System.exit(0);
			}
			System.out.println("INVALID plan. Please enter valid plan name");
			planOfPhone = sc.nextLine();
		}

		int costOfPhone = cpc.calculatePhoneCost(brandOfPhone, modelOfPhone);// Invoking calculatePhoneCost method from MobilePhone class
		int costOfPlan = cpc.calculatePlanCost(planOfPhone);// Invoking calculatePlanCost method from MobilePhone class

		cpc.calculateTotalCost(modelOfPhone, planOfPhone, costOfPlan, costOfPhone);// Invoking calculateTotalCost method from MobilePhone class
																					
	}
}
