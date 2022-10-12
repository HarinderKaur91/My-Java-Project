package ClassAndObjects;

import java.util.Scanner;

public class MainClassLicense {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter your current license");
		String currentLicense = sc.next();
		//ClassName referenceVariable = new ClassName();
		MethodWithReturnType methodWR = new MethodWithReturnType();

		String licenseToBeIssued = methodWR.licenseType(currentLicense);

		switch (licenseToBeIssued) {
		case "G1":
			System.out.println("You have to pay $100 to get G1 license");
			break;
		case "G2":
			System.out.println("You have to pay $120 to get G2 license");
			break;
		case "G":
			System.out.println("You have to pay $70 to get G license");
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
	}

}
