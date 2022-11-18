package assignmentWeek11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMars {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Simulation simulation = new Simulation();
		ArrayList<Rocket> fleetOfR1Rockets = new ArrayList<>();
		ArrayList<Rocket> fleetOfR2Rockets = new ArrayList<>();

		String costChoice;
		String doYouWantToChooseAgain;

		System.out.println(
				"\n**********MISSION MARS**********\n\nLets build a colony on MARS using following material....\n");
		ArrayList<Item> arrayList = simulation.loadItems("C:\\Users\\Harry\\Desktop\\phase-1.txt");
		System.out.println("\nPress Y to PROCEED or any other character to DECLINE.");
		String userChoice = sc.next();
		if (userChoice.equalsIgnoreCase("Y")) {
			do {
				System.out.println("\nSELECT one of the following fleets to start loading with rockets(R1/R2)");
				System.out.println(
						"The R1 Rocket is light weight, agile and pretty safe and can carry 8 TONNES of cargo.");
				System.out.println(
						"The R2 Rocket is heavier than the R1 but much safer and can carry 11 TONNES of cargo.");
				String rocketType = sc.next();
				if (rocketType.equalsIgnoreCase("R1")) {
					fleetOfR1Rockets = simulation.loadU1(arrayList);
					System.out
							.println("\nR1 fleet is LOADED now. Do you want to calcualte total COST of R1 fleet.(Y/N)");
					costChoice = sc.next();
					if (costChoice.equalsIgnoreCase("Y")) {
						System.out.println("\nTOTAL COST FOR R1 fleet: $" + simulation.runSimulation(fleetOfR1Rockets)
								+ " Million");
					}
				} else if (rocketType.equalsIgnoreCase("R2")) {
					fleetOfR2Rockets = simulation.loadU2(arrayList);
					System.out
							.println("\nR2 fleet is LOADED now. Do you want to calcualte total COST of R2 fleet.(Y/N)");
					costChoice = sc.next();
					if (costChoice.equalsIgnoreCase("Y")) {
						System.out.println("\nTOTAL COST for R2 fleet: $" + simulation.runSimulation(fleetOfR2Rockets)
								+ " Million");
					}
				} else {
					System.out.println("Goodbye!");
				}
				System.out.println("\nDo you want to load another rocket .(Y/N)");
				doYouWantToChooseAgain = sc.next();
				if (!doYouWantToChooseAgain.equalsIgnoreCase("Y")) {
					System.out.println("Thank you!Hope you enjoyed launching rockets.");
				}
			} while (doYouWantToChooseAgain.equalsIgnoreCase("Y"));
			sc.close();
		} else {
			System.out.println("You have missed the fun!");
		}
	}
}
