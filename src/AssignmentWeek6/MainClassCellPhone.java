package AssignmentWeek6;

import java.util.Scanner;

public class MainClassCellPhone {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CellPhone cp = new CellPhone(); // creating instance of CellPhone class

		System.out.println("Please enter the Brand that you want to choose from: Apple/ Samsung");
		String brandOfPhone = sc.next();

		String modelOfPhone = cp.modelSelection(brandOfPhone);// Invoking modelSelection method from the CellPhone class
		System.out.println(modelOfPhone);

		System.out.println("Please select the plan that you want to opt for: Rogers/ Telus/ Bell");
		String planOfPhone = sc.next();

		int costOfPlan = cp.planCost(planOfPhone); //Invoking planCost method from CellPhone class
		int costOfPhone = cp.phoneCost(brandOfPhone, modelOfPhone);//Invoking phoneCost method from CellPhone class

		cp.outputBasedOnSelection(modelOfPhone, planOfPhone, costOfPlan, costOfPhone);//Invoking outputBasedOnSelection method from CellPhone class

	}

}
